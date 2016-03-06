public class P149 {
	static final int SIZE = 2000;
	static int s[][];

	public static void main(String args[]) {
		s = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int k = i * SIZE + j + 1;
				if (k <= 55) {
					s[i][j] = (int) ((100003 - 200003 * k + 300007L * k * k * k) % 1000000 - 500000);
				} else {
					s[i][j] = (s[(k - 25) / SIZE][(k - 25) % SIZE]
							+ s[(k - 56) / SIZE][(k - 56) % SIZE] + 1000000) % 1000000 - 500000;
				}
			}
		}
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < SIZE; i++) {
			maxSum = Math.max(maxSum, maxSubsequence(i, 0, 0, 1));
		}
		for (int i = 0; i < SIZE; i++) {
			maxSum = Math.max(maxSum, maxSubsequence(0, i, 1, 0));
		}
		for (int i = 0; i < SIZE; i++) {
			maxSum = Math.max(maxSum, maxSubsequence(i, 0, -1, 1));
			maxSum = Math.max(maxSum, maxSubsequence(i, 0, 1, 1));
		}
		for (int i = 0; i < SIZE; i++) {
			maxSum = Math.max(maxSum, maxSubsequence(i, SIZE - 1, -1, -1));
			maxSum = Math.max(maxSum, maxSubsequence(i, SIZE - 1, 1, -1));
		}
		System.out.println(maxSum);
	}

	static int maxSubsequence(int x0, int y0, int offsetX, int offsetY) {
		int max = 0;
		int tempSum = 0;
		for (int x = x0, y = y0; x >= 0 && x < SIZE && y >= 0 && y < SIZE; x += offsetX, y += offsetY) {
			tempSum += s[x][y];
			if (tempSum > max) {
				max = tempSum;
			} else if (tempSum < 0) {
				tempSum = 0;
			}
		}
		return max;
	}
}
