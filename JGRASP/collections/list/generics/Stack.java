package collections.list.generics;

public class Stack<T extends Comparable<T>> {
    List <T> data;

    public Stack() {
        data = new LinkedList<>();
    }
    
    public T pop() {
        return data.remove(data.size() - 1);
    }
    
    public T peek() {
        return data.get(data.size() - 1);
    }
    
    public void push(T a) {
        data.add(a);
    }
    
    public boolean isEmpty() {
        return data.size() == 0;
    }
}
