import java.math.BigInteger;

public class P267 {
	static final int FLIP_NUM = 1000;

	public static void main(String args[]) {
		final double TARGET = 1000000000;
		int min = 0;
		for (int i = FLIP_NUM / 3 + 1; i <= FLIP_NUM; i++) {
			if (F((3.0 * i - FLIP_NUM) / (2 * FLIP_NUM), i) > TARGET) {
				min = i;
				break;
			}
		}
		BigInteger numerator = BigInteger.ZERO;
		for (int i = min; i <= FLIP_NUM; i++) {
			numerator = numerator.add(C(FLIP_NUM, i));
		}
		BigInteger denominator = BigInteger.ONE.shiftLeft(1000);
		long chance = Long.parseLong(numerator
				.multiply(new BigInteger("10000000000000")).divide(denominator)
				.toString());
		chance = (chance + 5) / 10;
		System.out.println("0." + chance);
	}

	static double F(double f, int n) {
		double result = 1;
		for (int i = 0; i < n; i++) {
			result *= 1 + 2 * f;
		}
		for (int i = 0; i < FLIP_NUM - n; i++) {
			result *= 1 - f;
		}
		return result;
	}

	static BigInteger C(int m, int n) {
		if (n + n > m) {
			return C(m, m - n);
		}
		BigInteger result = BigInteger.ONE;
		for (int i = m; i > m - n; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= n; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result;
	}
}
