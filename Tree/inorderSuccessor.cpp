#include<iostream>
using namespace std;

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

struct Node* FindMin(struct Node* root){
    if(root == NULL) return NULL;
    while(root->left != NULL){
        root = root->left;
    }
    return root;
}

Node* Find(Node* root, int data){
    if(root == NULL) return NULL;
    else if(root->data == data) return root;
    else if(root->data < data) return Find(root->right, data);
    else return Find(root->left, data); 
}

struct Node* Getsuccessor(struct Node* root, int data){
    struct Node* current = Find(root, data);        // find the node want to find successor
    if(current == NULL) return NULL;
    // case 1: Node has right subtree
    if(current->right != NULL){
        return FindMin(current->right);             // find the leftmost of the right subtree of current node
    }
    else{
        // case 2: Node does not have right subtree
        struct Node* successor = NULL;
        struct Node* ancestor = root;
        while(ancestor != current){
            if(current->data < ancestor->data){     // current node is in left subtree of ancestor
                successor = ancestor;               // so far this is the deepest node for which current node is in the left
                ancestor = ancestor->left;          // move the ancestor down along the left subtree

            }
            else
                ancestor = ancestor->right;
        }
        return ancestor;
    }
}

//Function to visit nodes in Inorder
void Inorder(Node *root) {
	if(root == NULL) return;
 
	Inorder(root->left);       //Visit left subtree
	printf("%d ",root->data);  //Print data
	Inorder(root->right);      // Visit right subtree
}

Node* Insert(Node *root,char data) {
	if(root == NULL) {
		root = new Node();
		root->data = data;
		root->left = root->right = NULL;
	}
	else if(data <= root->data)
		root->left = Insert(root->left,data);
	else 
		root->right = Insert(root->right,data);
	return root;
}
 
int main() {
	/*Code To Test the logic
	  Creating an example tree
	            5
			   / \
			  3   10
			 / \   \
			1   4   11
    */
	Node* root = NULL;
	root = Insert(root,5); root = Insert(root,10);
	root = Insert(root,3); root = Insert(root,4); 
	root = Insert(root,1); root = Insert(root,11);

	//Print Nodes in Inorder
	cout<<"Inorder Traversal: ";
	Inorder(root);
	cout<<"\n";

	// Find Inorder successor of some node. 
    int target = 5;
	struct Node* successor = Getsuccessor(root,target);
	if(successor == NULL) cout<<"No successor Found\n";
	else
    cout<<"Successor of " << target << " is "<<successor->data<<"\n";
}