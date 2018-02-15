/**
 * Fun with Linked Lists
 */
package collections.list; 

public class Node {
   
   int data;
   Node next;
   
   public Node(int v) {
      data = v;
      next = null;
   }
   
   public static void display(Node n) {
      while(n != null) {
         System.out.print(n + " ");
         n = n.next;
      }
      System.out.println();
   }
   
   @Override
   public String toString() {
      return "" + data;
   }
}