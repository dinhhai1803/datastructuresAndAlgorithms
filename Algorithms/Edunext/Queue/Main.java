package Algorithms.Edunext.Queue;

public class Main {
 

    public static void main(String[] args) throws Exception{
        ArrayQueue q = new ArrayQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.view();
        q.dequeue();
        q.dequeue();
        q.view();
        System.out.println(q.front());
    }
}
