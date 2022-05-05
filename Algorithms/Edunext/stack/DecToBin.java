package Algorithms.Edunext.stack;

import java.util.Stack;

public class DecToBin {
    public static void decToBinArray(int x){
        ArrayStack s = new ArrayStack();
        System.out.print( x + " in binary system is: ");
        while(x > 0){
            s.push(x%2);
            x = x/2;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void decToBinLinkedList(int x){
        LinkedListStack s = new LinkedListStack();
        System.out.print( x + " in binary system is: ");
        while(x > 0){
            s.push(x%2);
            x = x/2;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void decToBinStack(int x){
        Stack<Integer> s = new Stack<>();
        System.out.print( x + " in binary system is: ");
        while(x > 0){
            s.push(x%2);
            x = x/2;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        // decToBinArray(13);
        // System.out.println();
        decToBinLinkedList(13);
        System.out.println();
        decToBinStack(13);
    }
}
