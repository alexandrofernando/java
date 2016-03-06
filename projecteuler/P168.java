import java.math.BigInteger;

public class P168 {
	public static void main(String args[]) {
		int sum = 0;
		for (int digit = 1; digit <= 9; digit++) {
			BigInteger base = new BigInteger(digit + "");
			for (int length = 1; length <= 99; length++) {
				base = base.multiply(BigInteger.TEN);
				for (int multiple = 1; multiple <= 9; multiple++) {
					BigInteger denominator = new BigInteger((10 * multiple - 1)
							+ "");
					BigInteger numerator = base.subtract(new BigInteger(
							(digit * multiple) + ""));
					BigInteger x[] = numerator.divideAndRemainder(denominator);
					if (x[1].compareTo(BigInteger.ZERO) == 0) {
						String str = x[0].toString();
						if (str.length() != length) {
							continue;
						}
						int last5 = Integer
								.parseInt(str.substring(str.length() < 4 ? 0
										: str.length() - 4))
								* 10 + digit;
						sum = (sum + last5) % 100000;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
