package Algorithms.Edunext.stack;

import java.util.Stack;

public class CheckParenMatch {
    
    static boolean checkPair(char a, char b){
        if ((a == '[' && b == ']') || (a == '(' && b == ')')
         || (a == '{' && b == '}') || (a == '<' && b == '>'))
            return true;
        else
            return false;
    }
    
    static boolean isOpen(char x){
        if(x== '[' || x== '{' || x== '(' || x== '<')
        return true;
        else    
            return false;
    }

    static boolean isClose(char x){
        if(x== ']' || x== '}' || x== ')' || x== '>')
        return true;
        else    
            return false;
    }
    
    static boolean checkBalancedParenthensis(String text){
        char Token;
        Stack<Character> S = new Stack<>();
        for(int i=0; i<text.length(); i++){
            if(isOpen(text.charAt(i))){
                S.push(text.charAt(i));
            }
            else{
                if(isClose(text.charAt(i))){
                    if(S.empty()){
                        return false;
                    }
                    else{
                        Token = S.pop();
                        if(!checkPair(Token, text.charAt(i)))
                            return false;
                    }
                }
            }
        }
        return (S.isEmpty());
    }

    public static void main(String[] args) {
        String text = "{}()";

        boolean check = checkBalancedParenthensis(text);
        if (check){
            System.out.println("This string is balanced parenthesis ");
        }
        else {
            System.out.println("This string is not balanced parenthesis ");
        }
        
    }
}
