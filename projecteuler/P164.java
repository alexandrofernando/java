public class P164 {
	public static void main(String args[]) {
		final int DIGIT_NUM = 20;
		long counts[][][] = new long[DIGIT_NUM + 1][10][10];
		for (int i = 2; i <= DIGIT_NUM; i++) {
			for (int j = (i == 2 ? 1 : 0); j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					if (i < 3) {
						counts[i][j][k] = 1;
					} else {
						for (int p = 0; j + k + p <= 9; p++) {
							counts[i][k][p] += counts[i - 1][j][k];
						}
					}
				}
			}
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				sum += counts[DIGIT_NUM][i][j];
			}
		}
		System.out.println(sum);
	}
}
