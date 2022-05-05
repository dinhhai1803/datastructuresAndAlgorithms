package Algorithms.Edunext.List;

public class List {

    Node head, tail;        // create node head and tail

	List() {
	     head = tail = null;
	}

	boolean isEmpty() { 
	     return(head==null);
	}

	void clear() {
	     head = tail = null;
	}

	void addLast(int x) { 
	   if(isEmpty())
	       head = tail = new Node(x,null);
	   else {
		        Node q = new Node(x,null);  // create a new node
		        tail.next=q;                // point the last node to q
		        tail=q;                     // q now is the tail
		     }
	}

    void addFirst(int x){
        if(isEmpty())
            head = tail = new Node(x, null);
        else{
            Node q = new Node(x, null);
            q.next = head;
            head = q;
        }
    }

    void delLast() {
		if(head==tail) {
			head = tail = null;
		}
		else {
			Node p = head;
			while(p.next!=tail) p = p.next;     // move to the last node
			p.next = null;                      // delete the last node
			tail = p;                           // p now is the tail
		}
	}

    void delFirst(){
        if(head==tail) {
			head = tail = null;
		}
        else{
           head = head.next;                    // remove the first node
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
        List L = new List();
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
