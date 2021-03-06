/**
 * LinkedListTester.java
 */
package collections.list;

public class LinkedListTester {

    public static void main(String[] args) throws RuntimeException {
        try {
            int maxVal = 100;
            List myList = new LinkedList();
            // myList.remove(-1);
            // Invokes java.lang.IndexOutOfBoundsException: Index invalid
            int numVals = (int) (Math.random() * 16) + 8;
            System.out.println("Size = " + myList.size());
            System.out.println("Adding: ");
            for (int i = 0; i < numVals; i++) {
                int val = (int) (Math.random() * maxVal) + 1;
                System.out.print(val + " ");
                myList.add(val);
            }
            System.out.println();
            System.out.println("Size = " + myList.size());
            System.out.println(myList);

            System.out.println("Sorting: ");
            myList.sort();
            System.out.println(myList);

            for (int i = 0; i < myList.size() / 4; i++) {
                int idx = (int) (Math.random() * myList.size());
                int val = myList.get(idx);
                System.out.println(val + " is at index: " + idx + ".  removing...");
                myList.remove(idx);
            }
            System.out.println("Resulting list: ");
            System.out.println("Size = " + myList.size());
            System.out.println(myList);
            for (int i = 0; i < myList.size() / 2; i++) {
                int idx = (int) (Math.random() * myList.size());
                int val = myList.get(idx);
                int newVal = (int) (Math.random() * maxVal) + 1;
                System.out.println("Changing the " + val + " at index " + idx + " to " + newVal + ".");
                myList.set(idx, newVal);
            }
            System.out.println("Resulting list: ");
            System.out.println(myList);
            for (int i = 0; i < myList.size() * 2; i++) {
                int val = (int) (Math.random() * maxVal) + 1;
                if (myList.contains(val)) {
                    System.out.println(val + " is in the list!");
                } else {
                    System.out.println(val + " is not in the list!");
                }
            }
            System.out.println("Sorting the list:");
            myList.sort();
            System.out.println(myList);

            System.out.println("Removing all the elements.");
            // Implementing LinkedList clear() method
            myList.clear();
            System.out.println("Size = " + myList.size());
            System.out.println(myList);
            System.out.println("------ Inserting 20 values ------");
            for (int i = 0; i < 20; i++) {
                int idx = (int) (Math.random() * myList.size());
                int val = (int) (Math.random() * 50) + 1;
                System.out.println("Inserting " + val + " at index " + idx);
                myList.insert(idx, val);
            }
            System.out.println("Size = " + myList.size());
            System.out.println(myList);

            System.out.println("Reversing: ");
            myList.reverse();
            System.out.println(myList);

            // Implement Array constructor for LinkedList
            int myArray[] = {54,32,43,54,34,32};
            List myList2 = new LinkedList(myArray);
            System.out.println("Creating a new LinkedList from an array of 6 elements.");
            System.out.println("Size = " + myList2.size());
            System.out.println(myList2);
            System.out.println("Goodbye!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
