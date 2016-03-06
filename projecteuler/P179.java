import java.util.ArrayList;

public class P179 {
	static ArrayList<Integer> primes;

	public static void main(String args[]) {
		final int LIMIT = 10000000;
		primes = new ArrayList<Integer>();
		for (int i = 2; i * i <= LIMIT; i++) {
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
		int previous = 2;
		for (int i = 3; i <= LIMIT; i++) {
			int divisorNum = findDivisorNum(i);
			if (divisorNum == previous) {
				count++;
			}
			previous = divisorNum;
		}
		System.out.println(count);
	}

	static int findDivisorNum(int number) {
		int divisorNum = 1;
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (prime * prime > number) {
				break;
			}
			if (number % prime == 0) {
				int count = 0;
				while (number % prime == 0) {
					number /= prime;
					count++;
				}
				divisorNum *= count + 1;
			}
		}
		if (number > 1) {
			divisorNum *= 2;
		}
		return divisorNum;
	}
}
