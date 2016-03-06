import java.math.BigInteger;

public class P281 {
	public static void main(String args[]) {
		final BigInteger LIMIT = new BigInteger("1000000000000000");
		long sum = 0;
		for (int m = 2;; m++) {
			boolean firstExceed = true;
			for (int n = 1;; n++) {
				BigInteger way_bi = f(m, n);
				if (way_bi.compareTo(LIMIT) > 0) {
					break;
				}
				firstExceed = false;
				sum += way_bi.longValue();
			}
			if (firstExceed) {
				break;
			}
		}
		System.out.println(sum);
	}

	static BigInteger f(int m, int n) {
		BigInteger result = BigInteger.ZERO;
		for (int j = 1; j <= n; j++) {
			if (n % j == 0) {
				BigInteger necklacesWithFixedDensity = factorial(m * n / j)
						.divide(factorial(n / j).pow(m)).multiply(
								new BigInteger(totient(j) + ""));
				result = result.add(necklacesWithFixedDensity);
			}
		}
		result = result.divide(new BigInteger(m * n + ""));
		return result;
	}

	static BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(new BigInteger(i + ""));
		}
		return result;
	}

	static int totient(int n) {
		int result = n;
		for (int p = 2; p * p <= n; p++) {
			if (isPrime(p) && n % p == 0) {
				result = result * (p - 1) / p;
				while (n % p == 0) {
					n /= p;
				}
			}
		}
		if (n > 1) {
			result = result * (n - 1) / n;
		}
		return result;
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
