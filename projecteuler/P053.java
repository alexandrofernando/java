public class P053 {
	public static void main(String args[]) {
		int count = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 0; r + r <= n; r++) {
				int c = C(n, r);
				if (c < 0) {
					System.out.println(c);
				}
				if (c > 1000000) {
					if (n % 2 == 0) {
						if (r + r == n) {
							count++;
						} else {
							count += 1 + (n / 2 - r) * 2;
						}
					} else {
						count += (n / 2 - r + 1) * 2;
					}
					break;
				}
			}
		}
		System.out.println(count);
	}

	static int C(int n, int r) {
		long c = 1;
		for (int i = n; i > n - r; i--) {
			c *= i;
		}
		for (int i = 1; i <= r; i++) {
			c /= i;
		}
		return (int) c;
	}
}
