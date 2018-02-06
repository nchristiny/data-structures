package collections.arraylist;

//import java.io.*;

public class LinkedListTester {

    public static void main(String[] args) {
//        try {
            // Print STDOUT stream to text file
//            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//            System.setOut(out);
            
            int maxVal = 100;
            int numVals = (int) (Math.random() * 16) + 8;
            List myList = new LinkedList(numVals);
            System.out.println("Adding: ");

            for (int i = 0; i < numVals; i++) {
                int val = (int) (Math.random() * maxVal) + 1;
                myList.add(val);
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("myList Size is " + myList.size());
            System.out.println(myList);
            System.out.println();

            for (int i = 0; i < myList.size() / 4; i++) {
                int idx = (int) (Math.random() * myList.size());
                int val = myList.get(idx);
                System.out.println(val + " is at index: " + idx + ".  removing...");
                myList.remove(idx);
            }
            System.out.println();
            System.out.println("Resulting list after removing: ");
            System.out.println(myList);
            System.out.println("myList size is " + myList.size());
            System.out.println();

            for (int i = 0; i < myList.size() / 2; i++) {
                int idx = (int) (Math.random() * myList.size());
                int val = myList.get(idx);
                int newVal = (int) (Math.random() * maxVal) + 1;
                System.out.println("Changing the " + val + " at index " + idx + " to " + newVal + ".");
                myList.set(idx, newVal);
            }
            System.out.println("Resulting list after changing: ");
            System.out.println(myList);
            System.out.println();
            for (int i = 0; i < myList.size() * 2; i++) {
                int val = (int) (Math.random() * maxVal) + 1;
                if (myList.contains(val)) {
                    System.out.println(val + " is in the list!");
                } else {
                    System.out.println(val + " is not in the list!");
                }
            }
            System.out.println();
            System.out.println("Sorting the list:");
            myList.sort();
            System.out.println(myList);
            System.out.println();

            System.out.println("Reversing the list.");
            myList.reverse();
            System.out.println(myList);
            System.out.println();

//            System.out.println("Removing all the elements from myList!");
//            while (myList.isEmpty() == false) {
//                myList.remove(0);
//            }
            System.out.println("Size of myList after emptying = " + myList.size());
            System.out.println("myList: " + myList);
            System.out.println("Goodbye!");
            
//            Node a;
//            a = new Node(3);
//            System.out.println(a.data);
//            
//            System.out.println(a.next);
//            
//            List myList2 = new LinkedList(5);
//
//            myList2.add(3);
//            
//            System.out.println(myList2);

//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        }
        
    }
}
