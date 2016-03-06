public class P111 {
	public static void main(String args[]) {
		final int N = 10;
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = N - 1; j >= 1; j--) {
				long S = search(N, i, j, 0, 0);
				if (S > 0) {
					sum += S;
					break;
				}
			}
		}
		System.out.println(sum);
	}

	static long search(int digitNum, int targetDigit, int targetNum, int index,
			long number) {
		if (index == digitNum) {
			if (isPrime(number)) {
				return number;
			}
			return 0;
		}
		long sum = 0;
		if (index != 0 || targetDigit != 0) {
			sum += search(digitNum, targetDigit, targetNum - 1, index + 1,
					number * 10 + targetDigit);
		}
		if (index + targetNum < digitNum) {
			for (int i = (index == 0) ? 1 : 0; i < 10; i++) {
				if (i != targetDigit) {
					sum += search(digitNum, targetDigit, targetNum, index + 1,
							number * 10 + i);
				}
			}
		}
		return sum;
	}

	static boolean isPrime(long number) {
		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
