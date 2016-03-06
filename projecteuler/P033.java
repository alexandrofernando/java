public class P033 {
	public static void main(String args[]) {
		int product1 = 1;
		int product2 = 1;
		for (int a = 10; a <= 99; a++) {
			int a1 = a / 10;
			int a2 = a % 10;
			for (int b = a + 1; b <= 99; b++) {
				int b1 = b / 10;
				int b2 = b % 10;
				if (a2 == b1 && a * b2 == b * a1) {
					product1 *= a1;
					product2 *= b2;
				}
			}
		}
		int gcd = GCD(product1, product2);
		System.out.println(product2 / gcd);
	}

	static int GCD(int a, int b) {
		if (a < b) {
			return GCD(b, a);
		}
		while (a % b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return b;
	}
}
