#include<iostream>
using namespace std;

struct Node{
    int data;
    struct Node* left;
    struct Node* right;
};

//Function to find minimum in a tree. 
Node* FindMin(Node* root)
{
	while(root->left != NULL) root = root->left;
	return root;
}

struct Node* Delete(Node* root, int data){
    if(root == NULL) return root;               // base condition
    else if (data < root->data) root->left = Delete(root->left, data);      // find the node want to delete
    else if (data > root->data) root->right = Delete(root->right, data);    // find the node want to delete
        // root is the node want to delete
        else{
            // case 1: No child(node want to delete is a leave)
            if (root->left == NULL && root->right == NULL){
                delete root;
                root = NULL;
            }

            // case 2: node want to delete have one child (left tree or right tree)
                // only have right sub tree
                else if(root->left == NULL){
                    struct Node* temp = root;       // store the current node
                    root = root->right;             // link to the right b=sub tree node of the current node
                    delete temp;                    // delete the current node
                }

                else if(root->right == NULL){
                    struct Node* temp = root;
                    root = root->left;
                    delete temp;
                }
            // case 3: node want to delete have 2 children
                else {
                    struct Node* temp = FindMin(root->right);   // find min value of the right sub tree
                                                                // of current node (which has value > all node in left tree and < right sub tree)
                    root->data = temp->data;                        // asign the deleted node to the min_value sub tree node 
                    root->right = Delete(root->right, temp->data);  // delete the duplicated node

                }
        }
    return root;
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

    cout<<"Inorder before deleting: ";
	Inorder(root);
	cout<<"\n";

	// Deleting node with value 5, change this value to test other cases
	root = Delete(root,5);

	//Print Nodes in Inorder
	cout<<"Inorder after deleting node 5: ";
	Inorder(root);
	cout<<"\n";
}