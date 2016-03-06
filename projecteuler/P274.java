import java.util.Arrays;

public class P274 {
	static final int LIMIT = 10000000;
	static boolean primes[] = new boolean[LIMIT];

	public static void main(String args[]) {
		sievePrimes();
		long sum = 0;
		for (int p = 2; p < primes.length; p++) {
			if (p == 2 || p == 5 || !primes[p]) {
				continue;
			}
			int target = p;
			switch (target % 10) {
			case 1:
				target *= 9;
				break;
			case 3:
				target *= 3;
				break;
			case 7:
				target *= 7;
				break;
			}
			int m = (target + 1) / 10;
			sum += m;
		}
		System.out.println(sum);
	}

	static void sievePrimes() {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = i + i; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}
	}
}
