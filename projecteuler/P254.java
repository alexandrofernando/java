public class P254 {
	static int factorials[];

	public static void main(String args[]) {
		final int LIMIT = 150;
		final int CUT_POINT = 63;
		final char START_PREFIX = '9';
		final String START_SUFFIX = "999999";
		long sg[] = new long[LIMIT + 1];
		int rest = Math.min(CUT_POINT - 1, LIMIT);
		factorials = new int[10];
		factorials[0] = 1;
		for (int i = 1; i < factorials.length; i++) {
			factorials[i] = factorials[i - 1] * i;
		}
		long n[] = new long[10];
		n[1] = 1;
		while (true) {
			int fn = f(n);
			int sfn = digitSum(fn);
			if (sfn < sg.length && sg[sfn] == 0) {
				sg[sfn] = digitSum(n);
				rest--;
				if (rest == 0) {
					break;
				}
			}
			n = next(n);
		}

		char prefix = START_PREFIX;
		String suffix = START_SUFFIX;
		for (int i = CUT_POINT; i < sg.length; i++) {
			long fn = Long.parseLong(prefix + suffix);
			n = calcNFromFn(fn);
			sg[i] = digitSum(n);
			if (prefix < '9') {
				prefix++;
			} else {
				prefix = '1';
				suffix += "9";
			}
		}

		long sum = 0;
		for (int i = 1; i < sg.length; i++) {
			sum += sg[i];
		}
		System.out.println(sum);
	}

	static long[] calcNFromFn(long fn) {
		long n[] = new long[10];
		for (int i = 9; i >= 1; i--) {
			n[i] = fn / factorials[i];
			fn %= factorials[i];
		}
		return n;
	}

	static long digitSum(long n[]) {
		long sum = 0;
		for (int i = 1; i < n.length; i++) {
			sum += i * n[i];
		}
		return sum;
	}

	static int digitSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	static int f(long n[]) {
		int sum = 0;
		for (int i = 1; i < n.length; i++) {
			sum += n[i] * factorials[i];
		}
		return sum;
	}

	static long[] next(long n[]) {
		long nextN[] = new long[10];
		int last = 9;
		while (n[last] == 0) {
			last--;
		}
		if (last < 9) {
			for (int i = 1; i < last; i++) {
				nextN[i] = n[i];
			}
			nextN[last] = n[last] - 1;
			nextN[last + 1] = 1;
		} else {
			int lastLast = 8;
			while (lastLast >= 1 && n[lastLast] == 0) {
				lastLast--;
			}
			if (lastLast >= 1) {
				for (int i = 1; i < lastLast; i++) {
					nextN[i] = n[i];
				}
				nextN[lastLast] = n[lastLast] - 1;
				long restCount = n[9] + 1;
				for (int i = lastLast + 1; restCount > 0 && i < nextN.length; i++) {
					nextN[i] = (i == 9) ? restCount : Math.min(i, restCount);
					restCount -= nextN[i];
				}
			} else {
				long restCount = n[9] + 1;
				for (int i = 1; restCount > 0 && i < nextN.length; i++) {
					nextN[i] = (i == 9) ? restCount : Math.min(i, restCount);
					restCount -= nextN[i];
				}
			}
		}
		return nextN;
	}
}
