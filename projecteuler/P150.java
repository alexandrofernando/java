public class P150 {
	public static void main(String args[]) {
		final int SIZE = 1000;
		long triangle[][] = new long[SIZE][];
		long horizontalSum[][] = new long[SIZE][];
		long verticalSum[][] = new long[SIZE][];
		long diagonalSum[][] = new long[SIZE][];
		long t = 0;
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new long[i + 1];
			horizontalSum[i] = new long[i + 1];
			verticalSum[i] = new long[i + 1];
			diagonalSum[i] = new long[i + 1];
			for (int j = 0; j < triangle[i].length; j++) {
				t = (615949 * t + 797807) % (1 << 20);
				triangle[i][j] = t - (1 << 19);
				if (i == j) {
					verticalSum[i][j] = triangle[i][j];
				} else {
					verticalSum[i][j] = verticalSum[i - 1][j] + triangle[i][j];
				}
				if (j == 0) {
					horizontalSum[i][j] = triangle[i][j];
					diagonalSum[i][j] = triangle[i][j];
				} else {
					horizontalSum[i][j] = horizontalSum[i][j - 1]
							+ triangle[i][j];
					diagonalSum[i][j] = diagonalSum[i - 1][j - 1]
							+ triangle[i][j];
				}
			}
		}
		long min = Long.MAX_VALUE;
		for (int r1 = 0; r1 < triangle.length; r1++) {
			long accumulative = 0;
			for (int size = 1; r1 + size <= triangle.length; size++) {
				accumulative += horizontalSum[r1 + size - 1][size - 1];
				min = Math.min(min, accumulative);
				long sum = accumulative;
				for (int c1 = 1; c1 < triangle[r1].length; c1++) {
					sum = sum
							- (verticalSum[r1 + size - 1][c1 - 1] - verticalSum[r1 - 1][c1 - 1])
							+ (diagonalSum[r1 + size - 1][c1 + size - 1] - diagonalSum[r1 - 1][c1 - 1]);
					min = Math.min(min, sum);
				}
			}
		}
		System.out.println(min);
	}
}
