#include<iostream>
using namespace std;

struct BstNode{
    int data;
    BstNode* left;
    BstNode* right;
};

bool IsSubTreeLesser(BstNode* root, int value){
    if(root == NULL) return true;
    if(root->data <= value
        && IsSubTreeLesser(root->left, value)
        && IsSubTreeLesser(root->right, value))
        return true;
    else    
        return false;
}

bool IsSubTreeGreater(BstNode* root, int value){
    if(root == NULL) return true;
    if(root->data >= value 
        && IsSubTreeGreater(root->left, value)
        && IsSubTreeGreater(root->right, value))
        return true;
    else
        return false;
}

bool IsBinarySearchTree(BstNode* root){
    if(root == NULL) return true;               // base condition
    if(IsSubTreeLesser(root->left, root->data)
        && IsSubTreeGreater(root->right, root->data)
        && IsBinarySearchTree(root->left)
        && IsBinarySearchTree(root->right))
        return true;
    else
        return false;
}

// condition to check the binary search tree with lower and upper bound
bool IsBstUtil(BstNode* root, int minValue, int maxValue){
    if(root == NULL) return true;
    if(root->data > minValue && root->data < maxValue
        && IsBstUtil(root->left, minValue, root->data)
        && IsBstUtil(root->right, root->data, maxValue))
        return true;
    else
        return false;
}

// condition to check the binary search tree with lower and upper bound
bool IsBSTByBound(BstNode* root){
    int minVal = 0;
    int maxVal = 50;
    return IsBstUtil(root, minVal, maxVal);
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

    if(IsBinarySearchTree(root)==true) 
        cout<<"This tree is a binary search tree";
    else 
        cout<<"This is not a binary search tree";

}