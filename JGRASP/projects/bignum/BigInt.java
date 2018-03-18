package projects.bignum;

import collections.list.generics.LinkedList;

public class BigInt implements Comparable<BigInt> {
    LinkedList<Integer>  data = new LinkedList<>();
    boolean              isNeg;

    public BigInt() {
        /* set data and isNeg flag */
        this.data.add(0);
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
        if(data.isEmpty() && newNum.charAt(i) == '0') {
            if (i == newNum.length() - 1) {
                setToZero();
            }
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

    public boolean setToZero() {
        /* Helper to reduce all-zero data LinkedList to postive single 0 */
        boolean allZero = true;
        if (!(this.data.isEmpty())) {
            for (int i = 0; i <= this.data.size() - 1; i++) {
                if (this.data.get(i) != 0) {
                    return allZero = false;
                }
            }
            this.data.clear();
            this.data.add(0);
            this.isNeg = false;
        }
        return allZero;
    }

    public BigInt abs(BigInt a) {
        BigInt b = new BigInt(a);
        b.isNeg = false;
        return b;
    }

    /* return 0 if equal, -1 if 'this' is lesser, +1 if 'this' greater */
    @Override
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

   // TODO implementing subtract and addition for different signs
   // and multiplication, division
    public BigInt add(BigInt n) {
          //'this' + n
        int carry = 0;
        int result = 0;
        BigInt resultingBigInt = new BigInt();

          //check signs
          // if both are negative, we call subtract method
        if (this.isNeg && n.isNeg) {
             BigInt temp = new BigInt(n);
             temp.isNeg = false;
             resultingBigInt = this.subtract(temp);
             return resultingBigInt;
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

        this.insertLeadingZeroes(n);

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
        resultingBigInt.data.reverse();
        return resultingBigInt;
    }

    public BigInt subtract(BigInt n) {
          /* Subtract n from 'this', ('this'-n). flip if n greater than this and negate
          Implementing abs to called here */
          boolean flip = false;
          BigInt a = new BigInt();
          BigInt b = new BigInt();
          int result = 0;
          int carry = 0;
          BigInt resultingBigInt = new BigInt();

          if (this.isNeg == n.isNeg) {
              // the signs are the same
            if (this.compareTo(n) == 1) {
                  // 'this' is greater than n
                flip = true;
                b = this;
                a = n;
            } else {
                flip = false;
                b = n;
                a = this;
            }
            a.insertLeadingZeroes(b);
            for (int i = this.data.size() - 1; i >= 0; i--) {
                   // actually perform a - b
                result = 0;
                if (carry != 0) {
                    int newVal = a.data.get(i) - 1;
                    a.data.set(i, newVal);
                    carry = 0;
                }
                result = a.data.get(i) - b.data.get(i);
                if (result >= 0) {
                    resultingBigInt.data.add(result);
                } else {
                    resultingBigInt.data.add(result + 10);
                    carry = 1;
                }

            }
            resultingBigInt.isNeg = a.isNeg;
            if (flip = true) {
                resultingBigInt.isNeg = !resultingBigInt.isNeg;
            }
            resultingBigInt.data.reverse();
        } else {
              // the signs are different
            resultingBigInt = abs(n).add(abs(this));
            resultingBigInt.isNeg = this.isNeg;
        }
        // BigInt x = new BigInt(resultingBigInt);
        return resultingBigInt;
    }

    public void insertLeadingZeroes(BigInt n) {
          // Helper method inserts zeros in front of shorter length to match LinkedList sizes
        if (this.data.size() == n.data.size()) {
            return;
        }
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

    @Override
    public String toString() {
        String r = "";
        if (this.isNeg == true) {
            r = "-";
        }
        if (this.setToZero()) {
            return r = "0";
        }
        for (int i = 0; i <= data.size() - 1; i++) {
            r += data.get(i);
        }
        return r;
    }

}
