import java.util.ArrayList;
import java.util.Collections;

public class P187 {
	public static void main(String args[]) {
		final int LIMIT = 100000000;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < LIMIT / 2; i++) {
			boolean isPrime = true;
			for (int j = 0; j < primes.size(); j++) {
				int prime = primes.get(j);
				if (prime * prime > i) {
					break;
				}
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		int count = 0;
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (prime * prime > LIMIT) {
				break;
			}
			int end = Collections.binarySearch(primes, LIMIT / prime);
			if (end >= 0) {
				count += end - i + 1;
			} else {
				count += -1 - end - i;
			}
		}
		System.out.println(count);
	}
}
