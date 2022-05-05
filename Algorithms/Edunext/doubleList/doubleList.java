package Algorithms.Edunext.doubleList;

public class doubleList {
    Node head,tail;
	doubleList() {head=tail=null;}
	boolean isEmpty() {
	     return(head==null); 
	}
	void clear() {
	     head=tail=null;
	}
	void addLast(int x) {
	     if(isEmpty())
	        head=tail=new Node(x,null,null);
	     else {
	    	 	Node q =new Node(x,tail,null);  // create a new node
	    	 	tail.next=q;                    // link the last node to q
                q.pre = tail;                   // link previous of node q to tail
	    	 	tail=q;                         // q now is the last node
	     }
	}

    void addFirst(int x){
        if(isEmpty())
            head = tail = new Node(x, null, null);
        else{
            Node q = new Node(x, null, head);
            q.next = head;
            head.pre = q;
            head = q;
        }
    }

    void delFirst(){
        if(head==tail) {
			head = tail = null;
		}
        else{
            head = head.next;
        }
    }

	void delLast() {
		if(head==tail) {
			head = tail = null;
		}
		else {
			Node p = tail.pre;
			p.next = null;
			tail = p;
		}
	}

	void traverse() {
		Node p=head;
		while(p!=null) {
		      System.out.print(p.data + "  ");
		      p=p.next;
		}
		System.out.println();
	}

    public static void main(String[] args) {
        doubleList L = new doubleList();
		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		L.traverse();
		L.delLast();
		L.traverse();
        L.addFirst(100);
        L.traverse();
        L.delFirst();
        L.traverse();
	
    }
}
