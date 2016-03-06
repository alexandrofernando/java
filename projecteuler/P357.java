//-Xms64m -Xmx800m
import java.util.Arrays;

public class P357 {
	public static void main(String args[]) {
		final int LIMIT = 100000000;
		boolean valid[] = new boolean[LIMIT + 1];
		Arrays.fill(valid, true);
		boolean primes[] = buildPrimes(LIMIT);
		for (int i = 1; i * i <= LIMIT; i++) {
			int n;
			for (int j = i; (n = i * j) <= LIMIT && i + j < primes.length; j++) {
				if (!primes[i + j]) {
					valid[n] = false;
				}
			}
		}
		long sum = 0;
		for (int i = 1; i < valid.length; i++) {
			if (valid[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static boolean[] buildPrimes(int limit) {
		boolean primes[] = new boolean[limit + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i + i < primes.length; i++) {
			if (primes[i]) {
				for (int j = i + i; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}
		return primes;
	}
}
