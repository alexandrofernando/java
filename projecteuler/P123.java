import java.util.ArrayList;

public class P123 {
	public static void main(String args[]) {
		final long LIMIT = 10000000000L;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int number = 1;
		for (int i = 2;; i++) {
			boolean isPrime;
			do {
				number += 2;
				isPrime = true;
				for (int j = 0; j < primes.size(); j++) {
					int prime = primes.get(j);
					if (prime * prime > number) {
						break;
					}
					if (number % prime == 0) {
						isPrime = false;
						break;
					}
				}
			} while (!isPrime);
			if (i % 2 == 1 && 2L * i * number > LIMIT) {
				System.out.println(i);
				break;
			}
			primes.add(number);
		}
	}
}
