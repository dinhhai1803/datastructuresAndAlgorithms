package Algorithms.Edunext.Assignment;

public class LinkedList<T> {
    Node head, tail;

    LinkedList(){
        head = tail = null;
    }

    boolean isEmpty(){
        return (head == null);
    }

    void clear(){
        head = tail = null;
    }

    void addFirst(T data){
        if(isEmpty())
            head = tail = new Node(data, null);
        else{
            Node temp = new Node(data, null);
            temp.next = head;
            head = temp;
        }
    }

    void addLast(T data){
        if(isEmpty())
            head = tail = new Node(data, null);
        else{
            Node temp = new Node(data, null);
            tail.next = temp;
            tail = temp;
        }
    }

    void delLast(T data){
        if(isEmpty()){
            System.out.println("The list is empty");
        }
        if(head == tail){
            head = tail = null;
        }
        else{
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    void delFirst(){
        if(isEmpty()){
            System.out.println("The list is empty");
        }
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
        }
    }

    void traverse(){
        if(isEmpty())
            System.out.println("The list is empty");
        else{
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    void addAtNth(T data, int pos){
        Node temp = new Node(data, null);
        Node current = head;

        for(int i=0; i<pos-2; i++){
            current = current.next;
        }

        temp.next = current.next;
        current.next = temp;
    }

    void delAtNth(int pos){
        Node current = head;
        for(int i = 0; i< pos-2; i++){
            current = current.next;
        }

        Node temp = current.next;
        current.next = temp.next;
    }
}
