#include<stdio.h>

int FindRotationCount(int A[], int n){
    int low = 0, high = n-1;
    while(low <= high){
        if(A[low] <= A[high]) return low;               // case 1: array had been sorted and no rotation
        int mid = (low + high)/2;
        int next = (mid + 1) % n;
        int prev = (mid + n -1) % n;
        if(A[mid] <= A[next] && A[mid] <= A[prev])      // case 2: mid is the pivot
            return mid;
        else if (A[mid] <= A[high]) high = mid - 1;     // case 3: move to the left to find the pivot
        else if (A[mid] >= A[high]) low = mid + 1;      // case 4: move to the right to find the pivot 
    }
    return -1;                                          // invalid array
}

int CircularArraySearch(int A[], int n, int x){
    int low = 0, high = n-1;
    while(low <= high){
        int mid = (low + mid)/2;
        if(A[mid] == x) return mid;             // case 1: x is mid index
        if(A[mid] <= A[high]){                  // case 2: right half is sorted
            if(x > A[mid] && x <= A[high])
                low = mid + 1;                  // seaching in the right sorted half
            else    
                high = mid - 1; 
        }
        else{                                   // case 3: left half is sorted
            if(x >= A[low] && x < A[mid])
                high = mid - 1;                 // searching in the left half
            else
                low = mid + 1;
        }
    }
    return -1;                                  // not found
}

int main(){
    int A[] = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
    int number;
    int count = FindRotationCount(A, 10);
    int index = CircularArraySearch(A, 10, number);

    printf("Array is rotated %d times", count);
    
    printf("Enter the number want to find: ");
    scanf("%d", &number);
    
    if(index == -1) printf("Not found number %d", number);
    else printf("Number %d is at index %d", number, index);
}