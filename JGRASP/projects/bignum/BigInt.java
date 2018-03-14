package projects.bignum;

import collections.list.generics.LinkedList;

public class BigInt implements Comparable<BigInt> {
   LinkedList<Integer>  data = new LinkedList<>();
   boolean              isNeg;
   
   public BigInt() {
      /* set data and isNeg flag */
   }      

   //eg "12341293487192857623948756293487562938457236046981406"
   public BigInt(String num) {
      /* set data from num */
      
      // determine postive or negative value
      String newNum = "";
      if (num.charAt(0) == '-') {
         this.isNeg = true;
         newNum = num.substring(1);
      } else if (num.charAt(0) == '+') {
         this.isNeg = false;
         newNum = num.substring(1);
      } else {
         this.isNeg = false;
         newNum = num;
      }
      
      for (int i = 0; i <= newNum.length() - 1; i++) {
         /* obtain the int value of each character in string
          and add it to data */      
         if (newNum.charAt(i) == '0'){
            // Skip leading zeros
            continue; 
         } 
         int digit = Character.getNumericValue(newNum.charAt(i));
         data.add(digit);
      }    
   }
   
   public BigInt(BigInt num) {
      /* create duplicate of num, 
      data reference should be new */

   }
   
   public BigInt abs(BigInt a) {
      BigInt b = new BigInt(a);
      b.isNeg = false;
      return b;
   }
   
   /* return 0 if equal, - value if lesser, + value if greater */
   public int compareTo(BigInt b) {
      return 0;
   }
   
   // TODO implementing add, subtract, and multiplication, division, abs, compareTo
   public BigInt add(BigInt n) {
      //'this' + n
      return null;
   }
   
   public BigInt subtract(BigInt n) {
      /* Subtract n from this, ('this'-n). flip if n greater than this and negate
         Implementing abs to called here */
      return null;

   }   
   
   public String toFormattedString() {
       /* start at end of r, work backwards and
         insert commas every three characters */
       String r = this.toString();
      
       // check to see if format is necessary
       if (this.isNeg == true && r.length() - 1 < 4){
           return r;
       } else if (this.isNeg == false && r.length() < 4) {
           return r;
       }
      
       String canonical = "";
       if (this.isNeg == true) {
           canonical = r.substring(1);
       } else {
           canonical = r;
       }
      
       String prettyPrint = "";
       int count = 0;
       for (int i = canonical.length() - 1; i >= 0; i--) {
           prettyPrint = canonical.charAt(i) + prettyPrint;
           count++;
           if ((count % 3 == 0) && (i > 0)) {
               prettyPrint = "," + prettyPrint;
           }
       }
       
       if (this.isNeg == true) {
           return "-" + prettyPrint; 
       } else {
           return prettyPrint;
       }
   }
   
   public String toString() {
      String r = "";
      if (this.isNeg == true) {
         r = "-";
      }
      for (int i = 0; i <= data.size() - 1; i++){
         r += data.get(i);
      }
      return r;
   }   
   
   public static void main(String[] args) {
      BigInt myNum = new BigInt("12345");
      BigInt myNum2 = new BigInt("-12345");
      BigInt myNum3 = new BigInt("+0000001243523452345234522345");
      BigInt myNum01 = new BigInt("123");
      BigInt myNum02 = new BigInt("-1232");
      System.out.println(myNum);
      System.out.println(myNum2);
      System.out.println(myNum3);
      System.out.println(myNum.toFormattedString());
      System.out.println(myNum2.toFormattedString());
      System.out.println(myNum3.toFormattedString());
      System.out.println(myNum01.toFormattedString());
      System.out.println(myNum02.toFormattedString());

   }
}