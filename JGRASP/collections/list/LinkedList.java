/**
 * LinkedList.java
 * HW 2
 */
package collections.list;

public class LinkedList implements List {

    private Node root;

    /* Default constructor */
    public LinkedList() {
        root = null;
    }

    /* Constructor from fileName */
    public LinkedList(String fileName) {
    }

    /* Constructor from array */
    public LinkedList(int[] inputArray) {
        for (int i = 0; i <= inputArray.length - 1; i++) {
             this.add(inputArray[i]);
        }
    }

    public void add(int v) {
        // append new node
        Node tmp = new Node(v);
        if (this.isEmpty()) {
            root = tmp;  // 1 element now in LinkedList
        } else {
            Node r = root;
            while (r.next != null) {
                r = r.next;
            }
            r.next = tmp;
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public boolean isFull() {
        return false;
    }

    public int indexOf(int val) {
       Node r = root;
       int i =0;
       while (r != null) {
           // while LinkedList is not empty
           if (val == r.data) {
               return i;
           }
           r = r.next;
           i++;
       }
       return -1;
    }

    public boolean contains(int v) {
          return (indexOf(v) != -1);
    }

    public void clear() {
        while (this.isEmpty() == false) {
            this.remove(0);
        }
    }

    public int size() {
        Node r = root;
        int count = 1;
        if (r != null) {
            while (r.next != null) {
                count++;
                r = r.next;
            }
        } else {
            // LinkedList is empty
            return 0;
        }
        return count;
    }

    public void set(int idx, int val) throws IndexOutOfBoundsException {
        // throw exception if not in range
        if (idx < 0 || idx >= this.size()) {
            throw new IndexOutOfBoundsException("Index invalid");
        }
        Node r = root;
        if (!this.isEmpty()) { // if LinkedList is not empty
            for (int i = 0; i < idx; i++) {
                r = r.next;
            }
        }
        r.data = val;
    }

    public int get(int idx) throws IndexOutOfBoundsException {
        // throw exception if not in range
        if (idx < 0 || idx >= this.size()) {
            throw new IndexOutOfBoundsException("Index invalid");
        }
        Node r = root;
        if (!this.isEmpty()) {
            // if LinkedList is not empty
            for (int i = 0; i < idx; i++) {
                r = r.next;
            }
        }
        return r.data;
    }

    public int remove(int idx) throws IndexOutOfBoundsException {
        // throw exception if not in range
        if (idx < 0 || idx >= this.size()) {
            throw new IndexOutOfBoundsException("Index invalid");
        }
        Node r = root;
        int removed = 0;
        // removing first node
        if (idx == 0) {
            int removed = root.data;
            root = root.next;
            return removed;
        } else if (idx < this.size() - 1) {
            for (int i = 0; i < idx - 1; i++) {
                r = r.next;
            }
            removed = r.next.data;
            r.next = r.next.next;
            return removed;
        }
        // otherwise we are removing last node

        for (int i = 0; i < idx - 1; i++) {
            r = r.next;
        }
        removed = this.get(this.size() - 1);
        r.next = null;
        return removed;
    }

    public void insert(int idx, int val) throws IndexOutOfBoundsException {
        // throw exception if not in range
        if (idx < 0 || idx > this.size()) {
            throw new IndexOutOfBoundsException("Index invalid");
        }
        Node t = new Node(val);
        if (idx == 0) {
            // edge case of inserting new node at index 0 (root)
            t.next = root;
            root = t;
        } else {
            Node r = root;
            for (int i = 0; i < idx - 1; i++) {
                r = r.next;
            }
            t.next = r.next;
            r.next = t;
        }
    }

    public void sort() {
        if (this.isEmpty() || this.size() == 1) {
            // if LinkedList is (empty OR contains one element)
            System.out.println("Too small to be sorted");
        } else {
            // bubble sort: this implementation is very inefficient, but it works
            boolean swapped = true;
            // Continue until there are no swaps performed
            while (swapped) {
                swapped = false;
                Node r = root;
                Node r2 = r.next;
                int tmp;
                while (r.next != null) {
                    if (r.data > r2.data) {
                        tmp = r.data;
                        r.data = r2.data;
                        r2.data = tmp;
                        swapped = true;
                    }
                    r = r.next;
                    r2 = r.next;
                }
            }
        }
    }

    public void reverse() {
          for (int i = 0; i < this.size()/2; i++) {
          // wish to switch elements only if necessary
              if (this.get(i) != this.get(this.size() - i - 1)) {
                  int temp = this.get(i);
                  this.set(i, this.get(this.size() - i - 1));
                  this.set(this.size() - i - 1, temp);
              } else {
                  continue;
              }
          }
    }

    public String toString() {
        String output = "";
        if (this.isEmpty()) {
            return output;
        }
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                output = output + this.get(i);
            } else {
                output = output + this.get(i) + ", ";
            }
        }
        return output;
    }
}
