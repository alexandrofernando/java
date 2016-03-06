import java.util.ArrayList;
import java.util.Arrays;

public class P313 {
	public static void main(String args[]) {
		int LIMIT = 1000000;
		ArrayList<Integer> primes = sievePrimes(LIMIT);
		long result = 0;
		for (int p : primes) {
			long p2 = (long) p * p;
			if ((p2 - 5) % 8 == 0) {
				result += 1;
			}
			result += 2 * calcSolutionCount(6, 8, p2 - 9);
		}
		System.out.println(result);
	}

	// a * x + b * y = s (a>=0, b>=0)
	static long calcSolutionCount(int a, int b, long s) {
		if (s < 0) {
			return 0;
		}
		long count = 0;
		for (int x = 0; x < b; x++) {
			long rest = s - a * x;
			if (rest < 0) {
				break;
			}
			if (rest % b == 0) {
				long y = rest / b;
				count += y / a + 1;
			}
		}
		return count;
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
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
		return primes;
	}
}
