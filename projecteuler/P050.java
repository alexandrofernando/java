import java.util.ArrayList;

public class P050 {
	public static void main(String args[]) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int sum = 2;
		for (int i = 3; sum + i < 1000000; i += 2) {
			boolean isPrime = true;
			for (int j = 0; j < primes.size(); j++) {
				int p = primes.get(j);
				if (p * p > i) {
					break;
				}
				if (i % p == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
				sum += i;
			}
		}
		boolean found = false;
		for (int i = primes.size(); i >= 1; i--) {
			for (int j = 0; j + i - 1 < primes.size(); j++) {
				sum = 0;
				for (int k = j; k < j + i; k++) {
					sum += primes.get(k);
				}
				if (isPrime(sum)) {
					found = true;
					System.out.println(sum);
					break;
				}
			}
			if (found) {
				break;
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
