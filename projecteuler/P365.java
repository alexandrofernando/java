import java.math.BigInteger;
import java.util.ArrayList;

public class P365 {
	public static void main(String args[]) {
		final long N = 1000000000000000000L;
		final long K = 1000000000;
		final int PRIME_LOWER = 1000;
		final int PRIME_UPPER = 5000;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = PRIME_LOWER + 1; i < PRIME_UPPER; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		int remainders[] = new int[primes.size()];
		for (int i = 0; i < remainders.length; i++) {
			remainders[i] = calcByLucasTheorem(N, K, primes.get(i));
		}
		long sum = 0;
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				for (int k = j + 1; k < primes.size(); k++) {
					sum += calcByChineseRemainderTheorem(
							new int[] { primes.get(i), primes.get(j),
									primes.get(k) }, new int[] { remainders[i],
									remainders[j], remainders[k] });
				}
			}
		}
		System.out.println(sum);
	}

	static long calcByChineseRemainderTheorem(int m[], int a[]) {
		long M = 1;
		for (int i = 0; i < m.length; i++) {
			M *= m[i];
		}
		long result = 0;
		for (int i = 0; i < m.length; i++) {
			long Mi = M / m[i];
			X_Y solution = extendedGCD(Mi, m[i]);
			result = addMod(result,
					multiplyMod(multiplyMod(Mi, solution.x, M), a[i], M), M);
		}
		return result;
	}

	static X_Y extendedGCD(long a, long b) {
		if (b == 0) {
			return new X_Y(1, 0);
		} else {
			X_Y solution = extendedGCD(b, a % b);
			return new X_Y(solution.y, solution.x - a / b * solution.y);
		}
	}

	static long addMod(long a, long b, long modulo) {
		return (a % modulo + b % modulo + modulo * 2) % modulo;
	}

	static long multiplyMod(long a, long b, long modulo) {
		return a % modulo * b % modulo;
	}

	static int calcByLucasTheorem(long m, long n, int p) {
		int result = 1;
		while (m != 0 || n != 0) {
			int mi = (int) (m % p);
			int ni = (int) (n % p);
			result = (int) multiplyMod(result, C(mi, ni, p), p);
			m /= p;
			n /= p;
		}
		return result;
	}

	static int C(int n, int k, int p) {
		if (k > n) {
			return 0;
		}
		if (k + k > n) {
			return C(n, n - k, p);
		}
		BigInteger result = BigInteger.ONE;
		for (int i = n; i > n - k; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= k; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result.mod(new BigInteger(p + "")).intValue();
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class X_Y {
	long x;
	long y;

	public X_Y(long x, long y) {
		this.x = x;
		this.y = y;
	}
}