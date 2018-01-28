/**
 * Scratch: Fun with Linked Lists
 */

public class Node {
   int val;
   Node next;
   
   public static void main(String[] args) {
      Node r = null;
      System.out.println("r = " + r);  // Should be null
      r = new Node();
      System.out.println("r = " + r);  // show referenceid from toString
      r.val = 7;
      System.out.println("r.val = " + r.val);      
      
//       Node r2 = new Node();
//       r2.val = 13;
//       Node r3 = new Node();
//       r3.val = 3;
//       
//       System.out.println("r2.val = " + r2.val + ", r3.val = " + r3.val);
// 
//       Node r4 = r2; // refers to object that already exists; referenced by r2
//       
//       System.out.println("r4.val = " + r4.val);
      
      // we want r2 label to be used by r to point to next node
      // Therefore we create r2 like so:
      
      r.next = new Node(); // creates first member of Linked List 
      Node r2 = r.next; // To mimic behavious from before
      Node r3 = new Node();
      r.next.next = r3;
      r.next.next.val = 3;
      System.out.println("r3.val = " + r3.val);
      Node r4 = r.next.next.next;
      r.next.val = 65;

      // System.out.println("r4.val = " + r4.val);  //  NullPointerException
//       r.next.next.next.val = 8893; //  NullPointerException

      System.out.println("r.next.val = " + r.next.val);  //  null


      // How to tell if next node is last node.
//       Node j = null;
//       Node z = j; 
//       while (z != null) {
//          System.out.println(z.val + " ");
//          z = z.next;
//       }

   }
}