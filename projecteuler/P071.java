public class P071 {
	public static void main(String args[]) {
		int maxN = 0;
		int maxD = 1;
		for (int d = 1; d <= 1000000; d++) {
			if (d == 7) {
				continue;
			}
			int n = (int) (3.0 / 7 * d);
			if (gcd(d, n) != 1) {
				continue;
			}
			if (n * maxD > maxN * d) {
				maxN = n;
				maxD = d;
			}
		}
		System.out.println(maxN);
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return 1;
		}
		while (a % b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return b;
	}
}
