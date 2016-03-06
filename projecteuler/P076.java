public class P076 {
	public static void main(String args[]) {
		int ways[][] = new int[101][101];
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				ways[i][j] = ways[i][j - 1];
				for (int k = 1; k * j <= i; k++) {
					ways[i][j] += ways[i - k * j][j - 1];
					if (k * j == i) {
						ways[i][j]++;
					}
				}
			}
			for (int j = i + 1; j <= 100; j++) {
				ways[i][j] = ways[i][i];
			}
		}
		System.out.println(ways[100][100] - 1);
	}
}
