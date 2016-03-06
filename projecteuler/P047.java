public class P047 {
	public static void main(String args[]) {
		int consecutive = 0;
		for (int i = 2;; i++) {
			if (getPrimeFactorNum(i) == 4) {
				consecutive++;
			} else {
				consecutive = 0;
			}
			if (consecutive == 4) {
				System.out.println(i - 3);
				break;
			}
		}
	}

	static int getPrimeFactorNum(int number) {
		int count = 0;
		for (int i = 2; i * i <= number; i++) {
			if (!isPrime(i)) {
				continue;
			}
			if (number % i == 0) {
				count++;
				while (number % i == 0) {
					number /= i;
				}
			}
		}
		if (number > 1) {
			count++;
		}
		return count;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
