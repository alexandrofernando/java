import java.util.ArrayList;

public class P202 {
	public static void main(String args[]) {
		final long BOUNCE = 12017639147L;
		long C = (BOUNCE + 3) / 2;
		ArrayList<Long> primes = findPrimes(C);
		long answer = 0;
		for (int code = 0; code < (1 << primes.size()); code++) {
			long product = 1;
			int count = 0;
			int temp = code;
			for (int i = 0; i < primes.size(); i++) {
				if (temp % 2 == 1) {
					product *= primes.get(i);
					count++;
				}
				temp /= 2;
			}
			answer = answer + (count % 2 == 1 ? -1 : 1)
					* solutionNum(C / product);
		}
		answer *= 2;
		System.out.println(answer);
	}

	static ArrayList<Long> findPrimes(long number) {
		ArrayList<Long> primes = new ArrayList<Long>();
		for (long p = 2; p * p <= number; p++) {
			if (number % p == 0) {
				primes.add(p);
				while (number % p == 0) {
					number /= p;
				}
			}
		}
		if (number > 1) {
			primes.add(number);
		}
		return primes;
	}

	static long solutionNum(long constant) {
		long minX;
		if (constant % 2 == 1) {
			minX = 1;
		} else {
			minX = 2;
		}
		if (constant <= 3 * minX) {
			return 0;
		}
		long minY = (constant - 3 * minX) / 2 % 3;
		long maxX = (constant - 2 * minY) / 3;
		return (maxX - minX) / 2 + 1;
	}
}
