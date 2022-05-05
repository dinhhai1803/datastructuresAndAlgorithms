#include<stdio.h>

#define MAX_SIZE 101
int A[MAX_SIZE];
int top = -1;
int count =0;

int Push(int data){
    if(top == MAX_SIZE-1){
        printf("Error: Stack overflow \n");
        return;
    }
    else{
        top++;
        A[top] = data;
        count++;
    }
    return count;
}

void Pop(){
    if(top == -1){
        printf("Error: The stack is empty \n");
        return;
    }
    top--;
}

int Top(){
    if(top == -1){
        printf("Error: The stack is empty \n");
        return;
    }
    return A[top];
}

void Print(){
    if(top == -1){
        printf("Error: The stack is empty \n");
        return;
    }
    else{
        for(int i=0; i<count; i++){
            printf("Stack:  ");
            printf("%d ", A[i]);
            printf("\n");
        }
    }
}

int main(){
    Push(1);
    Push(2);
    Push(3);
    Push(4);
    Push(5);
    Print();
}