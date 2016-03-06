public class P046 {
	public static void main(String args[]) {
		for (int i = 3;; i += 2) {
			if (isPrime(i)) {
				continue;
			}
			boolean found = false;
			for (int j = 1; j <= Math.sqrt(i / 2); j++) {
				if (isPrime(i - 2 * j * j)) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println(i);
				break;
			}
		}
	}

	static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
