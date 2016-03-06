import java.util.ArrayList;
import java.util.Arrays;

public class P278 {
	public static void main(String args[]) {
		final int LIMIT = 5000;
		ArrayList<Integer> primes = sievePrimes(LIMIT);
		long sum = 0;
		for (int i = 0; i < primes.size(); i++) {
			int p = primes.get(i);
			for (int j = i + 1; j < primes.size(); j++) {
				int q = primes.get(j);
				for (int k = j + 1; k < primes.size(); k++) {
					int r = primes.get(k);
					sum += g(p, q, r);
				}
			}
		}
		System.out.println(sum);
	}

	static long g(long p, long q, int r) {
		return p * r * (q - 1) + q * r * (p - 1) - p * q;
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit];
		Arrays.fill(isPrimes, true);
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (int j = i * i; j < isPrimes.length; j += i) {
					isPrimes[j] = false;
				}
			}
		}
		return primes;
	}
}
