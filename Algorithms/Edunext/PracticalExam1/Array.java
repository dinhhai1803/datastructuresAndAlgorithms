import java.util.Scanner;

public class Array {
    private int n;
    private int[] array;

    public Array(int n){
        this.n = n;
        this.array = new int[n];
    }
    
    public int[] getArray() {
        return array;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void setArray(int[] array) {
        this.array = array;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<this.n; i++){
            System.out.println("Enter values of array: ");
            this.array[i] = scanner.nextInt();
        }
        System.out.println();
    }

    public void display(){
        System.out.println("Array: ");
        for(int i : this.array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int sumNoneRecur(){
        int total = 0;
        System.out.println("Total: ");
        for(int i : this.array){
            total+=i;
        }
        return total;
    }

    public int sumRecur(int n){
        if (n < 0) return 0;
        return this.array[n] + sumRecur(n-1);
    }

    public int findMax(){
        int max = this.array[0];
        for(int i=0; i < this.n; i++){
            if(max < this.array[i])
            max = this.array[i] ;
        }
        return max;
    }

    public int findMaxRecur(int n){
        if(n==0)
            return this.array[n];
        else
            return Math.max(this.array[n], findMaxRecur(n-1));
    }

    public boolean check(){
        for(int i=0; i<this.n - 1; i++){
            if(this.array[i] > this.array[i+1])
                return false;
        }
        return true;
    }

    public boolean checkRecur(int n){
        if(n < 2)
            return true;
        else {
            if (this.array[n] < this.array[n-1])
                return false;
            else
                return checkRecur(n-1);
        }
    }

    public boolean palin(){
        int j = (this.n -1);
        for(int i=0; i<n; i++){
            if(this.array[i] != this.array[j])
                return false;
            else{
                j--;    
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elemments of array: ");
        n = scanner.nextInt();
        Array a = new Array(n);
        scanner.nextLine();
        a.input();
        a.display();
        // System.out.println(a.sumNoneRecur());
        // System.out.println("Total: " + a.sumRecur(n - 1));
        // System.out.println("Max: " + a.findMax());
        // System.out.println("Max: " + a.findMaxRecur(n - 1));
        // if(a.checkRecur(n-1))
        //     System.out.println("This array had been sorted increased");
        // else
        //     System.out.println("This array had not been sorted increased");
        if(a.palin())
            System.out.println("True");
        else
            System.out.println("False");

    }
    
}