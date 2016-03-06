public class P153 {
	public static void main(String args[]) {
		int LIMIT = 100000000;
		long sum = 0;
		for (int a = 1; a <= LIMIT; a++) {
			sum += LIMIT / a * a;
			for (int b = 1; (long) a * a + b * b <= LIMIT; b++) {
				if (gcd(a, b) != 1) {
					continue;
				}
				int m = a * a + b * b;
				for (int common = 1; m * common <= LIMIT; common++) {
					sum += LIMIT / (m * common) * (a * common) * 2;
				}
			}
		}
		System.out.println(sum);
	}

	static int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		while (a % b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return b;
	}
}
