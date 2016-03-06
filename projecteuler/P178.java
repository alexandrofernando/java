public class P178 {
	public static void main(String args[]) {
		long numbers[][][] = new long[10][10][10];
		for (int i = 1; i < 10; i++) {
			numbers[i][i][i] = 1;
		}
		long total = 0;
		for (int step = 1; step <= 39; step++) {
			long newNumbers[][][] = new long[10][10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {
						if (i > 0) {
							newNumbers[i - 1][Math.min(j, i - 1)][k] += numbers[i][j][k];
						}
						if (i < 9) {
							newNumbers[i + 1][j][Math.max(k, i + 1)] += numbers[i][j][k];
						}
					}
				}
			}
			numbers = newNumbers;
			for (int i = 0; i < 10; i++) {
				total += numbers[i][0][9];
			}
		}
		System.out.println(total);
	}
}