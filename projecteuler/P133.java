public class P133 {
	public static void main(String args[]) {
		int sum = 2 + 3 + 5;
		for (int i = 7; i < 100000; i += 2) {
			if (isPrime(i)) {
				int p = period(i);
				while (p % 2 == 0) {
					p /= 2;
				}
				while (p % 5 == 0) {
					p /= 5;
				}
				if (p != 1) {
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}

	static boolean isPrime(int number) {
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int period(int number) {
		int p = 1;
		int reminder = 10 % number;
		while (reminder != 1) {
			p++;
			reminder = reminder * 10 % number;
		}
		return p;
	}
}
