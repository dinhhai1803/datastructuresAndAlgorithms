#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
}Node;

struct Node* head;

void Insert(int x){
    Node* temp = (Node*)malloc(sizeof(Node*));
    temp->data = x;
    temp->next = head;
    head = temp;
  
}

void Print(){
    Node* temp = head;
    printf("List is:  ");
    while (temp != NULL){
        printf("%d ", temp->data);
        temp = temp->next;
    } 
    printf("\n");
}

int main() {
    int n, i, x;
    head = NULL;        // the linked list is empty and head point nowhere

    printf("How many numbers do you want ?  ");
    scanf("%d", &n);
    for (i=0; i<n; i++){
        printf("Enter the number: ");
        scanf("%d", &x);
        Insert(x);
        Print();
    }
    return 0;
}
