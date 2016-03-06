public class P044 {
	public static void main(String args[]) {
		long n = 0;
		boolean found = false;
		while (!found) {
			n++;
			long pn = n * (3 * n - 1) / 2;
			for (long i = 1; i * i <= 2 * pn; i++) {
				if (2 * pn % i != 0) {
					continue;
				}
				long temp = 1 + 2 * pn / i - 3 * i;
				if (temp <= 0 || temp % 6 != 0) {
					continue;
				}
				long a = temp / 6;
				long b = a + i;
				long pa = a * (3 * a - 1) / 2;
				long pb = b * (3 * b - 1) / 2;
				if (solve(pa + pb) > 0) {
					found = true;
					System.out.println(pn);
					break;
				}
			}
		}
	}

	static long solve(long number) {
		long x = (long) (Math.sqrt(2.0 * number / 3 + 1.0 / 36) + 1.0 / 6);
		if (x * (3 * x - 1) / 2 == number) {
			return x;
		}
		return -1;
	}
}
