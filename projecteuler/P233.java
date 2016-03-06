import java.util.ArrayList;
import java.util.Arrays;

public class P233 {
	static long LIMIT = 100000000000L;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static ArrayList<Integer> primes_4k_1 = new ArrayList<Integer>();
	static ArrayList<Integer> primes_not_4k_1 = new ArrayList<Integer>();
	static long sum = 0;

	public static void main(String args[]) {
		final int PRIME_LIMIT = 4733727;
		sievePrimes(PRIME_LIMIT);
		separatePrimes();
		int powers[][] = new int[][] { { 3, 2, 1 }, { 7, 3 }, { 10, 2 } };
		for (int p[] : powers) {
			search(p, 0, 1, new int[3]);
		}
		System.out.println(sum);
	}

	static void search2(long n, int index) {
		int prime = primes_not_4k_1.get(index);
		while (true) {
			n *= prime;
			if (n > LIMIT) {
				break;
			}
			sum += n;
			for (int i = index + 1; i < primes_not_4k_1.size(); i++) {
				int nextPrime = primes_not_4k_1.get(i);
				long nextN = n * nextPrime;
				if (nextN > LIMIT) {
					break;
				}
				search2(n, i);
			}
		}
	}

	static void search(int p[], int index, long n, int selected[]) {
		if (index == p.length) {
			sum += n;
			for (int i = 0; i < primes_not_4k_1.size(); i++) {
				int prime = primes_not_4k_1.get(i);
				long nextN = n * prime;
				if (nextN > LIMIT) {
					break;
				}
				search2(n, i);
			}
			return;
		}
		for (int prime : primes_4k_1) {
			boolean used = false;
			for (int i = 0; i < index; i++) {
				if (selected[i] == prime) {
					used = true;
					break;
				}
			}
			if (used) {
				continue;
			}
			long nextN = n;
			for (int i = 0; i < p[index]; i++) {
				nextN *= prime;
				if (nextN > LIMIT) {
					return;
				}
			}
			selected[index] = prime;
			search(p, index + 1, nextN, selected);
		}
	}

	static void sievePrimes(int limit) {
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

	static void separatePrimes() {
		for (int prime : primes) {
			if ((prime - 1) % 4 == 0) {
				primes_4k_1.add(prime);
			} else {
				primes_not_4k_1.add(prime);
			}
		}
	}
}
