package collections.list.generics;

public class Queue<T extends Comparable<T>> {
    List <T> data;
    
    public Queue() {
        data = new LinkedList<>();
    }
    
    public void enqueue(T a) {
        data.add(a); 
    }
    
    public T dequeue() {
        // remove and returns head (first element) of LinkedList 
        return data.remove(0);
    }
    
    public boolean isEmpty() {
        return data.size() == 0;
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("Enqueuing");
        for (int i = 0; i < 5; i++) {
            System.out.print(i +  " ");
            q.enqueue(i);
        }
        System.out.println("\n----");
        System.out.println("Dequeuing");
        while(q.isEmpty() == false) {
            System.out.print(q.dequeue() + " ");
        }
    }
}
