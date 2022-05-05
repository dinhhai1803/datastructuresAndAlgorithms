package Algorithms.Edunext.Tree;

public class BST {
    private int data;
    private BST left,right;

    public BST(){

    }

    public BST(int x) {
        data=x;
        left=right=null;
    }  

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void insert(int x) {
    	if(x<data) {
            if ( left == null)
                left = new BST(x);
            else
                left.insert(x);
    	}
    	else {
            if (right == null)
                right = new BST(x);
            else
                right.insert(x);
    	}
    }

    public void preOrder() {
        System.out.print(data + " ");
     if (left != null )
         left.preOrder();
     if (right != null )
         right.preOrder();
    }

    public void inOrder() {
     if (left != null )
         left.inOrder();
    System.out.print(data + " ");
     if (right != null )
         right.inOrder();
    }

    public void postOrder() {
     if (left != null )
         left.postOrder();
     if (right != null )
         right.postOrder();
    System.out.print(data + " ");
    }

    public boolean search(int x){
        if(data == x)
            return true;
        if(x < data){
            if(left != null)
                return left.search(x);
            }
        else {
            if(right != null)
                return right.search(x);
            }
        return false;
    }

    public static void main(String[] args) {
        BST bst = new BST(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
        int value = 13;
        boolean find = bst.search(value);
        
        System.out.println("PreOrder: "); bst.preOrder();
        System.out.println();
        System.out.println("InOrder: "); bst.inOrder();
        System.out.println();
        System.out.println("PostOrder: "); bst.postOrder();
        System.out.println("\n");

        if(find)
            System.out.println("Find value " + value + " in tree");
        else
        System.out.println("Not find value " + value + " in tree");



    }

}
