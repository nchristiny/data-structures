package projects.bignum;

import collections.list.generics.LinkedList;

public class BigInt implements Comparable<BigInt> {
   LinkedList<Integer>  data = new LinkedList<>();
   boolean              isNeg;
   
   public BigInt() {
      /* set data and isNeg flag */
      this.isNeg = false;
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
          and add it to data linked list */      
         if (newNum.charAt(i) == '0' && newNum.length() > 0){
            // Skip leading zeros unless it is only char '0'
            continue; 
         } 
         int digit = Character.getNumericValue(newNum.charAt(i));
         data.add(digit);
      }    
   }
   
   public BigInt(BigInt num) {
      /* create duplicate of num, 
      data reference should be new */
      this.data = num.data;
      this.isNeg = num.isNeg;
   }
   
   public BigInt abs(BigInt a) {
      BigInt b = new BigInt(a);
      b.isNeg = false;
      return b;
   }
   
   /* return 0 if equal, -1 if 'this; is lesser, 1 if 'this' greater */
   // changing specification of this method slightly to better suit needs
   public int compareTo(BigInt b) {
      if (this.isNeg && !(b.isNeg)) {
          return -1;
      } else if (!(this.isNeg) && b.isNeg) {
          return 1;
      }
      
      if (b.data.size() > this.data.size()){
          return -1;
      } else if (b.data.size() < this.data.size()){
          return 1;
      } else {
          // else each BigInt has equal length data LinkedLists
          // Starting from left to right, compare the pair of nodes 
          // return as soon as one is found to be greater
          for (int i = 0; i <= this.data.size() - 1; i++) {
              if (b.data.get(i) > this.data.get(i)) {
                  return -1;    
              } else if (b.data.get(i) < this.data.get(i)){
                  return 1;
              }
          }
      }
      return 0; 
   }
   
   // TODO implementing add, subtract, and multiplication, division, abs, compareTo
   public BigInt add(BigInt n) {
      //'this' + n
      int carry = 0;
      int result = 0;
      BigInt resultingBigInt = new BigInt();
      
      //check signs
      // if both are negative, we call subtract method
      if (this.isNeg && n.isNeg) {
         // BigInt temp = new BigInt(n);
         // temp.isNeg = false;
         // resultingBigInt = this.subtract(temp);
         // return resultingBigInt;
      } else if (this.isNeg ^ n.isNeg) {
         // (exclusive-or) if operands have different signs
         if (this.isNeg == true) {
            // BigInt temp = new BigInt(this);
            // temp.isNeg = false;
            // resultingBigInt = n.subtract(temp);
            // return resultingBigInt;
         } else {
            // BigInt temp = new BigInt(n);
            // temp.isNeg = false;
            // resultingBigInt = this.subtract(temp);
            // return resultingBigInt;
         }
      }
      // else both signs are postive, keep adding as normal
      
      // check if same length, if not insert zeros in front of shorter value to match
      if (this.data.size() > n.data.size()) {
         // insert leading zeroes into n
         int leadingZeroes = this.data.size() - n.data.size();
         for (int i = 0; i <= leadingZeroes; i++) {
             n.data.insert(0,0);
         }
      } else if (this.data.size() < n.data.size()) {
         // insert leading zeroes into 'this'
         int leadingZeroes = n.data.size() - this.data.size();
         for (int i = 0; i <= leadingZeroes; i++) {
             this.data.insert(0,0);
         }
      }
      
      // loop through each BigInt's data from tail
      for (int i = this.data.size() - 1; i >= 0; i--) {
          // add each column and carry amount to next operation if greater than 9
          result = 0;
          if (carry != 0) {
              result = carry;
              carry = 0;
          }
          result += this.data.get(i) + n.data.get(i);
          if (result > 9) {
              carry = result % 9;
              if (result == 10) {
                  result = 0;
              } else { 
                  result = result - carry; 
              }           
          } 
          resultingBigInt.data.add(result);
      }
      // Flip data LinkedList using private BigInt method
      resultingBigInt.reverseBigInt();
      return resultingBigInt;
   }
   
   public BigInt subtract(BigInt n) {
      /* Subtract n from 'this', ('this'-n). flip if n greater than this and negate
         Implementing abs to called here */
      boolean flip = false;
      BigInt a = new BigInt();
      BigInt b = new BigInt();
      
      if (this.isNeg == n.isNeg) {
          // signs are the same
//           if () {
              // n is greater than than 'this'
              
      }
      return null;

   }   
   
   private void reverseBigInt() { 
       for (int i = 0; i < this.data.size()/2; i++) {
           // wish to switch elements only if necessary
           if (data.get(i) != data.get(this.data.size() - i - 1)) {
               int temp = data.get(i);
               data.set(i, data.get(this.data.size() - i - 1));
               data.set(this.data.size() - i - 1, temp);        
           } 
           else {
               continue;
           }
       }
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
      BigInt myNum01 = new BigInt("-123");
      BigInt myNum02 = new BigInt("-0012341293487192857623948756293487562938457236046981406");
      System.out.println(myNum);
      System.out.println(myNum2);
      System.out.println(myNum3);
      System.out.println(myNum.toFormattedString());
      System.out.println(myNum2.toFormattedString());
      System.out.println(myNum3.toFormattedString());
      System.out.println(myNum01.toFormattedString());
      System.out.println(myNum02.toFormattedString());
      
      BigInt duplicatedBigInt = new BigInt(myNum02);
      System.out.println(duplicatedBigInt.toFormattedString());

      System.out.println(myNum.add(myNum).toFormattedString());
      System.out.println(myNum.add(myNum2));
      
      System.out.println(myNum.compareTo(myNum01));
      System.out.println(myNum01.compareTo(myNum));
      System.out.println(myNum.compareTo(myNum2));
      System.out.println(myNum.compareTo(myNum));

   }
}