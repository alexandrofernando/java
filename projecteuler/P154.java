public class P154 {
	static final int LIMIT = 200000;
	static int count2[] = new int[LIMIT + 1];
	static int count5[] = new int[LIMIT + 1];

	public static void main(String args[]) {
		final int TARGET = 12;
		for (int i = 1; i <= LIMIT; i++) {
			count2[i] = count2[i - 1] + numberOf(2, i);
			count5[i] = count5[i - 1] + numberOf(5, i);
		}
		long answer = 0;
		for (int i = 0; i <= LIMIT; i++) {
			int part2_1 = C2(LIMIT, i);
			int part5_1 = C5(LIMIT, i);
			if (part2_1 >= TARGET && part5_1 >= TARGET) {
				answer += LIMIT - i + 1;
			} else {
				for (int j = 0; j <= LIMIT - i; j++) {
					int part2_2 = C2(LIMIT - i, j);
					int part5_2 = C5(LIMIT - i, j);
					if (part2_1 + part2_2 >= TARGET
							&& part5_1 + part5_2 >= TARGET) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}

	static int C2(int n, int m) {
		return count2[n] - count2[n - m] - count2[m];
	}

	static int C5(int n, int m) {
		return count5[n] - count5[n - m] - count5[m];
	}

	static int numberOf(int divisor, int number) {
		int count = 0;
		while (number % divisor == 0) {
			count++;
			number /= divisor;
		}
		return count;
	}
}
