package DataStructures.Graph.AdjacencyMatrix;

import java.util.ArrayList;

public class Graph {
    int[][] matrix;
    ArrayList<Node> nodes;

    public Graph(int size){
        matrix = new int[size][size];
        nodes = new ArrayList<>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int src, int dst){
        matrix[src][dst] = 1;               // 1 for a conection betwwen 2 nodes
    }

    public boolean checkEdge(int src, int dst){
        if(matrix[src][dst] == 1) return true;
        else return false;
    }

    public void print(){
        System.out.print("  ");
        for(Node node : nodes){
            System.out.print(node.data + " ");
        }
        System.out.println();

        for(int i =0; i<matrix.length; i++){
            System.out.print(nodes.get(i).data + " ");
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void depthFirstSearch(int src){
        boolean[] visited = new boolean[matrix.length];
        dFHelper(src, visited);
    }

    private void dFHelper(int src, boolean[] visited) {
        if(visited[src]){       // the node had been visited
            return;
        }
        else{
            visited[src] = true;    // mask the visited node
            System.out.println(nodes.get(src).data + " = visited");
        }

        for(int i=0; i<matrix[src].length; i++){
            if(matrix[src][i] == 1)
                dFHelper(i, visited);
        }
        return;
    }

    
}
