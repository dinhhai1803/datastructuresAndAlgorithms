// #include<iostream>
// using namespace std;

// struct BstNode {
//     char data;
//     BstNode* left;
//     BstNode* right;
// };

// void Preorder(BstNode* root){
//     if(root == NULL) return;                // base condition

//     printf("%c", root->data);
//     Preorder(root->left);
//     Preorder(root->right);
// }

// void Inorder(BstNode* root){
//     if(root == NULL) return;

//     Inorder(root->left);
//     printf("%c", root->data);
//     Inorder(root->right);
// }

// void Postorder(BstNode* root){
//     if(root == NULL) return;

//     Postorder(root->left);
//     Postorder(root->right);
//     printf("%c", root->data);
// }

// BstNode* GetNewNode(char data){
//     BstNode* newNode = new BstNode();
//     newNode->data = data;
//     newNode->left = newNode->right = NULL;
//     return newNode;
// }

// BstNode* Insert(BstNode* root, char data){
//     if(root == NULL){
//        root = GetNewNode(data);
//        return root;
//     }else if(data <= root->data){
//             root->left = Insert(root->left, data);
//         } else{
//             root->right = Insert(root->right, data);
//         }
//     return root;
// }

// int main(){
//     BstNode* root = NULL;
//     root = Insert(root, 'F');
//     root = Insert(root, 'D');
//     root = Insert(root, 'J');
//     root = Insert(root, 'B');
//     root = Insert(root, 'E');
//     root = Insert(root, 'G');
//     root = Insert(root, 'K');
//     root = Insert(root, 'A');
//     root = Insert(root, 'C');
//     root = Insert(root, 'I');

//     cout << "The Preorder: ";
//     cout << Preorder(root);
//  //   cout << "The Inorder: "<< Inorder(root);
//  //   cout << "The Postorder: "<< Postorder(root);
// }


#include<iostream>
using namespace std;
 
struct Node {
	char data;
	struct Node *left;
	struct Node *right;
};

//Function to visit nodes in Preorder
void Preorder(struct Node *root) {
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
	if(root == NULL) return;

	printf("%c ",root->data); // Print data
	Preorder(root->left);     // Visit left subtree
	Preorder(root->right);    // Visit right subtree
}

//Function to visit nodes in Inorder
void Inorder(Node *root) {
	if(root == NULL) return;

	Inorder(root->left);       //Visit left subtree
	printf("%c ",root->data);  //Print data
	Inorder(root->right);      // Visit right subtree
}

//Function to visit nodes in Postorder
void Postorder(Node *root) {
	if(root == NULL) return;

	Postorder(root->left);    // Visit left subtree
	Postorder(root->right);   // Visit right subtree
	printf("%c ",root->data); // Print data
}

// Function to Insert Node in a Binary Search Tree
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
	                    M
			   / \
			  B   Q
			 / \   \
			A   C   Z
    */
	Node* root = NULL;
	root = Insert(root,'M'); root = Insert(root,'B');
	root = Insert(root,'Q'); root = Insert(root,'Z'); 
	root = Insert(root,'A'); root = Insert(root,'C');
	//Print Nodes in Preorder. 
	cout<<"Preorder: ";
	Preorder(root);
	cout<<"\n";
	//Print Nodes in Inorder
	cout<<"Inorder: ";
	Inorder(root);
	cout<<"\n";
	//Print Nodes in Postorder
	cout<<"Postorder: ";
	Postorder(root);
	cout<<"\n";
}
