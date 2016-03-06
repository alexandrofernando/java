import java.math.BigInteger;

public class P057 {
	public static void main(String args[]) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE;
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			BigInteger nextNumerator = numerator.add(denominator
					.add(denominator));
			BigInteger nextDenominator = numerator.add(denominator);
			numerator = nextNumerator;
			denominator = nextDenominator;
			if (numerator.toString().length() > denominator.toString().length()) {
				count++;
			}
		}
		System.out.println(count);
	}
}
