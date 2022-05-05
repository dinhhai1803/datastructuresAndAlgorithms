import java.util.ArrayDeque;
import java.util.Queue;

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void insert(int x){
        if(root == null){
            root = new Node(x);
            return;
        }
        else {
            Node f, p;
            p = root ; f = null;
            while (p != null){
                if(root.info == x){
                    System.out.println("The value " + x + " already existed!");
                    return;
                }
                f = p;
                if(x < p.info)
                    p = p.left;
                else 
                    p = p.right;
            }
            if(x < f.info)
                f.left = new Node(x);
            else
                f.right = new Node(x);
        }
    }

    public void visit (Node p){
        System.out.print(p.info + " ");
    }

    public void preOrder(Node root){
        if(root != null){
            visit(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            visit(root);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            visit(root);
        }
    }

    public void levelOrder(){
        if(root == null)    return;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        Node p;
        while(!q.isEmpty()){
            p = (Node)q.remove();
            if(p.left != null)
                q.add(p.left);
            if(p.right != null)
            q.add(p.right);
            visit(p);
        }
    }

    public int sumNode(Node root){
        if(root == null)
            return 0;
        else    
            return (1 + sumNode(root.left) + sumNode(root.right));
    }

    public int sumParrentNode(Node root){
        if(root == null)
            return 0;
        else    
            if(root.left != null || root.right != null)
                return (1 + sumParrentNode(root.left) + sumParrentNode(root.right));
            return 0;
    }

    public int sumOfLeafNode(Node root){
        return sumNode(root) - sumParrentNode(root);
    }

    public int search(int x, Node root){
        if(root == null)
            return -1;
        else{
            if(root.info == x)
                return root.info;
            else{
                if(x < root.info)
                    return search(x, root.left);    
                if(x > root.info)
                    return search(x, root.right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(2);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(10);
        bst.insert(9);
        bst.insert(7);
        bst.insert(6);
        bst.insert(3);
        bst.insert(4);
        // System.out.println("PreOder: ");
        // bst.preOrder(bst.root);
        // System.out.println();
        // System.out.println("InOder: ");
        // bst.inOrder(bst.root);
        // System.out.println();
        // System.out.println("PostOder: ");
        // bst.postOrder(bst.root);
        // System.out.println();
        // System.out.println("Level Order: ");
        // bst.levelOrder();
        // System.out.println("Sum of node: " + bst.sumNode(bst.root));
        // System.out.println("Sum of node: " + bst.sumParrentNode(bst.root));
        // System.out.println("Sum of node: " + bst.sumOfLeafNode(bst.root));
        int s = bst.search(5, bst.root);
        if(s > -1)
            System.out.println("Exist");
        else
            System.out.println("Not exist");
    }
}
