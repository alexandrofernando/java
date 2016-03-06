public class P073 {
	public static void main(String args[]) {
		int answer = 0;
		for (int d = 1; d <= 12000; d++) {
			if (d == 2 || d == 3) {
				continue;
			}
			int n_lower = (int) Math.ceil(1.0 / 3 * d);
			int n_upper = (int) Math.floor(1.0 / 2 * d);
			for (int i = n_lower; i <= n_upper; i++) {
				if (gcd(d, i) == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
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
