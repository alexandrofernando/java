public class P130 {
	public static void main(String args[]) {
		int number = 4;
		int sum = 0;
		for (int i = 0; i < 25; i++) {
			while (number % 2 == 0 || number % 5 == 0 || isPrime(number)
					|| (number - 1) % repunitLen(number) != 0) {
				number++;
			}
			sum += number;
			number++;
		}
		System.out.println(sum);
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int repunitLen(int number) {
		int p = 1;
		int reminder = 1;
		while (reminder != 0) {
			p++;
			reminder = (reminder * 10 + 1) % number;
		}
		return p;
	}
}
