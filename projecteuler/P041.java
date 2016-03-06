public class P041 {
	static int digits[] = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	static boolean found = false;

	public static void main(String args[]) {
		for (int i = 0; i < 9; i++) {
			search(i, i);
			if (found) {
				for (int j = i; j < 9; j++) {
					System.out.print(digits[j]);
				}
				System.out.println();
				break;
			}
		}
	}

	static void search(int curIndex, int beginIndex) {
		if (curIndex == 8) {
			int number = 0;
			for (int i = beginIndex; i < 9; i++) {
				number = number * 10 + digits[i];
			}
			if (isPrime(number)) {
				found = true;
			}
			return;
		}
		for (int i = curIndex; i < 9; i++) {
			int temp = digits[i];
			for (int j = i; j > curIndex; j--) {
				digits[j] = digits[j - 1];
			}
			digits[curIndex] = temp;
			search(curIndex + 1, beginIndex);
			if (found) {
				return;
			}
			temp = digits[curIndex];
			for (int j = curIndex; j < i; j++) {
				digits[j] = digits[j + 1];
			}
			digits[i] = temp;
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
