import java.util.ArrayList;

public class P308 {
	public static void main(String args[]) {
		final int PRIME_NUM = 10001;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int rest = PRIME_NUM;
		long totalStep = 0;
		for (int n = 2; rest > 0; n++) {
			int b = calcLargestDivisorLessN(n, primes);
			if (b == 1) {
				primes.add(n);
				rest--;
			}
			long step = n - 1 + (6L * n + 2) * (n - b);
			for (int d = b; d <= n - 1; d++) {
				step += 2 * (n / d);
			}
			step += b - 1;
			totalStep += step;
		}
		System.out.println(totalStep);
	}

	static int calcLargestDivisorLessN(int n, ArrayList<Integer> primes) {
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (prime * prime > n) {
				break;
			}
			if (n % prime == 0) {
				return n / prime;
			}
		}
		return 1;
	}
}
