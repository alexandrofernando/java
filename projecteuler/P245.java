import java.util.ArrayList;
import java.util.Arrays;

public class P245 {
	static final long LIMIT = 200000000000L;
	static ArrayList<Integer> primes;
	static long sum = 0;

	public static void main(String args[]) {
		primes = sievePrimes((int) Math.pow(LIMIT, 2.0 / 3));
		search(1, 1, 1, 0);
		System.out.println(sum);
	}

	static void search(int index, long n, long totient, int primeNum) {
		if (index == primes.size()) {
			return;
		}
		if (primeNum > 1 && (n - 1) % (n - totient) == 0) {
			sum += n;
		}
		for (int i = index; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (primeNum == 0) {
				System.out.println("first prime: " + prime + ", sum: " + sum);
			}
			long nextN = n * prime;
			if (nextN > LIMIT) {
				break;
			}
			search(i + 1, nextN, totient * (prime - 1), primeNum + 1);
		}
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit + 1];
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
