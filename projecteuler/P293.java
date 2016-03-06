import java.util.HashSet;

public class P293 {
	static final int LIMIT = 1000000000;
	static HashSet<Integer> pseudoFortunate = new HashSet<Integer>();

	public static void main(String args[]) {
		search(2, 2);
		int sum = 0;
		for (int pf : pseudoFortunate) {
			sum += pf;
		}
		System.out.println(sum);
	}

	static void search(int prime, int number) {
		for (int m = 2;; m++) {
			if (isPrime(number + m)) {
				pseudoFortunate.add(m);
				break;
			}
		}
		if ((long) number * prime < LIMIT) {
			search(prime, number * prime);
			for (int nextPrime = prime + 1;; nextPrime++) {
				if (isPrime(nextPrime)) {
					if ((long) number * nextPrime < LIMIT) {
						search(nextPrime, number * nextPrime);
					}
					break;
				}
			}
		}
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
