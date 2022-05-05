package Algorithms;

public class selectionSort {
    static void selectionSort(int a[], int n){
        for(int i=0; i< n-1; i++){
            int iMin = i;       // ith position: elements from i till n-1 are candidete
             for(int j = i+1; j < n; j++){  // find the least value in the unsorted part
                if(a[j] < a[iMin]){
                    iMin = j;   // update the index of minimum element(increase the sorted part)
                }
             }
             int temp = a[i];   // swap the minimum value of the unsorted part with a[i]
             a[i] = a[iMin];
             a[iMin] = temp;
        }
    }

    static void print(int[] a, int n, String msg){
        System.out.println(msg);
        for(int i : a){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = {2, 7, 8, 5, 1, 0, 9, 3, 4, 6};
        print(array, 10, "Original array: ");
        System.out.println();
        selectionSort(array, 10);
        print(array, 10, "After sorting: ");
    }
}
