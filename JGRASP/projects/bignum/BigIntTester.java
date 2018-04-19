package projects.bignum;

public class BigIntTester {
	public static void main(String[] args) throws RuntimeException {
		try {
			BigInt myNum = new BigInt("12345");
			BigInt myNum2 = new BigInt("-12345");
			BigInt myNum3 = new BigInt("+0000001243523452345234522345");
			BigInt myNum01 = new BigInt("000001234");
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
			System.out.print(myNum + " + (myNum01)" + myNum01 + " = (13579) ");
			System.out.println(myNum.add(myNum01));
			System.out.println("myNum01 mutated after above operation:");
			System.out.println(myNum01);
			System.out.print(myNum + " + " + myNum + " = (24,690) ");
			System.out.println(myNum.add(myNum));

			System.out.println("Compare: ");
			System.out.print(myNum + ".compareTo(" + myNum01 + "): ");
			System.out.println(myNum.compareTo(myNum01));
			BigInt bigLittle = new BigInt("000000000123");

			System.out.print(bigLittle + ".compareTo(" + myNum + "): ");
			System.out.println(bigLittle.compareTo(myNum));
			System.out.print(myNum + ".compareTo(" + myNum2 + "): ");
			System.out.println(myNum.compareTo(myNum2));
			System.out.print(myNum + ".compareTo(" + myNum + "): ");
			System.out.println(myNum.compareTo(myNum));

			System.out.print("Subtracting two postive values: " + myNum + " - " + myNum + " = ");
			System.out.println(myNum.subtract(myNum));
			System.out.print("Subtracting: (11111) " + myNum + " - " + myNum01 + " = ");
			System.out.println(myNum.subtract(myNum01));

			System.out.print("Subtracting: (-11,111) " + myNum01 + " - " + myNum + " = ");
			System.out.println(myNum01.subtract(myNum));
			BigInt positive5 = new BigInt("5");
			BigInt positive3 = new BigInt("3");
			BigInt result = new BigInt(positive5.subtract(positive3));
			System.out.print("Subtracting: (2) " + positive5 + " - " + positive3 + " = ");
			System.out.println(result);

			System.out.print("Subtracting: (-2) " + positive3 + " - " + positive5 + " = ");
			BigInt result2 = new BigInt(positive3.subtract(positive5));
			System.out.println(result2);

			BigInt negative2 = new BigInt("-2");
			BigInt negative5 = new BigInt("-5");
			System.out.print("Subtracting two negative values: (3) " + negative2 + " - " + negative5 + " = ");
			BigInt result3 = negative2.subtract(negative5);
			System.out.println(result3);
			negative2 = new BigInt("-2");
			positive5 = new BigInt("5");
			System.out.println("Subtracting two different signs: ");
			System.out.print("Subtracting: (-7) " + negative2 + " - " + positive5 + " = ");
			BigInt result4 = negative2.subtract(positive5);
			System.out.println(result4);

			positive3 = new BigInt("3");
			negative5 = new BigInt("-5");

			System.out.print("Subtracting: (8) " + positive3 + " - " + negative5 + " = ");
			BigInt result5 = positive3.subtract(negative5);
			System.out.println(result5);

			negative2 = new BigInt("-2");
			negative5 = new BigInt("-5");

			System.out.println("Adding two negative values of BigInt:");
			System.out.print(negative2 + " + " + negative5 + " = (-7) ");
			System.out.println(negative2.add(negative5));

			System.out.println("Adding two different signs:");
			System.out.print(positive3 + " + " + negative5 + " = (-2) ");
			System.out.println(positive3.add(negative5));

			System.out.print(negative5 + " + " + positive3 + " = (-2) ");
			System.out.println(negative5.add(positive3));

			System.out.println("*********************************");
			myNum = new BigInt("123456");
			System.out.println("Multiplying BigInt by single digit Integer: " + myNum + " * 9(int) = (Expected: 1,111,104) ");
			System.out.println(myNum.multiply(9).toFormattedString());
			BigInt oper1 = new BigInt("123456");
			BigInt oper2 = new BigInt("789");
			System.out.println("Multiplying two BigInt: " + oper1 + " * " + oper2 + " = (expected: 97,406,784)");
			System.out.println(oper1.multiply(oper2).toFormattedString());

			System.out.println("*********************************");

			BigInt test = new BigInt("0000000");
			System.out.println(test);
			System.out.println("Goodbye!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
}
