public class P182 {
	public static void main(String args[]) {
		final int P = 1009;
		final int Q = 3643;
		int phi = (P - 1) * (Q - 1);
		long sum = 0;
		for (int e = 2; e < phi; e++) {
			if (gcd(e, P - 1) == 1 && gcd(e, Q - 1) == 1
					&& gcd(e - 1, P - 1) == 2 && gcd(e - 1, Q - 1) == 2) {
				sum += e;
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
