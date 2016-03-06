import java.util.ArrayList;

public class P003 {
	public static void main(String args[]) {
		ArrayList<Long> primes = new ArrayList<Long>();
		long n = 1;
		long number = 600851475143L;
		while (number != 1) {
			boolean isPrime;
			do {
				isPrime = true;
				n += 2;
				for (int i = 0; i < primes.size(); i++) {
					long p = primes.get(i);
					if (p * p > number) {
						break;
					}
					if (n % p == 0) {
						isPrime = false;
						break;
					}
				}
			} while (!isPrime);
			primes.add(n);
			while (number % n == 0) {
				number /= n;
			}
		}
		System.out.println(n);
	}
}
