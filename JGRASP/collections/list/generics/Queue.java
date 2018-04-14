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
}
