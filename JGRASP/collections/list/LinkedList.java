/**
 * LinkedList.java
 * HW 2  
 */
package collections.list; 
import java.io.*;

public class LinkedList implements List {
   
   private Node root;
   
   /* Default constructor */
   public LinkedList() {
      root = null;
   }
   
   /* Contructor from fileName */
   public LinkedList(String fileName) {}
   /* Contructor from array */
   public LinkedList(int[] A) {}
   
   public void add (int v) {
      // append new node
      Node tmp = new Node(v);
      if(this.isEmpty()) {
         root = tmp;  // 1 element now in LinkedList
      }
      else {
         Node r = root;
         while(r.next != null) {
            r = r.next;
         }
         r.next = tmp;
      }
   }
   
   public boolean isEmpty() {
      return (root == null);
   }
   
   public boolean isFull() {
      return false;
   }
   
   public int indexOf(int v) {
      // Not implemented
      return -1;
   }
   
   public boolean contains(int v) {
      Node r = root;
      while(r != null) {
         // while LinkedList is not empty
         if (v == r.data){
            return true;
            }
            r = r.next;
      } 
      return false;
   }
   
   public void clear() {
     while(this.isEmpty() == false) {
         this.remove(0);
     }    
   }
   
   public int size() {
      Node r = root;
      int count = 1;            
      if (r != null) {
          while(r.next != null) {
              count++;
              r = r.next;
          }   
      } else {
         // LinkedList is empty
         return 0;
      }
      return count;
   }
   
   public void sort() { 
      if (this.isEmpty() || this.size() == 1) {
          // if LinkedList is (empty OR contains one element)
          System.out.println("Already sorted");
      } else { 
          // do the sort
          boolean swapped = true;
          // LinkedList is sorted when swapped is false after a pass
          while(swapped) {
            swapped = false;
            Node r = root;
            Node r2 = r.next;
            int tmp;
            while(r.next != null) {
               if(r.data > r2.data) {
                     tmp = r.data;
                     r.data = r2.data;
                     r2.data = tmp;
                     swapped = true;
                  }
                  r = r.next;
                  r2 = r.next;
               }
          }
      }
   }
   
   public void set(int idx, int val) throws IndexOutOfBoundsException {
      // throw exception if not in range
      if (idx < 0 || idx > this.size()) {
         throw new IndexOutOfBoundsException("Index invalid");
      }
      Node r = root;
      if (!this.isEmpty()) { // if LinkedList is not empty
          for (int i = 0; i < idx; i++) {
              r = r.next;
          }
      }
      r.data = val;      
   }
   
   public int get(int idx) throws IndexOutOfBoundsException {
      // throw exception if not in range
      if (idx < 0 || idx >= this.size()) {
         throw new IndexOutOfBoundsException("Index invalid");
      }
      Node r = root;
      if (!this.isEmpty()) { 
          // if LinkedList is not empty
          for (int i = 0; i < idx; i++) {
              r = r.next;
          }
      }
      return r.data; 
   }
   
   public int remove(int idx) throws IndexOutOfBoundsException {
      // throw exception if not in range
      if (idx < 0 || idx > this.size()) {
         throw new IndexOutOfBoundsException("Index invalid");
      }
      if (idx == 0) {
         int removed = root.data;
         root = root.next;
         return removed;
      }
      Node r = root;
      for(int i = 0; i < idx - 1; i++) {
         r = r.next;
      }
      int removed = r.next.data;
      r.next = r.next.next;
      return removed;
   }
   
   public void insert( int idx, int val ) throws IndexOutOfBoundsException {
      // throw exception if not in range
      if (idx < 0 || idx > this.size()) {
         throw new IndexOutOfBoundsException("Index invalid");
      }
      Node t = new Node(val);
      if (idx == 0) {
         // edge case of inserting new node at index 0 (root)
         t.next = root;
         root = t;
      } else {
         Node r = root;
         for(int i = 0; i < idx - 1; i++) {
            r = r.next;
         }
         t.next = r.next;
         r.next = t;
      } 
   }
   
   public String toString() {
      String output = ""; 
      if (this.isEmpty()) {
         return output;
      }       
      for (int i = 0; i < this.size(); i++) {
          if (i == this.size() - 1) {
              output = output + this.get(i);
          } else {
              output = output + this.get(i) + ", ";
          }
      }
      return output;
   }
}