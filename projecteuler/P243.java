import java.util.ArrayList;

public class P243 {
	public static void main(String args[]) {
		final double LIMIT = 15499.0 / 94744;
		long d = 1;
		long s = 1;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int n = 2;; n++) {
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
				d *= n;
				s *= (n - 1);
				double u = (double) s / d;
				if (u < LIMIT) {
					if ((double) s / (d - 1) < LIMIT) {
						System.out.println(d);
						break;
					}
					long x = (long) Math.ceil(LIMIT / (LIMIT - u) / d + (1E-9));
					long temp = x;
					for (int i = 0; i < primes.size(); i++) {
						int p = primes.get(i);
						while (temp % p == 0) {
							temp /= p;
						}
					}
					if (temp == 1) {
						System.out.println(d * x);
						break;
					}
				}
			}
		}
	}
}
