public class P242 {
	public static void main(String args[]) {
		final long N = 1000000000000L;
		long result = fSum(1 + (N - 1) / 4);
		System.out.println(result);
	}

	static long fSum(long n) {
		if (n <= 1) {
			return n;
		} else if (n % 2 == 0) {
			return 3 * fSum(n / 2);
		} else {
			return 3 * fSum((n - 1) / 2) + f(n);
		}
	}

	static long f(long n) {
		if (n <= 2) {
			return n;
		} else if (n % 2 == 0) {
			return 2 * f(n / 2);
		} else {
			return f((n + 1) / 2);
		}
	}
}
