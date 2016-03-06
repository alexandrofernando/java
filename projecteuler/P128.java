public class P128 {
	public static void main(String args[]) {
		final int TARGET = 2000;
		int count = 2;
		for (long n = 8, offset = 12;; n += offset, offset += 6) {
			if (n - 1 != 7
					&& valid(n - 1, n + offset - 2, n - offset + 6, n - offset
							* 2 + 18)) {
				count++;
				if (count == TARGET) {
					System.out.println(n - 1);
					break;
				}
			}
			if (valid(n, n + offset - 1, n + offset * 2 + 5, n + offset + 1)) {
				count++;
				if (count == TARGET) {
					System.out.println(n);
					break;
				}
			}
		}
	}

	static boolean valid(long a, long b, long c, long d) {
		return isPrime(Math.abs(b - a)) && isPrime(Math.abs(c - a))
				&& isPrime(Math.abs(d - a));
	}

	static boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		for (long i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
