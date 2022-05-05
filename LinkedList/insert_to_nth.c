#include<stdio.h>
#include<stdlib.h>

typedef struct NODE{
    int data;
    struct NODE* next;
}Node;
struct NODE* head;

void Print(){
    Node* temp = head;
    printf("List: ");
    while(temp != NULL){
        printf("%d  ",temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void Insert(int data, int n){
    Node* temp1 = (Node*)malloc(sizeof(Node*));
 //   Node* temp1 = new Node();
    temp1->data = data;
    temp1->next = NULL;
    if(n==1){                           // insert at te first node
        temp1->next = head;
        head = temp1;
        return;
    }
    Node* temp2 = head;                 // create a node at the nth position, start from head
    for(int i=0; i<n-2; i++){           // move to the (n-1)th position
        temp2 = temp2->next;            // point temp2 to (n-1)th position  ( temp2 is the (n-1)th node)
    }
    temp1->next = temp2->next;          // set the link of new node to the nth node
    temp2->next = temp1;                // set the link of (n-1)th node to the new node
}

int main(){
    head = NULL;
    int x;
    printf("Enter the number: ");
    scanf("%d", &x);
    Insert(x, 1);
    Insert(2,1);
    Insert(3,2);
    Insert(4,1);
    Insert(5,2);
    Print();
}