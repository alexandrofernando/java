import java.util.ArrayList;
import java.util.Arrays;

public class P272 {
	static final long LIMIT = 100000000000L;
	static ArrayList<Integer> primes_3n1 = new ArrayList<Integer>();
	static long result = 0;

	public static void main(String args[]) {
		sievePrimes((int) (LIMIT / (7 * 13 * 19 * 9)));
		for (long power3 = 1; power3 <= LIMIT; power3 *= 3) {
			int rest = (power3 > 3) ? 4 : 5;
			if (!stillPossible(power3, 0, rest)) {
				break;
			}
			search3n1(power3, -1, rest);
		}
		System.out.println(result);
	}

	static boolean stillPossible(long n, int startIndex, int count) {
		if (startIndex + count > primes_3n1.size()) {
			return false;
		}
		for (int i = startIndex; i < startIndex + count; i++) {
			n *= primes_3n1.get(i);
			if (n > LIMIT) {
				return false;
			}
		}
		return true;
	}

	static void search3n1(long n, int prevIndex, int rest) {
		if (rest == 0) {
			searchOther(n, -1);
			return;
		}
		for (int i = prevIndex + 1; i < primes_3n1.size(); i++) {
			int p = primes_3n1.get(i);
			long nextN = n;
			while (true) {
				nextN *= p;
				if (nextN > LIMIT || !stillPossible(nextN, i + 1, rest - 1)) {
					break;
				}
				search3n1(nextN, i, rest - 1);
			}
		}
	}

	static void searchOther(long n, int prevIndex) {
		boolean divisorRemoved[] = new boolean[(int) (LIMIT / n) + 1];
		for (int i = 3; i < divisorRemoved.length; i += 3) {
			divisorRemoved[i] = true;
		}
		for (int p : primes_3n1) {
			if (p >= divisorRemoved.length) {
				break;
			}
			for (int i = p; i < divisorRemoved.length; i += p) {
				divisorRemoved[i] = true;
			}
		}
		long sum = 0;
		for (int i = 1; i < divisorRemoved.length; i++) {
			if (!divisorRemoved[i]) {
				sum += i;
			}
		}
		result += n * sum;
	}

	static void sievePrimes(int limit) {
		boolean isPrimes[] = new boolean[limit + 1];
		Arrays.fill(isPrimes, true);
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				if (i % 3 == 1) {
					primes_3n1.add(i);
				}
				for (long j = (long) i * i; j < isPrimes.length; j += i) {
					isPrimes[(int) j] = false;
				}
			}
		}
	}
}
