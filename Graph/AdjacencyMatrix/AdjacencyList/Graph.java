package DataStructures.Graph.AdjacencyMatrix.AdjacencyList;

import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Node>> aList;
    

    Graph(){
        aList = new ArrayList<>();
    }

    public void addNode(Node node){
        ArrayList<Node> currentList = new ArrayList<>();
        currentList.add(node);
        aList.add(currentList);
    }

    public void addEdge(int src, int dst){
        ArrayList<Node> currentList = aList.get(src);   // access to the adjacency arraylist, the begin of linkedList
        Node dstNode = aList.get(dst).get(0);           // address of the node want to link to
        currentList.add(dstNode);                       // add to the tail of the current linkedlist
    }

    public boolean checkEdge(int src, int dst){
        ArrayList<Node> currentList = aList.get(src);   
        Node dstNode = aList.get(dst).get(0); 

        for (Node node : currentList){                  // check all the node in the current linkedList
            if(node == dstNode) 
                return true;
        }
        return false;
    }

    public void print(){
        for(ArrayList<Node> currentList : aList ){
            for(Node node : currentList){
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
    
}
