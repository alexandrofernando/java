public class P037 {
	static int sum = 0;

	public static void main(String args[]) {
		search(2);
		search(3);
		search(5);
		search(7);
		System.out.println(sum);
	}

	static void search(int number) {
		for (int i = 1; i <= 9; i += 2) {
			int next = number * 10 + i;
			if (isPrime(next)) {
				if (isValid(next)) {
					sum += next;
				}
				search(next);
			}
		}
	}

	static boolean isValid(int number) {
		while (number != 0) {
			if (!isPrime(number)) {
				return false;
			}
			number %= (int) Math.pow(10, Math.floor(Math.log10(number)));
		}
		return true;
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
