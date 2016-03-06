public class P156 {
	public static void main(String args[]) {
		long begin = 1;
		long end = 100000000000L;
		long sum = 0;
		for (int digit = 1; digit <= 9; digit++) {
			sum += search(begin, end, digit, f(begin, digit), f(end, digit));
		}
		System.out.println(sum);
	}

	static long f(long n, int digit) {
		long result = 0;
		for (long base = 1; base <= n; base *= 10) {
			result += Math.floor(n / (base * 10)) * base;
			int x = (int) ((n / base) % 10);
			if (digit < x) {
				result += base;
			} else if (digit == x) {
				result += n % base + 1;
			}
		}
		return result;
	}

	static long search(long begin, long end, int digit, long fBegin, long fEnd) {
		if (end - begin == 1) {
			return fBegin == begin ? begin : 0;
		}
		long middle = (begin + end) / 2;
		long fMiddle = f(middle, digit);
		long result = 0;
		// begin < middle < end
		// fBegin < fMiddle < fEnd
		if (!(fMiddle < begin || middle < fBegin)) {
			result += search(begin, middle, digit, fBegin, fMiddle);
		}
		if (!(fEnd < middle || end < fMiddle)) {
			result += search(middle, end, digit, fMiddle, fEnd);
		}
		return result;
	}
}
