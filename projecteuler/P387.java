public class P387 {
	static long LIMIT = 100000000000000L;
	static long sum = 0;

	public static void main(String args[]) {
		for (int i = 1; i <= 9; i++) {
			search(i);
		}
		System.out.println(sum);
	}

	static void search(long number) {
		int digitSum = calcDigitSum(number);
		if (number % digitSum != 0) {
			return;
		}
		long quotient = number / digitSum;
		boolean strong = isPrime(quotient);
		for (int i = 0; i <= 9; i++) {
			long nextNumber = number * 10 + i;
			if (nextNumber >= LIMIT) {
				break;
			}
			if (strong && isPrime(nextNumber)) {
				sum += nextNumber;
			}
			search(nextNumber);
		}
	}

	static int calcDigitSum(long number) {
		int digitSum = 0;
		while (number != 0) {
			digitSum += number % 10;
			number /= 10;
		}
		return digitSum;
	}

	static boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
