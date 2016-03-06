public class P358 {
	static long sumDigit;

	public static void main(String args[]) {
		int lower = (int) (100000000000L / 138);
		int upper = (int) (100000000000L / 137);
		int lowerWOLastFive = lower / 100000;
		int upperWOLastFive = upper / 100000;

		int rightmosts[] = { 5, 6, 7, 8, 9 };
		int pLastDigits[] = new int[5];
		for (int i = pLastDigits.length - 1; i >= 0; i--) {
			int numberRightmost = 0;
			for (int j = i; j < rightmosts.length; j++) {
				numberRightmost = numberRightmost * 10 + rightmosts[j];
			}
			int numberPLast = 0;
			for (int j = i + 1; j < pLastDigits.length; j++) {
				numberPLast = numberPLast * 10 + pLastDigits[j];
			}
			int digit = numberRightmost * numberPLast + 1;
			for (int j = i; j < pLastDigits.length - 1; j++) {
				digit /= 10;
			}
			digit %= 10;
			pLastDigits[i] = digit;
		}
		int lastFive = 0;
		for (int d : pLastDigits) {
			lastFive = lastFive * 10 + d;
		}

		for (int i = lowerWOLastFive; i <= upperWOLastFive; i++) {
			int p = i * 100000 + lastFive;
			sumDigit = 0;
			if (isValid(p)) {
				System.out.println(sumDigit);
			}
		}
	}

	static boolean isValid(int p) {
		if (!isPrime(p)) {
			return false;
		}
		long remainder = 1;
		long sum = 0;
		for (int i = 0; i < p - 1; i++) {
			sum += remainder * 10 / p;
			remainder = remainder * 10 % p;
			if (i != p - 2 && remainder == 1) {
				return false;
			}
		}
		if (remainder == 1) {
			sumDigit = sum;
			return true;
		} else {
			return false;
		}
	}

	static boolean isPrime(int p) {
		for (int i = 3; i * i <= p; i += 2) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;
	}
}
