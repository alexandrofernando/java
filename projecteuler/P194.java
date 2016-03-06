public class P194 {
	final static long MODULO = 100000000;
	static boolean[][] adjacents = new boolean[][] {
			{ false, true, true, false, false, true, false },
			{ true, false, false, false, true, false, false },
			{ true, false, false, true, false, true, false },
			{ false, false, true, false, true, false, false },
			{ false, true, false, true, false, false, true },
			{ true, false, true, false, false, false, true },
			{ false, false, false, false, true, true, false } };

	public static void main(String args[]) {
		final int A = 25;
		final int B = 75;
		final int C = 1984;
		System.out.println(N(A, B, C));
	}

	static long N(int a, int b, int c) {
		int config[] = new int[7];
		long waysA = 0;
		long waysB = 0;
		for (int i = 3; i <= Math.min(7, c); i++) {
			config[0] = 1;
			config[1] = 2;
			long t[] = search(i, 3, config, 2);
			long factor = C(c - 2, i - 2);
			waysA = addMod(waysA, multiplyMod(t[0], factor));
			waysB = addMod(waysB, multiplyMod(t[1], factor));
		}

		long dp[][] = new long[a + 1][b + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= a; i++) {
			dp[i][0] = multiplyMod(dp[i - 1][0], waysA);
		}
		for (int i = 1; i <= b; i++) {
			dp[0][i] = multiplyMod(dp[0][i - 1], waysB);
		}
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				dp[i][j] = addMod(multiplyMod(dp[i - 1][j], waysA),
						multiplyMod(dp[i][j - 1], waysB));
			}
		}
		return multiplyMod(multiplyMod(dp[a][b], c), c - 1);
	}

	static long multiplyMod(long a, long b) {
		return (a * b) % MODULO;
	}

	static long addMod(long a, long b) {
		return (a + b) % MODULO;
	}

	static long C(int n, int k) {
		if (k + k > n) {
			return C(n, n - k);
		}
		long result = 1;
		for (int i = 1; i <= k; i++) {
			result *= n - i + 1;
			result /= i;
		}
		return result % MODULO;
	}

	static long[] search(int n, int used, int config[], int index) {
		if (index == config.length) {
			if (used + 1 != 1 << n) {
				return new long[] { 0, 0 };
			}
			if (config[1] == config[6]) {
				return new long[] { 0, 1 };
			} else {
				return new long[] { 1, 1 };
			}
		}
		long answer[] = new long[2];
		for (int i = 1; i <= n; i++) {
			boolean valid = true;
			for (int j = 0; j < index; j++) {
				if (adjacents[index][j]) {
					if (i == config[j]) {
						valid = false;
						break;
					}
				}
			}
			if (!valid) {
				continue;
			}
			config[index] = i;
			long temp[] = search(n, used | (1 << (i - 1)), config, index + 1);
			answer[0] = addMod(answer[0], temp[0]);
			answer[1] = addMod(answer[1], temp[1]);
		}
		return answer;
	}
}
