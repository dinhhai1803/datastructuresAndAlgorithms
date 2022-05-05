#include<stdio.h>

int BinarySearch(int A[], int n, int x){
    int low = 0, high = n-1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(x == A[mid]) return mid;
        else if(x < A[mid]) high = mid - 1;
        else low = low + 1;
    }
    return -1;
}

int BinarySearchRecursive(int A[], int low, int high, int x){
    int mid;
    if(low > high) return -1;
    else{
        mid = low + (high - low)/2;
        if(x == A[mid]) return mid;
        else if(x < A[mid]) return BinarySearchRecursive(A, low, mid - 1, x);
        else return BinarySearchRecursive(A, mid + 1, high, x);
    }
}

int FindFirstOccurrence(int A[], int n, int x){
    int low = 0, high = n-1, result = -1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(x == A[mid]) {
            result = mid;
            high = mid - 1;      // move in the left to find the first ocurrence 
        }       
        else if(x < A[mid]) high = mid - 1;
        else low = low + 1;
    }
    return result;
}

int FindLastOccurrence(int A[], int n, int x){
    int low = 0, high = n-1, result = -1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(x == A[mid]) {
            result = mid;
            low = mid + 1;      // move in the left to find the first ocurrence 
        }       
        else if(x < A[mid]) high = mid - 1;
        else low = low + 1;
    }
    return result;
}


int main(){
    int x, index, index1, index2, index3;
    int A[] = {2, 3, 5, 7, 7, 7, 47, 2345};
    printf("Enter the number: ");
    scanf("%d", &x);

    index = BinarySearch(A, 8, x);
    index1 = BinarySearchRecursive(A, 0, 8, x);
    index2 = FindFirstOccurrence(A, 8, x);
    index3 = FindLastOccurrence(A, 8, x);

    if (index != -1) printf("Number %d is found at index %d", x, index);
    else printf("The number %d not found", x);
    printf("\n");

    if (index1 != -1) printf("Number %d is found at index %d", x, index1);
    else printf("The number %d not found", x);
    printf("\n");

    if(index2 != -1) printf("Number %d is found FIRST at index %d", x, index2);
    else printf("The number %d not found", x);
    printf("\n");

    if(index3 != -1) printf("Number %d is found LAST at index %d", x, index3);
    else printf("The number %d not found", x);
    printf("\n");

    if(index1 <= 0) printf("The number %d does not exist in array", x);
    else printf("The number %d occur %d time ", x, index3 - index2 + 1);

}