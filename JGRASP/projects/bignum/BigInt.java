package projects.bignum;

import collections.list.generics.LinkedList;

public class BigInt
{
   LinkedList<Integer>  data;
   boolean              isNeg;
   
   public BigInt()
   {
      /* set data and isNeg flag */
   }      

   //eg "12341293487192857623948756293487562938457236046981406"
   public BigInt( String num )
   {
      /* set data from num */
   }
   
   public BigInt(BigInt num) {
      /* create duplicate of num, data reference should be new */

   }
   
   public BigInt abs(BigInt a) {
      BigInt b = new BigInt();
      b.isNeg = false;
      return b;
   }
   
   /* return 0 if equal, - value if lesser, + value if greater */
   public int compareTo(BigInt b) {
      return 0;
   }
   
   // TODO implementing add, subtract, and multiplication, division, abs, compareTo
   public BigInt add(BigInt n) {
      return null;
   }
   
   public BigInt subtract(BigInt n) {
      /* Subtract n from this - flip if n greater than this and negate
         Implementing abs to called here */
      return null;

   }   
   
   public String toFormattedString() {
      /* formatting output 'nicely' */
      return "return";
   }
   
   public String toString()
   {
      String r = "";
      return r;
   }   
   
   public static void main(String[] args)
   {
      BigInt myNum = new BigInt("12345");
      BigInt myNum2 = new BigInt("-12345");
      BigInt myNum3 = new BigInt("+0000001243523452345234522345");
      System.out.println( myNum );
      System.out.println( myNum2 );
      System.out.println( myNum3 );
   }
}