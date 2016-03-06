public class P094 {
	public static void main(String args[]) {
		final int LIMIT = 1000000000;
		long sum = 0;
		for (int i = 1; 6 * i + 2 <= LIMIT; i++) {
			if (valid(2 * i + 1, i)) {
				sum += 6 * i + 2;
			}
			if (valid(2 * i + 1, i + 1) && 6 * i + 4 <= LIMIT) {
				sum += 6 * i + 4;
			}
		}
		System.out.println(sum);
	}

	static boolean valid(long a, long b) {
		return isSquare(a * a - b * b);
	}

	static boolean isSquare(long number) {
		long root = (long) Math.round(Math.sqrt(number));
		return root * root == number;
	}
}
