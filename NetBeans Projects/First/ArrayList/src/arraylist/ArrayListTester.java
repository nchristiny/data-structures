/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package arraylist;

/**
 *
 * @author nyc
 */
public class ArrayListTester {
    
    public static void main(String[] args)
    {
        int maxVal = 100;
        int numVals = (int)(Math.random() * 16) + 8;
        List myList = new ArrayList(numVals);
        System.out.println("Adding: ");
        
        for(int i = 0; i < numVals; i++)
        {
            int val = (int)(Math.random()*maxVal) + 1;
            myList.add(val);
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("myList Size is " + myList.size());
        System.out.println(myList);
        System.out.println();
        
        for(int i=0;i<myList.size()/4;i++)
        {
            int idx = (int)(Math.random() * myList.size());
            int val = myList.get(idx);
            System.out.println(val + " is at index: " + idx + ".  removing...");
            myList.remove(idx);
        }
        System.out.println();
        System.out.println("Resulting list after removing: ");
        System.out.println(myList);
        System.out.println("myList size is " + myList.size());
        System.out.println();
        
        for(int i=0; i<myList.size()/2; i++)
        {
            int idx = (int)(Math.random() * myList.size());
            int val = myList.get(idx);
            int newVal = (int)(Math.random() * maxVal) + 1;
            System.out.println("Changing the " + val + " at index " + idx + " to " + newVal + ".");
            myList.set(idx, newVal);
        }
        System.out.println("Resulting list after changing: ");
        System.out.println( myList );
        System.out.println();
        for(int i = 0;i < myList.size() * 2;i++)
        {
            int val = (int)(Math.random() * maxVal)+1;
            if(myList.contains(val))
            {
                System.out.println(val + " is in the list!");
            }
            else
            {
                System.out.println(val + " is not in the list!");
            }
        }
        System.out.println();
        System.out.println("Sorting the list:");
        myList.sort();
        System.out.println(myList);
        System.out.println();
        
        // // Verify newly instantiated ArrayList is empty
        // List emptyList = new ArrayList(10);
        // System.out.print("Is newly created list empty? ");
        // System.out.println(emptyList.isEmpty());

        System.out.println("Removing all the elements from myList!");
        while( myList.isEmpty() == false )
        {
            myList.remove(0);
        }
        System.out.println("Size of mySize after emptying = " + myList.size());
        System.out.println("myList: " + myList);
        System.out.println("Goodbye!");
    }
}
