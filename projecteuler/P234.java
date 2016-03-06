import java.util.ArrayList;

public class P234 {
	public static void main(String args[]) {
		final long LIMIT = 999966663333L;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int number = 3;
		while (true) {
			boolean isPrime = true;
			for (int i = 0; i < primes.size(); i++) {
				int p = primes.get(i);
				if (p * p > number) {
					break;
				}
				if (number % p == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(number);
				if ((long) number * number > LIMIT) {
					break;
				}
			}
			number += 2;
		}
		long sum = 0;
		for (int i = 0; i < primes.size() - 1; i++) {
			long p1 = primes.get(i);
			long p2 = primes.get(i + 1);
			sum += multipleSum(p1, p1 * p1 + 1, Math.min(p2 * p2 - 1, LIMIT));
			sum += multipleSum(p2, p1 * p1 + 1, Math.min(p2 * p2 - 1, LIMIT));
			sum -= 2 * multipleSum(p1 * p2, p1 * p1 + 1,
					Math.min(p2 * p2 - 1, LIMIT));
		}
		System.out.println(sum);
	}

	static long multipleSum(long p, long begin, long end) {
		long a1 = begin / p * p;
		if (a1 < begin) {
			a1 += p;
		}
		long an = end / p * p;
		long n = (an - a1) / p + 1;
		return (a1 + an) * n / 2;
	}
}
