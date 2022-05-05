import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    private final int MAX = 20;
    int n = 7;
    int A[][] = {
        {0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 1, 0, 0},  
        {0, 0, 0, 0, 1, 0, 0},  
    };

    boolean check[] = new boolean[MAX];

    public void init() {
        for(int i=0; i<n; i++){
            check[i] = true;
        }
    }
    
    public void BFS(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        if(check[v]) {
            q.add(v);
            check[v] = false;
        }

        while (!q.isEmpty()){
            int p = q.remove();
            System.out.print(p + " ");
            for(int i=0; i<n; i++){
                if(check[i] && (A[i][p]) == 1){
                    q.add(i);
                    check[i] = false;
                }
            }
        }
    }

    public void DFS(int v) {
        if(check[v]){
            System.out.print(v + " ");
            check[v] = false;
        }
        for(int i=0; i<n; i++){
            if((check[i]) && (A[i][v] == 1))
                DFS(i); 
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.init();
        g.BFS(0);
        System.out.println();
        g.init();
        g.DFS(0);
    }
}
