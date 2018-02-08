/**
 * CS 304 Assignment 2: more fun with LinkedList & nodes
 */
package collections.arraylist;

public class LinkedList implements List {
    
    private Node root;
    private Node tail;  // tail.next always null
    
    public LinkedList() {
        // creates empty LinkedList
        root = null;
        tail = null;
    }
    /* TODO Contructor from fileName */
    public LinkedList(String fileName) {}
    /* TODO Contructor from array */
    public LinkedList(int[] A) {}
    
    @Override
    public void add(int val) {
        // Append to LinkedList i.e. after tail
        Node tmp = new Node(val);
        if(this.isEmpty()) {
            root = tmp; 
            tail = root; // Now 1 element in LinkedList
        } 
        else {
            tail.next = tmp; // Add to existing tail reference next value
            tail = tmp; // update tail reference 
        }
    }
    
    @Override
    public int remove(int idx) {
        if (idx >= this.size() || idx < 0) {
            return -1;
        }
        return -1;
    }

    @Override
    @SuppressWarnings("null")
    public int get(int idx) {
        // if requested index is outside LinkedList, throw exception
//        if (idx >= this.size() || idx < 0 ) {
//            throw new IllegalArgumentException("Invalid Index");
//        }
        
        Node r = root;
        if (!this.isEmpty()) { // if LinkedList is not empty
            for (int i = 0; i < idx; i++) {
                r = r.next;
            }
        }
        return r.data; 
    }

    @Override
    public void set(int idx, int val) {
//        values[idx].data = val;
    }

    @Override
    public void sort() {
        
    }
    
    @Override
    public int size() {
        Node r = root;
        int count = 0;            
        if (r != null) {
            while(r.next != null){
                count++;
                r = r.next;
            }   
        }
        return count;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(int val) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (root == null && this.size() == 0);
    }

    @Override
    public void reverse() {

    }
    
    @Override
    public String toString() {
        String output = "";        
        for (int i = 0; i < this.size() + 1; i++) {
            if (i == this.size()) {
                output = output + this.get(i);
            } else {
                output = output + this.get(i) + ", ";
            }
        }
        return output;
    }

//    public int indexOfTail() {
//        // The index of the tail is (length of values - 1), otherwise -1 
//        if (this.isEmpty())
//            return -1;
//        return values.length - 1;
//    }

    @Override
    public int indexOf(int val) {
    // TODO implement this later YAGNI 
    //        for (int i = 0; i < this.size(); i++) {
//            if (values[i].data == val) {
//                return i;
//            }           
//        }
        return -1;
    }

    
}
