package Algorithms;

public class mergeSort {
    
    static void merge(int[] L, int[] R, int[] A){
        int nL = L.length;
        int nR = R.length;
        int i, j, k;
        i = j = k = 0;          // index of left array, rigth array and the total array

        while(i < nL && j < nR ){       // check in the left and right part
            if(L[i] <= R[j]){           // value in left part < value in right part 
                A[k] = L[i];            // put value into the total array 
                k++;                    // increase index of k
                i++;
            }
            else{
                A[k] = R[j];
                k++;
                j++;
            }
        }
        // when 1 part finished
        while(i < nL){
            A[k] = L[i];
            i++;
            k++;
        }
        while(j < nR){
            A[k] = R[j];
            j++;
            k++;
        }
        
    }

    static void mergeSort(int[] A){
        int n = A.length;
        if(n < 2) return;       // base condition
        int mid = n/2;
        int[] left = new int[mid];      // create a new left array
        int[] right = new int[n - mid];
        for(int i = 0; i <= mid -1; i++){
            left[i] = A[i];             // left sub array
        }
        for(int i = mid; i <= n -1; i++){
            right[i-mid] = A[i];        // right sub array
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, A);
    }

    static void print(int[] A, String msg){
        System.out.println(msg);
        for(int i : A){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 9, 3, 1, 8, 6, 0, 5};
        print(array, "Original array: ");
        mergeSort(array);
        print(array, "After sorting: ");
    }
}
