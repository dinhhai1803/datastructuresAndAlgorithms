#include<iostream>
using namespace std;

struct BstNode{
    int data;
    BstNode* left;
    BstNode* right;
};

int FindMin(BstNode* root){
    if(root == NULL){
        cout<<"Eroor: The tree is empty\n";
        return -1;
    }
    BstNode* current = root;
    while(current->left != NULL){
        current = current->left;
    }
    return current->data;
}

int FindMinByRecursion(BstNode* root){
    if(root == NULL){
        cout<<"Eroor: The tree is empty\n";
        return -1;
    }else if(root->left == NULL){
        return root->data;
    }
    return FindMinByRecursion(root->left);

}

int FindMax(BstNode* root){
    if(root == NULL){
        cout << "Error: The tree is empty!\n";
    }
    BstNode* current = root;
    while(current->left != NULL){
        current = current->right;
    }
    return current->data;
}

BstNode* GetNewNode(int data){
    BstNode* newNode = new BstNode();
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

BstNode* Insert(BstNode* root, int data ){
    if(root == NULL){               // empty tree
        root = GetNewNode(data);
        return root;
    }
    else if(data <= root->data){
        root->left = Insert(root->left, data);
        }else{
            root->right = Insert(root->right, data);
        }
    return root;
}

int main(){
    BstNode* root = NULL;
    int min, max;

    root = Insert(root, 15);
    root = Insert(root, 10);
    root = Insert(root, 20);
    root = Insert(root, 25);
    root = Insert(root, 8);
    root = Insert(root, 12);

    min = FindMin(root);
    max = FindMax(root);

    cout<<"The min number: "<<min << "\n";
    cout<<"The max number: "<<max;
}