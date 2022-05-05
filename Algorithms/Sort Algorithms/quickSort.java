package Algorithms;
     // quick sort = moves smaller elements to left of a pivot.
     //     recursively divide array in 2 partitions

     // run-time complexity = Best case O(n log(n))
     //                                        Average case O(n log(n))
     //                                        Worst case O(n^2) if already sorted
     
     // space complexity    = O(log(n)) due to recursion

public class quickSort {
    static void print(int[] array, String msg){
        System.out.println(msg);
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] array, int start, int end){
        if(start >= end) return;            // base condition

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);     // recurtion in the left of pivot
        quickSort(array, pivot + 1, end);       // recurtion in the right of pivot
    }

    static int partition(int[] array, int start, int end){
        int pivot = array[end];                 // pivot is the last element of array
        int i = start - 1;                      // i is before the start
        
        for(int j = start; j <= end - 1; j++){
            if(array[j] < pivot){
                i++;                            // forward i +1
                int temp = array[i];            // swap element at index i and j
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;                            // when j in the last index (= pivot)
        int temp = array[i];            // swap element at index i and pivot
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        print(array, "Original array: ");
        System.out.println();
        quickSort(array, 0, array.length - 1);
        print(array, "After sorting: ");
        
    }
}
