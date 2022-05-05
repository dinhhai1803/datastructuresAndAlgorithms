import java.util.Scanner;

public class ShortestPath {
    final int MAX = 50;
	final int MAXINT = 32767;

	boolean Chuaxet[] = new boolean[MAX];
	int L[] = new int[MAX]; //nhan
	int Truoc[] = new int[MAX];; //luu dinh dung truoc
	int n = 5;
    int A[][] = {
   	     {0, 7, 0, 0, 8},
   	     {7, 0, 3, 0, 5},
   	     {0, 3, 0, 3, 1},
   	     {0, 0, 3, 0, 8},
   	     {8, 5, 1, 8, 0},
    };

    int s=0,t=3; //Tim duong di ngan nhat tu dinh s den dinh t
	
	void Dijkstra(int s,int t){
	    //Khoi tao nhan
		for(int v=0;v<n;v++) {
			L[v] = MAXINT;
			Truoc[v]=s;
			Chuaxet[v] = true;
		}
		Truoc[s] = 0;
		L[s] = 0;
		Chuaxet[s] = false;
        	//loop
	    int u = s;
	    while(Chuaxet[t]) {
	      int minL = MAXINT, u0=u;
	      for(int v=0;v<n;v++) {
	       //danh lai nhan cac dinh ke voi u
	       if((Chuaxet[v])&&(A[u][v]!=0)&&(L[u]+A[u][v]<L[v])){
	         L[v] = L[u]+A[u][v];
	         Truoc[v] = u;
	       }

	       //Tim u sao cho L(u) nho nhat
	       if((minL>L[v])&&(Chuaxet[v])) {
	          minL = L[v]; 
	          u0 = v;
	        }
	      }

	      //cap nhat lai u
	      u = u0;
	      Chuaxet[u] = false;
	    }
	}

    int w[][] = new int[MAX][MAX];
    void Floyd() {
        //Khoi tao ma tran w = w0 = a[][]    
        int w0[][] = new int [MAX][MAX];    
        for(int i=0;i<n;i++)
         for(int j=0;j<n;j++)
           if(A[i][j] == 0) w0[i][j] = w[i][j] = MAXINT;
           else w0[i][j] = w[i][j] = A[i][j]; 
        //Tinh ma tran w theo thuat toan Floyd
        for(int i=0;i<n;i++)
         for(int j=0;j<n;j++) {     
           w[i][j] = w0[i][j];
           for(int k=0;k<n;k++)
             if(w[i][k]+w[k][j] < w[i][j])
               w[i][j] = w[i][k]+w[k][j]; 
         }
      }

    void InKetQua(){
		System.out.println("The shortest path from " + s + " to " + t + ": ");
		System.out.print(t+" <= ");
	  int i = Truoc[t];
	  while(i!=s){
		  System.out.print(i + " <= ");
	     i = Truoc[i];
	  }
	  System.out.println(s);
	  System.out.print("Length of shortest path: " + L[t]);
	}

    void Input() {
		Scanner scan=new Scanner(System.in);
		System.out.print("From s: ");
		s = scan.nextInt();
		System.out.print("To t: ");
		t = scan.nextInt();
	}

    public static void main(String[] args) {
        ShortestPath b = new ShortestPath();
        b.Input();
        b.Dijkstra(b.s, b.t);
        b.InKetQua();
        System.out.println();
        b.Floyd();
        System.out.println("Length of shortest path: " + b.w[b.s][b.t]);
    }


}