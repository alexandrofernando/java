import java.util.ArrayList;
import java.util.Arrays;

public class P351 {
	static ArrayList<Integer> primes;

	public static void main(String args[]) {
		final int LIMIT = 100000000;
		sievePrimes((int) Math.ceil(Math.sqrt(LIMIT)));
		System.out.println(H(LIMIT));
	}

	static void sievePrimes(int limit) {
		primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit + 1];
		Arrays.fill(isPrimes, true);
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (int j = i + i; j < isPrimes.length; j += i) {
					isPrimes[j] = false;
				}
			}
		}
	}

	static long H(int n) {
		long total = 0;
		for (int i = 2; i <= n; i++) {
			int nonHidden = totient(i);
			total += i - nonHidden;
		}
		return total * 6;
	}

	static int totient(int number) {
		int result = number;
		for (int p : primes) {
			if (p * p > number) {
				break;
			}
			if (number % p != 0) {
				continue;
			}
			result = result / p * (p - 1);
			do {
				number /= p;
			} while (number % p == 0);
		}
		if (number > 1) {
			result = result / number * (number - 1);
		}
		return result;
	}
}
