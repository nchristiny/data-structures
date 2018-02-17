/**
 * Node.java 
 */
package collections.list; 

public class Node {
   
   int data;
   Node next;
   
   public Node(int v) {
      data = v;
      next = null;
   }
   
   @Override
   public String toString() {
      return "" + data;
   }
}