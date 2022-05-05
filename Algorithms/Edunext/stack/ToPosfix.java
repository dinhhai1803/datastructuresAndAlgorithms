package Algorithms.Edunext.stack;

import java.util.Stack;

public class ToPosfix {
    private String infix;

    public ToPosfix(String infix){
        this.infix = infix;
    }

    static boolean compare(char x, char y){
        if((x == y) || (x == '*' && y == '/') || (x == '/' && y == '*') || (x == '+' && y == '-') || (x == '-' && y == '+')) 
            return true;
        if((x == '(' || x == ')') && (y == '*' || y == '/' || y == '+' || y == '-') )
            return true;
        if((x == '*' || x == '/') && (y == '+' || y == '-') )
            return true;
        return false;
    }

    static boolean isOperators(char x){
        if(x == '+' || x == '-' || 
            x == '*' || x == '/'  )
            return true;
        return false;
    }

    public String changeToPosfix(){
        String posfix = "";
        Stack<Character> s = new Stack<>();


        for(int i=0; i<this.infix.length(); i++){
            if(this.infix.charAt(i) == ' ' || this.infix.charAt(i) == ',')
                continue;
            if(this.infix.charAt(i) == '('){
                s.push(this.infix.charAt(i));
            }
            if(this.infix.charAt(i) == ')'){

                while(!s.isEmpty() && s.peek() != '('){
                    posfix += s.peek();
                    s.pop();
                }
                posfix += this.infix.charAt(i);
            }
            if(Character.isDigit(this.infix.charAt(i))){
                posfix += this.infix.charAt(i);
            }
            if(ToPosfix.isOperators(this.infix.charAt(i))){
               
                while(!s.isEmpty() && ToPosfix.compare(s.peek(), this.infix.charAt(i))){
                    posfix += s.pop();
                }
                s.push(this.infix.charAt(i));
            }
        }
        while(!s.isEmpty()){
            posfix += s.pop();
        }
        // for(int j = 0; j<posfix.length(); j++){
        //     if(posfix.charAt(j) == '('){
        //         posfix.replace(posfix.charAt(j), ' ');
        //     }
        // }
        return posfix;
    }

    static int count(int a, int b, char x){
        switch(x){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public int evaluatingArithmeticExpressions(String posFix){
        Stack<Integer> s = new Stack<>();
        int a, b, z;
        char x;

        for(int i=0; i<posFix.length(); i++){
            if(posFix.charAt(i) == '(' || posFix.charAt(i) == ')')
                continue;
            if(Character.isDigit(posFix.charAt(i))){
                s.push((int) posFix.charAt(i) - '0') ;
            }
            if(!s.isEmpty() && ToPosfix.isOperators(posFix.charAt(i))){
                a = s.pop();
                b = s.pop();
                x = posFix.charAt(i);
                z = ToPosfix.count(a, b, x);
                s.push(z);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String infix = "2+2";
        ToPosfix toPosfix = new ToPosfix(infix);
        System.out.println( "The posFix: "+ toPosfix.changeToPosfix());
        System.out.println("Result: " + toPosfix.evaluatingArithmeticExpressions(toPosfix.changeToPosfix()));
    }
}
