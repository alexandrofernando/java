public class P043 {
	static int digits[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static long sum = 0;

	public static void main(String args[]) {
		search(0);
		System.out.println(sum);
	}

	static void search(int index) {
		if (index == 9) {
			if (getNumber(1, 3) % 2 == 0 && getNumber(2, 4) % 3 == 0
					&& getNumber(3, 5) % 5 == 0 && getNumber(4, 6) % 7 == 0
					&& getNumber(5, 7) % 11 == 0 && getNumber(6, 8) % 13 == 0
					&& getNumber(7, 9) % 17 == 0) {
				sum += getNumber(0, 9);
			}
		} else {
			for (int i = index; i < digits.length; i++) {
				int temp = digits[i];
				for (int j = i; j > index; j--) {
					digits[j] = digits[j - 1];
				}
				digits[index] = temp;
				search(index + 1);
				temp = digits[index];
				for (int j = index; j < i; j++) {
					digits[j] = digits[j + 1];
				}
				digits[i] = temp;
			}
		}
	}

	static long getNumber(int begin, int end) {
		long number = 0;
		for (int i = begin; i <= end; i++) {
			number = number * 10 + digits[i];
		}
		return number;
	}
}
