#include<stdio.h>

typedef struct Node{
    int data;
    struct Node* next;
}Node;


struct Node* front = NULL;
struct Node* rear = NULL;

// enqueue from the rear
void Enqueue(int x){
    Node* temp =                                 // create a temp node
            (Node*)malloc(sizeof(Node*));
    temp->data = x;
    temp->next = NULL;
    if (front == NULL && rear == NULL){                 // the queue is empty
        front = rear = temp;                            // front and rear now are the temp
        return;
    }
    rear->next = temp;                                  // set link from the rear to the temp node
    rear = temp;                                        // temp now is the rear of queue
}

// Dequeue from the front
void Dequeue(){
    struct Node* temp = front;                          // create a temp node and it oint to the front
    if (front == NULL) return;
    if (front == rear){                                 // the queue is empty
        front = rear = NULL;
    }else{
        front = front->next;                            // the current front now shift to the next one
    }
    free(temp);                                         // delete the first node(the front) in the queue 
}

void Print(){
    Node* temp = front;
    printf("The queue: ");
    while(temp != NULL){
        printf("%d  ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main(){
    Enqueue(1);
    Enqueue(2);
    Enqueue(3);
    Enqueue(4);
    Enqueue(5);
    Enqueue(6);
    Print();
}