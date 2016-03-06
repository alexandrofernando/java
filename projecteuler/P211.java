import java.util.ArrayList;

public class P211 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static final int LIMIT = 64000000;

	public static void main(String args[]) {
		long sum = 0;
		buildPrimes();
		for (int n = 1; n < LIMIT; n++) {
			if (n % 1000000 == 0) {
				System.out.println(n);
			}
			if (isSquare(phi2(n))) {
				sum += n;
			}
		}
		System.out.println(sum);
	}

	static void buildPrimes() {
		primes.add(2);
		for (int n = 3; n * n <= LIMIT; n += 2) {
			boolean isPrime = true;
			for (int i = 0; i < primes.size(); i++) {
				int p = primes.get(i);
				if (p * p > n) {
					break;
				}
				if (n % p == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(n);
			}
		}
	}

	static long phi2(long n) {
		long result = 1;
		for (int i = 0; i < primes.size(); i++) {
			int p = primes.get(i);
			if (p * p > n) {
				break;
			}
			if (n % p == 0) {
				int count = 0;
				while (n % p == 0) {
					n /= p;
					count++;
				}
				long sum = 1;
				long a = p * p;
				for (int j = 0; j < count; j++) {
					sum += a;
					a *= p * p;
				}
				result *= sum;
			}
		}
		if (n > 1) {
			result *= (n * n + 1);
		}
		return result;
	}

	static boolean isSquare(long number) {
		long root = (long) Math.round(Math.sqrt(number));
		return root * root == number;
	}
}
