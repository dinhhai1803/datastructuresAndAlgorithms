import java.util.ArrayDeque;
import java.util.Queue;


public class BSTtree {
    private Node root;
    //private BSTtree left, right;

    public BSTtree (){
        root = null;
    }

    public void insert(int x){
        if(root == null){
            root = new Node(x);
            return;
        }
        else{
            Node f, p;
            p = root; f =  null;
            while(p != null){
                if(root.info == x){
                    System.out.println("The key " + x + " already exist!");
                    return;
                }
                f = p;

                if(x < p.info){
                    p = p.left;
                }
                else{
                    p = p.right;
                }
            }

            if(x < f.info)
                f.left = new Node(x);
            else
                f.right = new Node(x);
        }
    }

    public void visit(Node p){
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
        if(root==null) return;

        Queue<Node>  q = new ArrayDeque<>();
        q.add(root);
        Node p;
        while(!q.isEmpty()){ 
            p = (Node) q.remove();
            if(p.left !=null)
            q.add(p.left);
            if(p.right !=null)
            q.add(p.right);
            visit(p);
        }
    }

    int value = 0;
    public int sumOfNodesValue(Node root){
        if(root == null)
            return 0;
        else{
            return root.info + sumOfNodesValue(root.left) + sumOfNodesValue(root.right);
        }
    }

    
    public int sumOfNodes(Node root){
        if(root == null)
            return 0;
        else{
           return 1 + sumOfNodes(root.left) + sumOfNodes(root.right);
        }

    }

    
    public int getParrentNodes(Node root){
        if(root == null)
            return 0;
        else{
            if(root.left != null || root.right != null)
                return 1 + getParrentNodes(root.left) + getParrentNodes(root.right);
        }
        return 0;
    }

    public int getHeight(Node root){
        if(root == null)
            return 0;
        else
            return (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
    }




    public static void main(String[] args) {
        BSTtree bst = new BSTtree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
        bst.insert(20);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(9);
        bst.insert(11);
        bst.insert(13);
        bst.insert(19);
        bst.insert(21);

        // System.out.println("PreOrder : ");
        // bst.preOrder(bst.root);
        System.out.println();
        System.out.println("InOrder: ");
        bst.inOrder(bst.root);
        System.out.println();
        // System.out.println("PostOrder: ");
        // bst.postOrder(bst.root);
        // System.out.println();
        // System.out.println("Level Order: ");
        // bst.levelOrder();
        System.out.println("Sum all values of nodes: " + bst.sumOfNodesValue(bst.root));
        System.out.println("The number of nodes: " + bst.sumOfNodes(bst.root));
        System.out.println("The height of tree: " + bst.getHeight(bst.root));
        System.out.println("The number of leaf-nodes: " + (bst.sumOfNodes(bst.root) - bst.getParrentNodes(bst.root)));
    }
}
