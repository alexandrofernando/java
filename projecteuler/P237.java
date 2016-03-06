public class P237 {
	static final int MODULO = 100000000;

	public static void main(String args[]) {
		final long N = 1000000000000L;
		int power[][] = new int[][] { { 2, 1, 0, 0 }, { 2, 0, 1, 0 },
				{ -2, 0, 0, 1 }, { 1, 0, 0, 0 } };
		int transit[][] = new int[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 },
				{ 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		long exponent = N - 4;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				transit = multiply(transit, power);
			}
			power = multiply(power, power);
			exponent /= 2;
		}
		int results[][] = multiply(new int[][] { { 8, 4, 1, 1 } }, transit);
		System.out.println(results[0][0]);
	}

	static int[][] multiply(int a[][], int b[][]) {
		int c[][] = new int[a.length][b[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				long sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += (long) a[i][k] * b[k][j];
				}
				c[i][j] = (int) (sum % MODULO);
			}
		}
		return c;
	}
}
