/**
 * Generics
 * Node.java
 */
package collections.list.generics;

public class Node<T> {

    T data;
    Node<T> next;

    public Node(T v) {
        data = v;
        next = null;
    }
    
    public Node() {
        data = null;
        next = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
    
   // Fun with generic data types
   public static void main(String[] args) {
       Node<Integer> newNode = new Node<>();
       newNode.data = 42;
       System.out.println(newNode);
       
       List<String> genericLinkedList = new LinkedList<>();
       genericLinkedList.add("New node in generic LinkedList!!!");
       System.out.println(genericLinkedList); 
       System.out.println("Adding more nodes"); 
       genericLinkedList.add("roses");
       genericLinkedList.add("are");
       genericLinkedList.add("red");
       System.out.println(genericLinkedList); 
       System.out.println("Let's create a new linked list with integers."); 
       List<Integer> genericLinkedList2 = new LinkedList<>();
       genericLinkedList2.add(13);
       genericLinkedList2.add(69);
       genericLinkedList2.add(2024);
       System.out.println(genericLinkedList2); 
       genericLinkedList2.remove(0);
       System.out.println(genericLinkedList2); 
       genericLinkedList2.set(1, 1300);
       System.out.println(genericLinkedList2); 

   }
}
