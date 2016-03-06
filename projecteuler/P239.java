import java.math.BigInteger;

public class P239 {
	public static void main(String args[]) {
		BigInteger count = P(97, 22);
		for (int i = 1; i <= 22; i++) {
			BigInteger sign = BigInteger.ONE;
			if (i % 2 == 1) {
				sign = sign.negate();
			}
			count = count.add(sign.multiply(C(22, i)
					.multiply(P(97 - i, 22 - i))));
		}
		count = count.multiply(C(25, 3)).multiply(P(75, 75));
		BigInteger reminder = count.multiply(new BigInteger("100000000000000"))
				.divide(P(100, 100));
		long rounded = (reminder.longValue() + 50) / 100;
		System.out.printf("0.%012d", rounded);
	}

	static BigInteger P(int n, int m) {
		BigInteger result = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		return result;
	}

	static BigInteger C(int n, int m) {
		if (m + m > n) {
			return C(n, n - m);
		}
		BigInteger result = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= m; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result;
	}
}
