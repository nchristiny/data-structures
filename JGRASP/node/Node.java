/**
 * Fun with Linked Lists
 */
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
   
   public static void main(String[] args) {
   
      Node a = new Node(10);
      Node b = new Node(12);
      Node c = new Node(14);
      Node d = new Node(7);
      
      a.next = b;
      b.next = c; 
      c.next = d;
      
      display(a);
   }
}