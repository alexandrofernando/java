public class P027 {
	public static void main(String args[]) {
		int max = 0;
		int answerA = 0;
		int answerB = 0;
		for (int a = -999; a <= 999; a++) {
			for (int b = -999; b <= 999; b++) {
				int consecutive = getConsecutive(a, b);
				if (consecutive > max) {
					max = consecutive;
					answerA = a;
					answerB = b;
				}
			}
		}
		System.out.println(answerA * answerB);
	}

	static int getConsecutive(int a, int b) {
		for (int n = 0;; n++) {
			int value = n * n + a * n + b;
			if (!isPrime(value)) {
				return n;
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
