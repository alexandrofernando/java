public class P035 {
	static int isPrimes[] = new int[1000000];

	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i < isPrimes.length; i++) {
			if (isPrimes[i] == 0) {
				boolean allPrime = true;
				int p = i;
				int c = 0;
				for (int j = 0; j == 0 || p != i; j++) {
					if ((isPrimes[p] = isPrime(p) ? 1 : 0) == 0) {
						allPrime = false;
					}
					p = rotate(p, (int) Math.pow(10, Math.floor(Math.log10(i))));
					c++;
				}
				if (allPrime) {
					count += c;
				}
			}
		}
		System.out.println(count);
	}

	static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int rotate(int current, int highestBase) {
		return current % 10 * highestBase + current / 10;
	}
}
