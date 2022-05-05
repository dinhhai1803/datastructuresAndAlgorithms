package DataStructures.Tree.binarySearchTree;

public class BinarySearchTree {

    Node root;

    public void insert(Node node){
        root = insertHelper(root, node);
    } 

    private Node insertHelper(Node root, Node node){
        int data = node.data;

        if(root == null){           // the tree is empty
            root = node;
            return root;
        }
        else {
            if(data < root.data)
                root.left = insertHelper(root.left, node);
            else
                root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display(){
        displayHelper(root);
    }

    private void displayHelper(Node root){
        if(root != null){
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data){
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data){
        if(root == null) 
            return false;
        if (root.data == data)
            return true;
        if (root.data > data)
            return searchHelper(root.left, data);
        else
            return searchHelper(root.right, data);
        
    }

    public void remove(int data){

        if(search(data)){
            removeHelper(root, data);
        }
        else
            System.out.println(data + " not found");
    }

    public Node removeHelper(Node root, int data){
        if(root == null) return root;
        if(data < root.data){
            root.left = removeHelper(root.left, data);  // find in the left
        }
        else if(data > root.data)
            root.right = removeHelper(root.right, data);    // find in the right
        else{       // node found
            if(root.left == null && root.right == null){    // root found in a leaft
                root = null;
            }
            else if(root.right != null){                // find the successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else{           // find the predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root){       // find the least value below the right child of this node  
        root = root.right;                  // go to the right subtree
        while(root.left != null){           // find the least value in the right subtree(the left most)
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root){     // find the greatest value below the left child of this node  
        while(root.right != null){          // go to the right
            root = root.left;               // find the greatest value in the left subtree(the right most)
        }
        return root.data;  
    }
    
}
