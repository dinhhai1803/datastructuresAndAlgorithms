package Algorithms.Edunext.stack;

import java.util.EmptyStackException;

public class LinkedListStack {
    protected Node head;

    LinkedListStack(){
        head = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void push(Object x){
        head = new Node(x, head);
    }

    Object top() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return head.data;
    }

    public Object pop() throws EmptyStackException{ 
        if(isEmpty()) throw new EmptyStackException();
        Object x = head.data;
        head=head.next;
        return(x);
    }


}
