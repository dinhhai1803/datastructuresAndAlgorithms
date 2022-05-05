#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
    struct Node* prev;

}Node;

Node* head;                            // global variale - pointer to the first node

struct Node* getNewNode(int x){         // function to create a new node
    Node* newNode = (Node*)malloc(sizeof(Node*));
    newNode->data = x;
    newNode->next = NULL;
    newNode->prev = NULL;
    return newNode;
}

void InsertAtFirst(int data){
    Node* temp = getNewNode(data);
    if(head == NULL){                   // the list is empty
        head = temp;                    // temp is the first and the only node in list now
        return;
    }
    // if node have already had nodes
    head->prev = temp;                  // set the previous link of the first( current node) to the new node has just been created
    temp->next = head;                  // set the next link of new node to the first node
    head = temp;                        // temp now is the first node of linked list

}

void Print(){
    Node* temp = head;
    printf("The list is:   ");
    while(temp != NULL){
        printf("%d  ",temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void reversePrint(){
    Node* temp = head;
    if(temp == NULL){               // the list is empty
        return;
    }
    while(temp->next != NULL){      // going to the last node
        temp = temp->next;
    }
    printf("The reversed list:  ");
    while(temp != NULL){            // traveling backward using prev pointer
        printf("%d  ", temp->data);
        temp = temp->prev;
    }
    printf("\n");

}

int main(){
    head = NULL;
    InsertAtFirst(2);
    InsertAtFirst(3);
    InsertAtFirst(4);
    InsertAtFirst(5);
    Print();
    reversePrint();
}