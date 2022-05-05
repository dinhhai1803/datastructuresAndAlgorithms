#include<iostream>
#include<queue> 

using namespace std;

struct BstNode{
    char data;
    struct BstNode* left;
    struct BstNode* right;
};

void LevelOrdertraversal(BstNode* root){
    if(root == NULL) return;
    queue<BstNode*> Q;
    Q.push(root);               // push the root charo the queue
    while(!Q.empty()){          // while at least 1 discovered node
        BstNode* current = Q.front();
        cout<<current->data<<" ";
        if(current->left != NULL) Q.push(current->left);
        if(current->right != NULL) Q.push(current->right);
        Q.pop();                // remove the element at front
    }
}

    BstNode* GetNewNode(char data){
    BstNode* newNode = new BstNode();
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

BstNode* Insert(BstNode* root, char data ){
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
	/*Code To Test the logic
	  Creating an example tree
	                    M
			   / \
			  B   Q
			 / \   \
			A   C   Z
    */
	BstNode* root = NULL;
	root = Insert(root,'M'); root = Insert(root,'B');
	root = Insert(root,'Q'); root = Insert(root,'Z'); 
	root = Insert(root,'A'); root = Insert(root,'C');
	//Prchar Nodes in Level Order. 
	LevelOrdertraversal(root);
    
}


