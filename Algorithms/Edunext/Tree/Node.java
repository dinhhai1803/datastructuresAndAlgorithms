package Algorithms.Edunext.Tree;

public class Node {
    int info;
    Node left,right;

    Node(int x) { }

    Node(int x, Node p, Node q){
        setInfo(x);
        left=p; 
        right=q;
    }

    public int getInfo() {
        return info;
    }
    public void setInfo(int info) {
        this.info = info;
    }
}
