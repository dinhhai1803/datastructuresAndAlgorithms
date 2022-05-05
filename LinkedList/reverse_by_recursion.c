#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
}Node;

Node* head;

void Reverse(Node* p){          // pass the head to this function

    if(p->next == NULL){        // exit condition ( when it reach to the last node)
        head = p;               // head now is the last node
        return;
    }
    Reverse(p->next);            // travel to the end of linked list
    Node* q = p->next;           // create a node q which is the last node
    q->next = p;                 // reverse the link backward
    p->next = NULL;              // delete the old link of node p to reverse and link to a new one
}

int main(){

}