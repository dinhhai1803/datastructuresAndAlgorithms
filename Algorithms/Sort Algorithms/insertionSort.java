package Algorithms;

public class insertionSort {

    static void insertionSort(int[] a, int n){
        for(int i=1; i<n; i++){             // check from position 1 to the end
            int value = a[i];
            int hole = i;
            while (hole > 0 && a[hole -1] > value){ // value at sorted part > value at hole
                a[hole] = a[hole-1];        // shift the value to right 
                hole = hole - 1;        // break the while loop or continute to shift
            }
            a[hole] = value;            // swap value at hole and hole-1 position
        }
    }

    static void print(int a[], String msg){
        System.out.println(msg);
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {3, 6, 2, 8, 1, 9, 0, 5, 4, 7};
        print(array, "Original array: ");
        
        insertionSort(array, 10);
        print(array, "After sorting: ");

    }
}
