public class P058 {
	public static void main(String args[]) {
		int total = 1;
		int totalPrime = 0;
		for (int i = 2;; i++) {
			int bottomRight = (i * 2 - 1) * (i * 2 - 1);
			int bottomLeft = bottomRight - 2 * (i - 1);
			int topLeft = bottomLeft - 2 * (i - 1);
			int topRight = topLeft - 2 * (i - 1);
			if (isPrime(bottomLeft)) {
				totalPrime++;
			}
			if (isPrime(topLeft)) {
				totalPrime++;
			}
			if (isPrime(topRight)) {
				totalPrime++;
			}
			total += 4;
			if (totalPrime * 10 < total) {
				System.out.println(i * 2 - 1);
				break;
			}
		}
	}

	static boolean isPrime(int number) {
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
