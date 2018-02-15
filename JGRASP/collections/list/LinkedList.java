package collections.list; 

public class LinkedList implements List {
   
   private Node root;
//    private Node tail;  // tail.next always null
   
   /* Default constructor */
   public LinkedList() {
      root = null;
//       tail = null;
   }
   
   /* Contructor from fileName */
   public LinkedList(String fileName) {}
   /* Contructor from array */
   public LinkedList(int[] A) {}
   
   public void add (int v) {
      // append new node
      Node tmp = new Node(v);
      if(this.isEmpty()) {
         root = tmp;  // 1 element now in LinkedList
      }
      else {
//          tail.next = tmp; // Add to existing tail reference next value,
//          tail = tmp;      // and update tail reference 
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
   
   public int indexOf(int v) {
      return -1;
   }
   
   public boolean contains(int v) {
      return false;
   }
   
   public void clear() {
   
   }
   
   public int size() {
      Node r = root;
      int count = 0;            
      if (r != null) {
          while(r.next != null) {
              count++;
              r = r.next;
          }   
      }
      return count;
   }
   
   public void sort() {
   
   }
   
   public void reverse() {
   
   }
   
   public void set(int idx, int val) {
   
   }
   
   public int get(int idx) {
      Node r = root;
      if (!this.isEmpty()) { // if LinkedList is not empty
          for (int i = 0; i < idx; i++) {
              r = r.next;
          }
      }
      return r.data; 
   }
   
   public int remove(int idx){
      return -1;
   }
   
   public void insert( int idx, int val ) {
   
   }
   
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
}