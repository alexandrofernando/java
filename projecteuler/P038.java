public class P038 {
	static int digits[] = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	static boolean found = false;

	public static void main(String args[]) {
		search(0);
		for (int i = 0; i < 9; i++) {
			System.out.print(digits[i]);
		}
	}

	static void search(int index) {
		if (index == 8) {
			for (int i = 0; i < 4; i++) {
				if (isValid(i)) {
					found = true;
					return;
				}
			}
		} else {
			for (int i = index; i < 9; i++) {
				int temp = digits[i];
				for (int j = i; j > index; j--) {
					digits[j] = digits[j - 1];
				}
				digits[index] = temp;
				search(index + 1);
				if (found) {
					return;
				}
				temp = digits[index];
				for (int j = index; j < i; j++) {
					digits[j] = digits[j + 1];
				}
				digits[i] = temp;
			}
		}
	}

	static boolean isValid(int index) {
		int number = 0;
		for (int i = 0; i <= index; i++) {
			number = number * 10 + digits[i];
		}
		int p = number;
		while (index < 8) {
			p += number;
			String str = new String(p + "");
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) - '0' != digits[index + 1 + i]) {
					return false;
				}
			}
			index += str.length();
		}
		return true;
	}
}
