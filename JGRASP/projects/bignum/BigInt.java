package projects.bignum;

import collections.list.generics.LinkedList;

public class BigInt implements Comparable<BigInt> {
    LinkedList<Integer>  data = new LinkedList<>();
    boolean              isNeg;
    static final BigInt ZERO = new BigInt("0");
    static final BigInt ONE = new BigInt("1");

    public BigInt() {
        /* set data and isNeg flag */
        this.isNeg = false;
        this.checkForZero();
    }

   //eg "12341293487192857623948756293487562938457236046981406"
    public BigInt(String num) {
        /* set data from num */
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
            // if '0' and data is yet empty, then continue
            if (newNum.charAt(i) == '0' && data.isEmpty()) {    
                continue;
            }
            int digit = Character.getNumericValue(newNum.charAt(i));
            data.add(digit);
        }
        this.checkForZero();
    }

    public BigInt(BigInt num) {
        /* create duplicate of num,
        data reference should be new */
        this.data = num.data;
        this.isNeg = num.isNeg;
        this.stripLeadingZeros();
    }

    public BigInt abs(BigInt a) {
        BigInt b = new BigInt(a);
        b.isNeg = false;
        return b;
    }

    public BigInt add(BigInt n) {
          //'this' + n
        int carry = 0;
        int result = 0;
        BigInt resultingBigInt = new BigInt();
        BigInt a = new BigInt(this);
        BigInt b = new BigInt(n);

          //check signs
          // if both are negative, we call subtract method
        if (a.isNeg && b.isNeg) {
             BigInt temp = new BigInt(b);
             temp.isNeg = false;  
             resultingBigInt = a.subtract(temp);
             return resultingBigInt;
        } else if (a.isNeg ^ b.isNeg) {
             // (exclusive-or) if operands have different signs
            if (a.isNeg == true) {
                BigInt temp = new BigInt(a);
                temp.isNeg = false;
                resultingBigInt = b.subtract(temp);
                return resultingBigInt;
            } else {
                BigInt temp = new BigInt(b);
                temp.isNeg = false;
                resultingBigInt = a.subtract(temp);
                return resultingBigInt;
            }
        }
        // else both signs are postive, keep adding as normal

        a.insertLeadingZeros(b);

        // loop through each BigInt's data from tail
        for (int i = a.data.size() - 1; i >= 0; i--) {
            // add each column and carry amount to next operation if greater than 9
            result = 0;
            if (carry != 0) {
                result = carry;
                carry = 0;
            }
            result += a.data.get(i) + b.data.get(i);
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
        resultingBigInt.data.reverse();
        resultingBigInt.stripLeadingZeros();
        return resultingBigInt;
    }

    public BigInt subtract(BigInt n) {
          /* Subtract n from 'this', ('this'-n). flip if n greater than
             this and negate. */
          boolean flip = false;
          BigInt a = new BigInt();
          BigInt b = new BigInt();
          int result = 0;
          int carry = 0;
          BigInt resultingBigInt = new BigInt();

          if (this.isNeg == n.isNeg) {
              // the signs are the same
            if (abs(this).compareTo(abs(n)) == 1) {
                  // 'this' is absolute value is greater than n
                flip = false;
                b = this;
                a = n;
            } else {
                flip = true;
                a = this;
                b = n;  
            }
            a.insertLeadingZeros(b);
            for (int i = b.data.size() - 1; i >= 0; i--) {
                result = 0;
                if (carry != 0) {
                    int newVal = a.data.get(i) - 1;
                    a.data.set(i, newVal);
                    carry = 0;
                }
                result = b.data.get(i) - a.data.get(i);
                if (result >= 0) {
                    resultingBigInt.data.add(result);
                } else {
                    resultingBigInt.data.add(result + 10);
                    carry = 1;
                }
            }
            resultingBigInt.isNeg = a.isNeg;
            if (flip == true) {
                resultingBigInt.isNeg = !resultingBigInt.isNeg;
            }
            resultingBigInt.data.reverse();
        } else {
            // the signs are different
            a = this;
            b = n;
            resultingBigInt = abs(a).add(abs(b));
            resultingBigInt.isNeg = this.isNeg;
        }
        resultingBigInt.stripLeadingZeros();
        return resultingBigInt;
    }
    
    // TODO implementing multiplication, division
    // USE A STACK TO PUSH RESULT - may not need recursive "smart" answer,
    // especially for big BigInt
    public BigInt multiply(BigInt n) {
        /* this times n.
           For example, 3 times 5 implies 5 added three times */
        if((n.compareTo(ZERO) == 0) || (this.compareTo(ZERO) == 0)) {
            return ZERO;
        }
        // compiles and runs but gives incorrect answer
        return (this.add(this.multiply(n.subtract(ONE))));  
    }
    
    private boolean checkForZero() {
        /* Checks if values are all zero, if so clears linked list */
        boolean allZero = true;
        if (!(this.data.isEmpty())) {
            for (int i = 0; i <= this.data.size() - 1; i++) {
                if (this.data.get(i) != 0) {
                    return allZero = false;
                }
            }
        }
        this.data.clear();
        this.isNeg = false;
        return allZero;
    }   
    
    public void insertLeadingZeros(BigInt n) {
          /* Inserts zeros to shorter element to match larger */
        if (this.data.size() == n.data.size()) {
            return;
        }
        if (this.data.size() > n.data.size()) {
              // insert leading zeroes into n
            int leadingZeroes = this.data.size() - n.data.size();
            for (int i = 0; i <= leadingZeroes - 1; i++) {
                n.data.insert(0,0);
            }
        } else if (this.data.size() < n.data.size()) {
              // insert leading zeroes into 'this'
            int leadingZeroes = n.data.size() - this.data.size();
            for (int i = 0; i <= leadingZeroes - 1; i++) {
                this.data.insert(0,0);
            }
        }
    }
    
    public void stripLeadingZeros() {
        /* removes leading zeros */ 
        String newString = "";
        newString += this.toString();
        if ((newString.charAt(0) == '-') && (this.isNeg == true)) {
            newString = this.toString().substring(1);
            }
        int i = 0;
        while ((i < newString.length() - 1) && (newString.charAt(i) == '0')) {
            i++;
        }
        newString = newString.substring(i);
        
        // Instead of creating a new BigInt (costly) modify existing
        int len = 0;
        if (this.isNeg == true) {
            len = this.toString().length() - 1;
        } else if (this.isNeg == false) {
            len = this.toString().length();
        }
        if (len != newString.length()) {  
            int diff = len - newString.length();  
            // remove all linked list nodes up to non zero index 
            for (int j = 0; j < diff; j++) {
                if (j == newString.length() - 1) {
                    this.checkForZero();
                } else {
                    this.data.remove(0);
                }
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
    
    /* return 0 if equal, -1 if 'this' is lesser, +1 if 'this' greater */
    @Override
    public int compareTo(BigInt b) {
        if (this.isNeg && !(b.isNeg)) {
            return -1;
        } else if (!(this.isNeg) && b.isNeg) {
            return 1;
        }
        this.insertLeadingZeros(b);
        for (int i = 0; i <= this.data.size() - 1; i++) {
            if (b.data.get(i) > this.data.get(i)) {
                return -1;
            } else if (b.data.get(i) < this.data.get(i)){
                return 1;
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        String r = "";
        if (this.isNeg == true) {
            r = "-";
        }
        if (this.checkForZero()) {
            return r = "0";
        }
        for (int i = 0; i <= data.size() - 1; i++) {
            r += data.get(i);
        }
        return r;
    }
}
