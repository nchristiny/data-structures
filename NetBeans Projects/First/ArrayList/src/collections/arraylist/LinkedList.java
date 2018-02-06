/**
 * CS 304 Assignment 2: more fun with LinkedList & nodes
 */
package collections.arraylist;

public class LinkedList implements List {
    
    private Node root;
    private Node head;  // head.next always null
    private Node[] values;
    
    public LinkedList(int v) {
       values = new Node[v];
    }
    /* TODO Contructor from fileName */
    public LinkedList(String fileName) {}
    /* TODO Contructor from array */
    public LinkedList(int[] A) {}
    
    @Override
    public void add(int val) {
        Node tmp = new Node(val);
        if(root == null) {
            // If LinkedList empty
            root = tmp; // next remains null
            head = tmp; 
            values[0] = root; // Now 1 element in LinkedList
        } 
        else {
            // Add to existing head of LinkedList
            int indexOfHead = this.indexOf(head.data);  // works only when no dupes
//            int indexOfHead = this.values.length - 1; // doesn't work at all ...
            head = tmp; // head becomes new val
            values[indexOfHead].next = head; // former head.next points to new head
            values[indexOfHead + 1] = head;           
        }
    }
    
    @Override
    public int remove(int idx) {
        if (idx >= this.size() || idx < 0) {
            return -1;
        }
        int removedNodeData = values[idx].data;
        Node removedNode = values[idx];
        if (removedNode == head) {
            int indexOfHead = this.indexOf(head.data);
            head = values[indexOfHead - 1];
            head.next = null;
        } else {
            // the case where removed node is not head
            // The node before should point to one after removedNode
            if (removedNode == root) {
                root = values[1];
            } else {
                values[idx - 1].next = values[idx + 1];
            }
        }
        return removedNodeData;
    }

    @Override
    public int get(int idx) {
        int value;
        value = values[idx].data;
        return value;
    }

    @Override
    public void set(int idx, int val) {
        values[idx].data = val;
    }

    @Override
    public void sort() {
        
    }
    
    @Override
    public int size() {
        return this.values.length;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(int val) {
        return (indexOf(val) != -1);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void reverse() {

    }
    
    @Override
    public String toString() {
        String output = "";        
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                output = output + this.get(i);
            } else {
                output = output + this.get(i) + ", ";
            }
        }
        return output;
    }

    @Override
    public int indexOf(int val) {
        // Finds the last index of an item TODO deal wih duplicates... 
        for (int i = 0; i < this.size(); i++) {
            if (values[i].data == val) {
                return i;
            }           
        }
        return -1;
    }

    
}
