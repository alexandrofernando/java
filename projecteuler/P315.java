public class P315 {
	static int transitions[] = new int[] { 6, 2, 5, 5, 4, 5, 6, 4, 7, 6 };
	static int transfers[][] = new int[][] { { 0, 4, 3, 3, 4, 3, 2, 2, 1, 2 },
			{ 4, 0, 5, 3, 2, 5, 6, 2, 5, 4 }, { 3, 5, 0, 2, 5, 4, 3, 5, 2, 3 },
			{ 3, 3, 2, 0, 3, 2, 3, 3, 2, 1 }, { 4, 2, 5, 3, 0, 3, 4, 2, 3, 2 },
			{ 3, 5, 4, 2, 3, 0, 1, 3, 2, 1 }, { 2, 6, 3, 3, 4, 1, 0, 4, 1, 2 },
			{ 2, 2, 5, 3, 2, 3, 4, 0, 3, 2 }, { 1, 5, 2, 2, 3, 2, 1, 3, 0, 1 },
			{ 2, 4, 3, 1, 2, 1, 2, 2, 1, 0 } };

	public static void main(String args[]) {
		final int A = 10000000;
		final int B = 20000000;
		boolean sieved[] = new boolean[B + 1];
		for (int i = 2; i < sieved.length; i++) {
			if (!sieved[i]) {
				for (int j = i + i; j < sieved.length; j += i) {
					sieved[j] = true;
				}
			}
		}
		int diff = 0;
		for (int number = A; number <= B; number++) {
			if (!sieved[number]) {
				int current = number;
				while (current >= 10) {
					int next = digitSum(current);
					diff += transitionMore(current, next)
							- transitionLess(current, next);
					current = next;
				}
			}
		}
		System.out.println(diff);
	}

	static int digitSum(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	static int transitionMore(int prev, int next) {
		int total = 0;
		while (prev != 0) {
			total += transitions[prev % 10];
			prev /= 10;
		}
		while (next != 0) {
			total += transitions[next % 10];
			next /= 10;
		}
		return total;
	}

	static int transitionLess(int prev, int next) {
		int total = 0;
		StringBuffer strPrev = new StringBuffer(prev + "").reverse();
		StringBuffer strNext = new StringBuffer(next + "").reverse();
		for (int i = 0; i < strPrev.length(); i++) {
			int digitPrev = strPrev.charAt(i) - '0';
			if (i < strNext.length()) {
				int digitNext = strNext.charAt(i) - '0';
				total += transfers[digitPrev][digitNext];
			} else {
				total += transitions[digitPrev];
			}
		}
		return total;
	}
}
