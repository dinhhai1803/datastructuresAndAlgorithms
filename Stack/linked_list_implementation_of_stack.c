#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
}Node;

Node* top = NULL;

void Push(int data){
    Node* temp = (Node*)malloc(sizeof(Node*));
    temp->data = data;
    temp->next = top;                   // link temp node to the first current node
    top = temp;                         // temp now is the first node ( point to top to temp )
}

void Pop(){
    Node* temp ;
    if (top == NULL){
        printf("The list is empty ! ");
        return;
    }
    temp = top;                         // temp is the first element of stack
    top = top->next;                    // top point to the second node
    free(temp);                         // delete the first node 
}

void Print(){
    printf("The stack is :  ");
    Node* temp = top;
    while(temp != NULL){
        printf("%d  ", temp->data);
        temp = temp->next;
    }
    printf("\n------------------------------");
    printf("\n");
}

int main(){
    Push(1);
    Push(2);
    Push(3);
    Push(4);
    Push(5);
    Print();
    Pop();
    Print();
}