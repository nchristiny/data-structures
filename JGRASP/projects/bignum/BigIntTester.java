package projects.bignum;

public class BigIntTester {
    public static void main(String[] args) throws RuntimeException {
        try {
            BigInt myNum = new BigInt("12345");
            BigInt myNum2 = new BigInt("-12345");
            BigInt myNum3 = new BigInt("+0000001243523452345234522345");
            BigInt myNum01 = new BigInt("123");
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

            System.out.print("Subtracting: " + myNum + " - " + myNum + " = ");

            System.out.println(myNum.subtract(myNum));
            System.out.print("Subtracting: " + myNum + " - " + myNum01 + " = ");

            System.out.println(myNum.subtract(myNum01));

            System.out.println("Goodbye!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

}


