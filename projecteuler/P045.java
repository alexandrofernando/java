public class P045 {
	public static void main(String args[]) {
		for (long n = 144;; n++) {
			long hn = n * (2 * n - 1);
			if (isTriangle(hn) && isPentagonal(hn)) {
				System.out.println(hn);
				break;
			}
		}
	}

	static boolean isTriangle(long number) {
		long x = (long) Math.sqrt(number * 2);
		return x * (x + 1) / 2 == number;
	}

	static boolean isPentagonal(long number) {
		long x = (long) (Math.sqrt(2.0 * number / 3 + 1.0 / 36) + 1.0 / 6);
		return x * (3 * x - 1) / 2 == number;
	}
}
