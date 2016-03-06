import java.util.ArrayList;

public class P134 {
	public static void main(String args[]) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(3);
		for (int i = 5; i <= 1000003; i += 2) {
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
		long sum = 0;
		for (int i = 1; i < primes.size() - 1; i++) {
			sum += search(primes.get(i), primes.get(i + 1));
		}
		System.out.println(sum);
	}

	static long search(int p1, int p2) {
		int unit = (int) Math.pow(10, new String(p1 + "").length());
		int step = unit % p2;
		int number = p1;
		for (int i = 1;; i++) {
			number = (number + step) % p2;
			if (number == 0) {
				return (long) i * unit + p1;
			}
		}
	}
}
