#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
}Node;

Node* head;

void Insert(int data){
    Node* temp = (Node*)malloc(sizeof(Node*));
    temp->data = data;
    temp->next = head;
    head = temp;

}

// void Print(){
//     Node* temp = head;
//     printf("List is :  ");
//     while(temp != NULL){
//         printf("%d  ", temp->data);
//         temp = temp->next;
//     }
// }

void Print(Node* p){
    if(p == NULL){              // base condition
        return;
    }
    printf("%d  ",p->data);      // print data of node p          
    Print(p->next);             // recurive call
}

void Delete(int n){
    Node* temp1 = head;
    if(n==1){
        head = temp1->next;         // head point to the second node
        free(temp1);
        return;
    }
    for (int i=0; i<n-2; i++){
        temp1 = temp1->next;        // temp1 point to (n-1)th node
    }
    Node* temp2 = temp1->next;      // nth node;
    temp1->next = temp2->next;      // (n-1)th node link to (n+1)th node
    free(temp2);
}

int main(){
    head = NULL;
    Insert(1);
    Insert(2);
    Insert(3);
    Insert(4);
 //   Delete(2);
    Print(head);
}