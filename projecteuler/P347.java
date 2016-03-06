import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class P347 {
	public static void main(String args[]) {
		final int N = 10000000;
		int limit = N / 2;
		ArrayList<Integer> primes = buildPrimes(limit);
		HashSet<Integer> setM = new HashSet<Integer>();
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				int m = M(primes.get(i), primes.get(j), N);
				if (m == 0) {
					break;
				}
				setM.add(m);
			}
		}
		long sum = 0;
		for (int m : setM) {
			sum += m;
		}
		System.out.println(sum);
	}

	static int M(int p, int q, int n) {
		int result = 0;
		for (long i = (long) p * q; i <= n; i *= p) {
			for (long j = i; j <= n; j *= q) {
				result = Math.max(result, (int) j);
			}
		}
		return result;
	}

	static ArrayList<Integer> buildPrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit + 1];
		Arrays.fill(isPrimes, true);
		isPrimes[0] = false;
		isPrimes[1] = false;
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
