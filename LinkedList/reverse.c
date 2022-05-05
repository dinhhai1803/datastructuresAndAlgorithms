#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
}Node;

Node* head;

void Reverse(){
    Node *prev, *current, *next;
    current = head;
    prev = NULL;
    while(current != NULL){
        next = current->next;           // save the next node current node to "next"
        current->next = prev;           // reverse the link of current node to previous node
        prev = current;                 // increase previous node to current node
        current = next;                 // increase current node to the next node
    }
    head = prev;                        // head now is the last element of the list
}

void Insert(int data){
    Node* temp = (Node*)malloc(sizeof(Node*));
    temp->data = data;
    temp->next = head;
    head = temp;
}

void Print(){
    Node* temp = head;
    while(temp != NULL){
        printf("%d  ", temp->data);
        temp = temp->next;
    }
}

int main(){
    head = NULL;
    Insert(1);
    Insert(2);
    Insert(3);
    Insert(4);    
    Insert(5);
    printf("The list: ");
    Print();
    printf("\n");
    Reverse();
    printf("The list after reversing:  ");
    Print();
}