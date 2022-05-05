#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
}Node;

void Print(Node* p){
    if(p == NULL){              // exit condition
        return;
    }
    printf("%d  ",p->data);      // print data of node p          
    Print(p->next);             // recurive call
}

Node* Insert(Node* head, int data){
    Node* temp = (Node*)malloc(sizeof(Node*));
    temp->data = data;
    temp->next = NULL;
    if(head == NULL){           // the empty list
        head = temp;
    }
    else{
        Node* temp1 = head;
        while(temp1->next != NULL){
            temp1 = temp1->next;      
        }
        temp1->next = temp;
    }
    return head;
}

int main(){
    Node* head = NULL;
    head = Insert(head, 2);
    head = Insert(head, 3);
    head = Insert(head, 4);
    head = Insert(head, 5);
    head = Insert(head, 6);

    printf("List is :    ");
    Print(head);
}


