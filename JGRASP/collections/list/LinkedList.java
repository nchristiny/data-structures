package collections.list; 

public class LinkedList implements List {
   
   Node root;
   /* Default constructor */
   public LinkedList() {}
   /* Contructor from fileName */
   public LinkedList(String fileName) {}
   /* Contructor from array */
   public LinkedList(int[] A) {}
   
   public void add (int v) {
      Node tmp = new Node(v);
      if(root == null) {
         root = tmp;
         return;
      }
      else {
         Node r = root;
         while(r.next != null) {
            r = r.next;
         }
      }
   }
   
   public boolean isEmpty() {
      return false;
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
      return 0;
   }
   
   public void sort() {
   
   }
   
   public void reverse() {
   
   }
   
   public void set(int idx, int val) {
   
   }
   
   get int set(int idx, int val) {
   
   }
   
   public String toString() {
      String str = "[";
      str = str + root + " ";
      str = str + "]";
      return str; 
   }
}