public class P232 {
	public static void main(String args[]) {
		final int LIMIT = 100;
		double probs[][] = new double[LIMIT + 1][LIMIT + 1];
		probs[0][0] = 1;
		for (int i = 1; i <= LIMIT; i++) {
			probs[i][0] = 1;
			for (int j = 1; j <= LIMIT; j++) {
				int score = 1;
				for (int t = 1; score < j * 2; t++, score <<= 1) {
					double p = Math.pow(0.5, t);
					int restJ = Math.max(0, j - score);
					probs[i][j] = Math.max(probs[i][j], 0.5
							* ((1 - p) * probs[i - 1][j] + p
									* (probs[i][restJ] + probs[i - 1][restJ]))
							/ (1 - 0.5 * (1 - p)));
				}
			}
		}
		System.out.printf("%.8f", 0.5 * probs[LIMIT][LIMIT] + 0.5
				* probs[LIMIT - 1][LIMIT]);
	}
}
