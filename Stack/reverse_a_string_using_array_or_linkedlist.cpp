#include <iostream>
#include <stack>
using namespace std;

//using array
void Reverse( char C[], int n){

    stack<char> S;

    for (int i=0; i<n; i++){            // push elements into stack
        S.push(C[i]);
    }
    for(int i=0; i<n; i++){             // reverse the list begin from the top
        C[i] = S.top();
        S.pop();
    }
}

// using linkedlist

// typedef struct Node{
//     int data;
//     struct Node* next;
// }Node;

// Node* head;
// void Reverse(){
//     if (head == NULL){
//         return;
//     }
//     stack<Node*> S;
//     Node* temp = head;
//     while(temp != NULL){
//         S.push(temp);
//         temp = temp->next;
//     }
//     temp = S.top();                 // temp node is the top of the stack
//     head = temp;                    // head point to temp
//     S.pop();                        // remove the node temp
//     while(!S.empty()){
//         temp->next = S.top();       // temp node (the top of the stack which has just removed) now point the link to the follow node (reverse link)
//         S.pop();                    // mode reverse the list
//         temp = temp->next;
//     }
//     temp->next = NULL;              // the last link point to null
// } 

int main(){
    char C[50];
    printf("Enter a string:  ");
    gets(C);
    Reverse(C,strlen(C));
    printf("Output:  %s", C);
}