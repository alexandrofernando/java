import java.util.ArrayList;

public class P010 {
	public static void main(String args[]) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		long sum = 2;
		for (int i = 3; i < 2000000; i += 2) {
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
				sum += (long) i;
			}
		}
		System.out.println(sum);
	}
}
