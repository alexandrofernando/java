// VM arguments: -Xms32m -Xmx1300m

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class P241 {
	static final long LIMIT = 1000000000000000000L;
	static ArrayList<Integer> primes;
	static ArrayList<Long> solutions = new ArrayList<Long>();

	public static void main(String args[]) {
		final int PRIME_LIMIT = 300000000;
		primes = sievePrimes(PRIME_LIMIT);
		for (int k = 1; k <= 6; k++) {
			solve(1, new BigInteger("2"), new BigInteger((2 * k + 1) + ""));
		}
		long sum = 0;
		for (int i = 0; i < solutions.size(); i++) {
			sum += solutions.get(i);
		}
		System.out.println(sum);
	}

	static void solve(long n, BigInteger numerator, BigInteger denominator) {
		Factor firstFactor = factorizeFirst(numerator);
		if (firstFactor.prime.compareTo(new BigInteger(LIMIT + "")) > 0) {
			return;
		}
		long p = firstFactor.prime.longValue();
		if (n % p == 0) {
			return;
		}
		for (int exp = firstFactor.exponent;; exp++) {
			double nextN_double = n * Math.pow(p, exp);
			if (nextN_double > LIMIT) {
				break;
			}
			long nextN = (long) nextN_double;
			BigInteger nextNumerator_bi = new BigInteger(numerator + "")
					.multiply(new BigInteger(((long) Math.pow(p, exp + 1) - 1)
							+ ""));
			BigInteger nextDenominator_bi = new BigInteger(denominator + "")
					.multiply(new BigInteger(
							((long) Math.pow(p, exp) * (p - 1)) + ""));
			if (nextNumerator_bi.compareTo(nextDenominator_bi) > 0) {
				continue;
			}
			BigInteger common = gcd(nextNumerator_bi, nextDenominator_bi);
			nextNumerator_bi = nextNumerator_bi.divide(common);
			nextDenominator_bi = nextDenominator_bi.divide(common);

			if (nextNumerator_bi.equals(nextDenominator_bi)) {
				solutions.add(nextN);
			} else {
				solve(nextN, nextNumerator_bi, nextDenominator_bi);
			}
		}
	}

	static BigInteger gcd(BigInteger a, BigInteger b) {
		if (a.compareTo(b) < 0) {
			return gcd(b, a);
		}
		while (a.mod(b) != BigInteger.ZERO) {
			BigInteger c = a.mod(b);
			a = b;
			b = c;
		}
		return b;
	}

	static Factor factorizeFirst(BigInteger number) {
		for (int prime : primes) {
			BigInteger prime_bi = new BigInteger(prime + "");
			if (prime_bi.multiply(prime_bi).compareTo(number) > 0) {
				return new Factor(number, 1);
			}
			int exponent = 0;
			while (number.mod(prime_bi) == BigInteger.ZERO) {
				exponent++;
				number = number.divide(prime_bi);
			}
			if (exponent > 0) {
				return new Factor(prime_bi, exponent);
			}
		}
		return null;
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		boolean isPrimes[] = new boolean[limit + 1];
		Arrays.fill(isPrimes, true);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (long j = (long) i * i; j < isPrimes.length; j += i) {
					isPrimes[(int) j] = false;
				}
			}
		}
		return primes;
	}
}

class Factor {
	BigInteger prime;
	int exponent;

	Factor(BigInteger prime, int exponent) {
		this.prime = prime;
		this.exponent = exponent;
	}
}