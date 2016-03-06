public class P265 {
	static final int N = 5;
	static boolean used[] = new boolean[1 << N];
	static long S = 0;

	public static void main(String args[]) {
		used[0] = true;
		search(new int[1 << N], N, 0, 0);
		System.out.println(S);
	}

	static void search(int digits[], int index, long numeric, int num1) {
		if (index == digits.length) {
			if (num1 == 1 << (N - 1)) {
				S += numeric;
			}
			return;
		}
		int value = 0;
		for (int i = N - 1; i >= 1; i--) {
			value = (value << 1) + digits[index - i];
		}
		value <<= 1;
		for (int d = 0; d <= 1; d++) {
			if (!used[value + d]) {
				used[value + d] = true;
				digits[index] = d;
				search(digits, index + 1, (numeric << 1) + d, d == 1 ? num1 + 1
						: num1);
				used[value + d] = false;
			}
		}
	}
}
