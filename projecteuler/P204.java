import java.util.ArrayList;

public class P204 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static final int LIMIT = 1000000000;
	static int count = 0;

	public static void main(String args[]) {
		generatePrimes(100);
		search(0, 1);
		System.out.println(count);
	}

	static void generatePrimes(int type) {
		for (int i = 2; i <= type; i++) {
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
			}
		}
	}

	static void search(int index, long hamming) {
		if (index == primes.size()) {
			count++;
			return;
		}
		while (hamming <= LIMIT) {
			search(index + 1, hamming);
			hamming *= primes.get(index);
		}
	}
}
