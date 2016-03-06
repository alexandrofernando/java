public class P162 {
	static final int DIGIT_NUM = 16;
	static long wayNum = 0;
	static long power13[] = new long[DIGIT_NUM - 2];

	public static void main(String args[]) {
		long number = 1;
		for (int i = 0; i < power13.length; i++) {
			power13[i] = number;
			number *= 13;
		}
		search("", false, false, false);
		System.out.println(toHex(wayNum));
	}

	static void search(String current, boolean present0, boolean present1,
			boolean presentA) {
		int length = current.length();
		if (present0 && present1 && presentA) {
			if (current.charAt(0) == '0') {
				for (int i = length + 1; i <= DIGIT_NUM; i++) {
					wayNum += power13[i - length] * C(i - 1, length);
				}
			} else {
				for (int i = length; i <= DIGIT_NUM; i++) {
					wayNum += power13[i - length] * C(i, length);
				}
			}
		}
		if (length < DIGIT_NUM) {
			search(current + "0", true, present1, presentA);
			search(current + "1", present0, true, presentA);
			search(current + "A", present0, present1, true);
		}
	}

	static long C(int n, int m) {
		if (n - m < m) {
			return C(n, n - m);
		}
		long result = 1;
		for (int i = n; i > n - m; i--) {
			result *= i;
		}
		for (int i = 1; i <= m; i++) {
			result /= i;
		}
		return result;
	}

	static String toHex(long number) {
		String hex = "";
		while (number != 0) {
			int digit = (int) (number % 16);
			char representation[] = new char[] { '0', '1', '2', '3', '4', '5',
					'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			hex = representation[digit] + hex;
			number /= 16;
		}
		return hex;
	}
}
