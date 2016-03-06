// VM arguments: -Xms32m -Xmx1400m

import java.util.ArrayList;
import java.util.Arrays;

public class P263 {
	static boolean primes[];

	public static void main(String args[]) {
		final int LIMIT = 1200000000;
		final int TARGET_COUNT = 4;
		int count = 0;
		int sum = 0;
		sievePrimes(LIMIT);
		for (int n = 12; n < primes.length - 9; n += 2) {
			if (isTriplePair(n) && isPractical(n - 8) && isPractical(n - 4)
					&& isPractical(n) && isPractical(n + 4)
					&& isPractical(n + 8)) {
				count++;
				sum += n;
				if (count == TARGET_COUNT) {
					break;
				}
			}
		}
		System.out.println(sum);
	}

	static ArrayList<Factor> factorize(int n) {
		ArrayList<Factor> factors = new ArrayList<Factor>();
		for (int p = 2; p * p <= n; p++) {
			if (!primes[p]) {
				continue;
			}
			int power = 0;
			while (n % p == 0) {
				n /= p;
				power++;
			}
			if (power > 0) {
				factors.add(new Factor(p, power));
			}
		}
		if (n > 1) {
			factors.add(new Factor(n, 1));
		}
		return factors;
	}

	static boolean isPractical(int n) {
		ArrayList<Factor> factors = factorize(n);
		if (factors.get(0).prime != 2) {
			return false;
		}
		for (int i = 1; i < factors.size(); i++) {
			int product = 1;
			for (int j = 0; j < i; j++) {
				Factor f = factors.get(j);
				product *= ((int) Math.round(Math.pow(f.prime, f.power + 1)) - 1)
						/ (f.prime - 1);
			}
			if (factors.get(i).prime > 1 + product) {
				return false;
			}
		}
		return true;
	}

	static boolean isTriplePair(int n) {
		return isSexyPair(n - 9) && isSexyPair(n - 3) && isSexyPair(n + 3);
	}

	static boolean isSexyPair(int n) {
		return primes[n] && !primes[n + 1] && !primes[n + 2] && !primes[n + 3]
				&& !primes[n + 4] && !primes[n + 5] && primes[n + 6];
	}

	static void sievePrimes(int limit) {
		primes = new boolean[limit + 1];
		Arrays.fill(primes, true);
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (long j = (long) i * i; j < primes.length; j += i) {
					primes[(int) j] = false;
				}
			}
		}
	}
}

class Factor {
	int prime;
	int power;

	Factor(int prime, int power) {
		this.prime = prime;
		this.power = power;
	}
}
