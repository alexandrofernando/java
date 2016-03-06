public class P171 {
	static int LIMIT = 20;
	static boolean squares[] = new boolean[LIMIT * 9 * 9 + 1];
	static int counts[] = new int[10];
	static long answer = 0;
	static long MASK = 1000000000;

	public static void main(String args[]) {
		for (int i = 1; i * i < squares.length; i++) {
			squares[i * i] = true;
		}
		search(0, LIMIT);
		System.out.println(answer);
	}

	static void search(int digit, int rest) {
		if (digit == 10) {
			int fn = 0;
			for (int i = 0; i < counts.length; i++) {
				fn += counts[i] * i * i;
			}
			if (squares[fn]) {
				updateSum();
			}
			return;
		}
		for (int i = (digit == 9 ? rest : 0); i <= rest; i++) {
			counts[digit] = i;
			search(digit + 1, rest - i);
		}
	}

	static void updateSum() {
		for (int digit = 1; digit <= 9; digit++) {
			if (counts[digit] > 0) {
				long addition = digit;
				int rest = LIMIT - 1;
				for (int i = 0; i <= 9; i++) {
					int temp = i == digit ? counts[i] - 1 : counts[i];
					addition = addition * C(rest, temp) % MASK;
					rest -= temp;
				}
				addition = addition * 111111111 % MASK;
				answer = (answer + addition) % MASK;
			}
		}
	}

	static long C(int n, int m) {
		if (m + m > n) {
			return C(n, n - m);
		}
		long result = 1;
		for (int i = n; i > n - m; i--) {
			result = result * i;
		}
		for (int i = 1; i <= m; i++) {
			result = result / i;
		}
		return result % MASK;
	}
}
