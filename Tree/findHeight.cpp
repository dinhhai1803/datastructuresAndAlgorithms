#include<iostream>
using namespace std;

struct BstNode{
    int data;
    struct BstNode* left;
    struct BstNode* right;
};

int FindHeight(struct BstNode* root){
    if(root == NULL)
    return -1;
    return max(FindHeight(root->left), FindHeight(root->right)) +1;        // the height of one node is max of its left-node and right-node
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

    int height = FindHeight(root);
    cout<< "The height of tree: "<<height;
}