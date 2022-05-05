public class SelectionSort{

    private int[] a = {5, 9, 2, 1, 7};
    private int n = a.length;

    public void selectionSort(){
        for(int i=0; i<(a.length-1); i++){
            int min = a[i], min_pos = i;
            for(int j = i+1; j<a.length; j++){
                if(a[j] < min){
                    min = a[j];
                    min_pos = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_pos];
            a[min_pos] = temp;
        }
    }

    public void insertionSort(){
        for(int i=1; i<a.length; i++){
            int x = a[i];
            int j = i;
            // tim j: vi tri can chen
            while(j>0 && x<a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = x;
        }
    }

    public void bubbleSort(){
        for(int i=0; i<a.length; i++){
            for(int j=(a.length-1); j>i; j--){
                if(a[j]<a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public void quickSort(int left, int right){
        int pivot = a[(left + right) /2];
        int i = left, j = right;
        while(i<j){
            while(a[i] < pivot) i++;
            while(a[j] > pivot)  j--;
            if(i<=j){
                int temp = a[i];
                a[i]= a[j];
                a[j] = temp;
                i++; j--;
            }
        }
        if(left<j) quickSort(left, j);
        if(right>i) quickSort(i, right);
    }

    //Gộp hai mảng con A[l...m] và A[m+1..r]
	void merge(int l, int m, int r)	{
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;
	 
	    /* Tạo các mảng tạm */
	    int L[] = new int[n1];
	    int R[] = new int[n2];
	 
	    /* Copy dữ liệu sang các mảng tạm */
	    for (i = 0; i < n1; i++)
	        L[i] = a[l + i];
	    for (j = 0; j < n2; j++)
	        R[j] = a[m + 1+ j];
	 

	    /* Gộp hai mảng tạm vừa rồi vào mảng A*/
	    i = 0; // Khởi tạo chỉ số bắt đầu của mảng con đầu tiên
	    j = 0; // Khởi tạo chỉ số bắt đầu của mảng con thứ hai
	    k = l; // IKhởi tạo chỉ số bắt đầu của mảng lưu kết quả
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) 
	            a[k] = L[i++];
	        else 
	            a[k] = R[j++];
	        k++;
	    }
	 
	    /* Copy phan con lai cua mang L vao A */
	    while (i < n1)
	        a[k++] = L[i++];
 
	    /* Copy phan còn lai cua mang R vao A */
	    while (j < n2)
	        a[k++] = R[j++];
	}

	void mergeSort(int left, int right)
	{
	    if (left < right)
	    {
	        int mid = (left+right)/2;
	        mergeSort(left,mid);
	        mergeSort(mid+1,right);
	        merge(left, mid, right);
	    }
	}

    void heapify(int n, int i) { 
	    int largest = i; // Initialize largest as root 
	    int l = 2*i + 1; // left = 2*i + 1 
	    int r = 2*i + 2; // right = 2*i + 2 
	  
	    // If left child is larger than root 
	    if (l < n && a[l] > a[largest]) 
	        largest = l; 
	  
	    // If right child is larger than largest so far 
	    if (r < n && a[r] > a[largest]) 
	        largest = r; 
	    // If largest is not root 
	    if (largest != i) { 
	        int temp = a[i];
	        a[i] = a[largest];
	        a[largest] = temp;
	        // Recursively heapify the affected sub-tree 
	        heapify(n, largest); 
	    } 
	} 
	void heapSort(int n) { 
	    // Build heap (rearrange array) 
	    for (int i = n / 2 - 1; i >= 0; i--) 
	        heapify(n, i); 
	  
	    // One by one extract an element from heap 
	    for (int i=n-1; i>0; i--) { 
	        // Move current root to end 
	        int temp = a[0];
	        a[0] = a[i];
	        a[i] = temp;
	  
	        // call max heapify on the reduced heap 
	        heapify(i, 0); 
	    } 
	}

    // The main function to that sorts arr[] of size n using
	// Radix Sort
	void radixSort(int arr[], int n){
	    // Find the maximum number to know number of digits
	    int m = getMax(arr, n);
	 
	    // Do counting sort for every digit. Note that instead
	    // of passing digit number, exp is passed. exp is 10^i
	    // where i is current digit number
	    for (int exp = 1; m / exp > 0; exp *= 10)
	        countSort(arr, n, exp);
	}

    int getMax(int arr[], int n) {
	    int mx = arr[0];
	    for (int i = 1; i < n; i++)
	        if (arr[i] > mx)
	            mx = arr[i];
	    return mx;
	}
	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	void countSort(int arr[], int n, int exp){
	    int output[] = new int[n]; // output array
	    int i, count[] = {0,0,0,0,0,0,0,0,0,0};
	 
	    // Store count of occurrences in count[]
	    for (i = 0; i < n; i++)
	        count[(arr[i] / exp) % 10]++;
	 
	    // Change count[i] so that count[i] now contains actual
	    //  position of this digit in output[]

	    // Change count[i] so that count[i] now contains actual
	    //  position of this digit in output[]
	    for (i = 1; i < 10; i++)
	        count[i] += count[i - 1];
	 
	    // Build the output array
	    for (i = n - 1; i >= 0; i--) {
	        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	        count[(arr[i] / exp) % 10]--;
	    }
	    // Copy the output array to arr[], so that arr[] now
	    // contains sorted numbers according to current digit
	    for (i = 0; i < n; i++)
	        arr[i] = output[i];
	}

    public void print(String msg){
        System.out.println(msg);
        for(int i : a){
            System.out.print( i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        s.print("Original array: ");
        // s.selectionSort();
        // s.insertionSort();
        // s.bubbleSort();
        // s.quickSort(0, (s.n -1));
        s.mergeSort(0, s.n -1);
        // s.heapSort(s.n);
        // s.radixSort(s.a, s.n);
        s.print("After sorting: ");
    }
}