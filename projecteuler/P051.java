public class P051 {
	public static void main(String args[]) {
		boolean found = false;
		for (int i = 11;; i += 2) {
			if (!isPrime(i)) {
				continue;
			}
			int digits[] = getDigits(i);
			int digitNum = digits.length;
			for (int j = 1; j < (1 << digitNum); j++) {
				boolean replaced[] = decode(digitNum, j);
				boolean valid = true;
				int replacement = -1;
				for (int k = 0; k < digitNum; k++) {
					if (replaced[k]) {
						if (replacement == -1) {
							replacement = digits[k];
						} else if (digits[k] != replacement) {
							valid = false;
							break;
						}
					}
				}
				if (!valid) {
					continue;
				}
				int count = 0;
				for (int k = replaced[0] ? 1 : 0; k <= 9; k++) {
					int number = 0;
					for (int r = 0; r < digitNum; r++) {
						number = number * 10 + (replaced[r] ? k : digits[r]);
					}
					if (isPrime(number)) {
						count++;
					}
				}
				if (count == 8) {
					System.out.println(i);
					found = true;
					break;
				}
			}
			if (found) {
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

	static int[] getDigits(int number) {
		String str = new String(number + "");
		int digits[] = new int[str.length()];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = str.charAt(i) - '0';
		}
		return digits;
	}

	static boolean[] decode(int size, int number) {
		boolean ret[] = new boolean[size];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = (number % 2 == 1);
			number >>= 1;
		}
		return ret;
	}
}
