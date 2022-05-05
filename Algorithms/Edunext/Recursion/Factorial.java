package Algorithms.Edunext.Recursion;

import javax.lang.model.util.ElementScanner14;

public class Factorial {
    
    static int factorial(int n){
        if(n == 0 )
            return 1;
        return n * factorial(n - 1);
    }

    static int fibonacci(int n){
        if(n <= 2)
            return 1;
        else    
            return fibonacci(n-1) + fibonacci(n-2); 
    }

    static void decToBin(int n){
        int q = n/2;
        int r = n%2;
        if(q>0){
            decToBin(q);
        }
        System.out.print(r + " ");
    }

    static void tail(int n){
        if(n > 0){
            System.out.print(n + " ");
            tail(n-1);
        }
    }

    static void reverse() throws Exception{
        char ch = (char)System.in.read();
        if(ch != '\n'){
            reverse();
            System.out.print(ch);
        } 
    }

    static boolean even(int n){
        if(n==0) 
            return true;
        return odd(n-1);
    }

    static boolean odd(int n){
        if(n==0) 
            return false;
        return even(n-1);
    }

    static int A(int m, int n){
        if(m==0)
            return n + 1;
        else{
            if(n==0)
                return A(m-1, 1);
            else
                return A(m-1, A(m, n-1));
        }
    }

    static int i = 0;
    static void thapHN(int n, char A, char B, char C){
        if(n==1){
            i++;
            System.out.println(i + ": Move disk from " + A + " to " + C);
        }
        else{
            thapHN(n-1, A, C, B);
            thapHN(1, A, B, C);
            thapHN(n-1, B, A, C);
        }
    }

    static int GCD(int a, int b){
        if(b != 0)
            return GCD(b, a%b);
        else    
            return a;
    }

    static int pow(int x, int n){
        if(n==0)
            return 1;
        return x * pow(x, n-1);
    }
    
    static int count = 0;
    static int posTotal(int x){
        
        if(x < 10){
            count += x;
            return count;
        }
        else{    
            count += x%10;
            posTotal(x/10);
        }
        return count;
        
    }

    static int count(int k, int n){
        if(n == 0 || n == k)
            return 1;
        else{
            return count(k, n-1) + count(k-1, n-1);
        }
    }

    static int countArray = 0;
    static int totalArray(int[] array, int n){
        if(n == 0){
            countArray += array[0];
            return countArray;
        }
        else{
            countArray += array[n-1];
            totalArray(array, n);
        }
        return countArray;
    }


    public static void main(String[] args) throws Exception {
        int x = 5;
        int y = 2;
        int z = 2022;
        int[] arr = {1,2,3,4,5};

        // System.out.println("Factorial of " + x + " : " + factorial(x));
        // System.out.println();

        // System.out.print("Fibonacci: ");
        // for( int i=1; i < 10; i++){
        //     System.out.print(fibonacci(i) + " ");
        // }
        // System.out.println("\n");

        // System.out.print(x + " to binary is : " );
        // decToBin(x);
        // tail(x);
        // System.out.println("Enter a string to be reversed: ");
        // reverse();

        // if(odd(x))
        //     System.out.println(x + " is an odd number");
        // else    
        //     System.out.println(x + " is an even number");

        // System.out.println(A(1, 2));

        

        // thapHN(64, 'A', 'B', 'C');
        //System.out.println("GCD of " + x + " and " + y + " : " + GCD(x, y));
        //System.out.println(x + " ^ " + y + " : "  + pow(x, y));
        // System.out.println("Total of positive number of " + z + " : " + posTotal(z));
        // System.out.println("Result: " + count(x, y));
        System.out.println("Total of array: " + totalArray(arr, arr.length));
    }

}
