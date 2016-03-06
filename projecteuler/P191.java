public class P191 {
	public static void main(String args[]) {
		final int PERIOD = 30;
		int prizes[][][] = new int[PERIOD + 1][3][2];
		prizes[0][0][0] = 1;
		for (int i = 1; i <= PERIOD; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					// "O" (on time) at i-th day
					prizes[i][0][k] += prizes[i - 1][j][k];
					// "L" (late) at i-th day
					if (k >= 1) {
						prizes[i][0][k] += prizes[i - 1][j][k - 1];
					}
					// "A" (absent) at i-th day
					if (j >= 1) {
						prizes[i][j][k] += prizes[i - 1][j - 1][k];
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				count += prizes[PERIOD][i][j];
			}
		}
		System.out.println(count);
	}
}
