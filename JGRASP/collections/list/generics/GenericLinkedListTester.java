/**
 * Generics
 * GenericLinkedListTester.java
 */
package collections.list.generics;

public class GenericLinkedListTester {

    public static void main(String[] args) throws RuntimeException {
        try {
            System.out.println("Creating empty single node!");
            Node<Integer> newNode = new Node<Integer>(41);
            System.out.println("Adding values to single node:");
            newNode.data = 42;
            System.out.println(newNode);
            List<String> genericLinkedList = new LinkedList<>();
            genericLinkedList.add("this is a string in new generic LinkedList!!!");
            System.out.println(genericLinkedList);
            System.out.println("Adding more strings:");
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
            System.out.println("Removing first element:");
            genericLinkedList2.remove(0);
            System.out.println(genericLinkedList2);
            System.out.println("Setting second element:");
            genericLinkedList2.set(1, 1300);
            System.out.println(genericLinkedList2);
            System.out.println("Inserting new node at index 1:");
            genericLinkedList2.insert(1, 60);
            System.out.println(genericLinkedList2);
            System.out.println("Sorting integers:");
            genericLinkedList2.sort();
            System.out.println(genericLinkedList2);
            System.out.println("Sorting strings:");
            genericLinkedList.sort();
            System.out.println(genericLinkedList);
            System.out.println("Reversing:");
            genericLinkedList.reverse();
            genericLinkedList2.reverse();
            System.out.println(genericLinkedList2);
            System.out.println(genericLinkedList);
            System.out.println("Goodbye!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
