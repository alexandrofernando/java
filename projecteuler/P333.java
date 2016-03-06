import java.util.ArrayList;
import java.util.Arrays;

public class P333 {
	static final int LIMIT = 1000000;
	static int terms[][] = new int[(int) Math.floor(Math.log(LIMIT)
			/ Math.log(2)) + 1][];
	static int p[] = new int[LIMIT];

	public static void main(String args[]) {
		for (int i = 0, p2 = 1; i < terms.length; i++, p2 *= 2) {
			terms[i] = new int[(int) Math.floor(Math.log((double) LIMIT / p2)
					/ Math.log(3)) + 1];
			for (int j = 0, p3 = 1; j < terms[i].length; j++, p3 *= 3) {
				terms[i][j] = p2 * p3;
			}
		}

		for (int e2 = 0; e2 < terms.length; e2++) {
			for (int e3 = 0; e3 < terms[e2].length; e3++) {
				search(e2, e3, terms[e2][e3]);
			}
		}
		ArrayList<Integer> primes = sievePrimes(LIMIT);
		int sum = 0;
		for (int prime : primes) {
			if (p[prime] == 1) {
				sum += prime;
			}
		}
		System.out.println(sum);
	}

	static void search(int lastE2, int lastE3, int sum) {
		p[sum]++;
		for (int e2 = lastE2 + 1; e2 < terms.length; e2++) {
			for (int e3 = 0; e3 < Math.min(lastE3, terms[e2].length); e3++) {
				if (sum + terms[e2][e3] < LIMIT) {
					search(e2, e3, sum + terms[e2][e3]);
				}
			}
		}
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit];
		Arrays.fill(isPrimes, true);
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
