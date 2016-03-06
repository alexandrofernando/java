public class P007 {
	public static void main(String args[]) {
		int primes[] = new int[10001];
		primes[0] = 2;
		int number = 1;
		for (int i = 1; i < primes.length; i++) {
			boolean isPrime;
			do {
				number += 2;
				isPrime = true;
				for (int j = 0; j < i; j++) {
					if (number % primes[j] == 0) {
						isPrime = false;
						break;
					}
				}
			} while (!isPrime);
			primes[i] = number;
		}
		System.out.println(number);
	}
}
