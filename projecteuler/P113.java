public class P113 {
	public static void main(String args[]) {
		final int DIGIT_LIMIT = 100;
		long increasing[][] = new long[DIGIT_LIMIT][10];
		long decreasing[][] = new long[DIGIT_LIMIT][10];
		for (int i = 0; i < 10; i++) {
			increasing[0][i] = 1;
			decreasing[0][i] = 1;
		}
		long count = 9;
		for (int i = 1; i < DIGIT_LIMIT; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					increasing[i][j] += increasing[i - 1][k];
				}
				for (int k = j; k < 10; k++) {
					decreasing[i][j] += decreasing[i - 1][k];
				}
				if (j != 0) {
					count += increasing[i][j] + decreasing[i][j];
				}
			}
			count -= 9;
		}
		System.out.println(count);
	}
}
