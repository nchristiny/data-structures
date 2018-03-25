package projects.bignum;

public class BigIntTester {
    public static void main(String[] args) throws RuntimeException {
        try {
            BigInt myNum = new BigInt("12345");
            BigInt myNum2 = new BigInt("-12345");
            BigInt myNum3 = new BigInt("+0000001243523452345234522345");
            BigInt myNum01 = new BigInt("00000123");
            BigInt myNum02 = new BigInt("-0012341293487192857623948756293487562938457236046981406");
            System.out.println("Constructed from String:");
            System.out.println(myNum);
            System.out.println(myNum2);
            System.out.println(myNum3);
            System.out.println(myNum.toFormattedString());
            System.out.println(myNum2.toFormattedString());
            System.out.println(myNum3.toFormattedString());
            System.out.println(myNum01.toFormattedString());
            System.out.println(myNum02.toFormattedString());
            System.out.println("Constructed from BigNum:");
            BigInt duplicatedBigInt = new BigInt(myNum02);
            System.out.println(duplicatedBigInt.toFormattedString());
            
            System.out.println("Adding two positive BigInt:");
            System.out.print(myNum + " + (myNum01)" + myNum01 + " = (12,468) ");
            System.out.println(myNum.add(myNum01));
            System.out.println("myNum01 mutated after above operation:");
            System.out.println(myNum01);
            System.out.print(myNum + " + " + myNum + " = (24,690) ");
            System.out.println(myNum.add(myNum));

            System.out.println("Compare: ");
            System.out.print(myNum + ".compareTo(" + myNum01 + "): ");
            System.out.println(myNum.compareTo(myNum01));
            BigInt bigLittle = new BigInt("-000000000123");

            System.out.print(bigLittle + ".compareTo(" + myNum + "): ");
            System.out.println(bigLittle.compareTo(myNum));
            System.out.print(myNum + ".compareTo(" + myNum2 + "): ");
            System.out.println(myNum.compareTo(myNum2));
            System.out.print(myNum + ".compareTo(" + myNum + "): ");
            System.out.println(myNum.compareTo(myNum));

            System.out.print("Subtracting two postive values: " + myNum + " - " + myNum + " = ");
            System.out.println(myNum.subtract(myNum));
            System.out.print("Subtracting: (12,222) " + myNum + " - " + myNum01 + " = ");
            System.out.println(myNum.subtract(myNum01));
            BigInt positive5 = new BigInt("5");
            BigInt positive3 = new BigInt("3");
            BigInt result = new BigInt(positive5.subtract(positive3));
            System.out.print("Subtracting: (2) " + positive5 + " - " + positive3 + " = ");
            System.out.println(result);
            BigInt test = new BigInt("+00000010");
            System.out.println(test);
            System.out.println("Goodbye!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

}
