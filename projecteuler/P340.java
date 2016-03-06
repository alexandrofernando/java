import java.math.BigInteger;

public class P340 {
	static int MODULO = 1000000000;

	public static void main(String args[]) {
		final long A = pow(21, 7);
		final long B = pow(7, 21);
		final long C = pow(12, 7);

		// 2 S(a, b, c) = (4a - 3c)(2 + b + b % a)(1 + b / a) + (b - 2c)(1 + b)
		BigInteger a = new BigInteger(A + "");
		BigInteger b = new BigInteger(B + "");
		BigInteger c = new BigInteger(C + "");

		BigInteger factor11 = new BigInteger("4").multiply(a).subtract(
				new BigInteger("3").multiply(c));
		BigInteger factor12 = new BigInteger("2").add(b).add(b.mod(a));
		BigInteger factor13 = new BigInteger("1").add(b.divide(a));

		BigInteger factor21 = b.subtract(new BigInteger("2").multiply(c));
		BigInteger factor22 = new BigInteger("1").add(b);

		BigInteger term1 = factor11.multiply(factor12).multiply(factor13);
		BigInteger term2 = factor21.multiply(factor22);

		BigInteger result = term1.add(term2).divide(new BigInteger("2"));
		result = result.mod(new BigInteger(MODULO + ""));

		System.out.println(result);
	}

	static long pow(long base, int exponent) {
		long power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}
}
