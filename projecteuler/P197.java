public class P197 {
	public static void main(String args[]) {
		double u = -1;
		double prev0 = -1;
		double prev1 = -1;
		boolean finish0 = false;
		boolean finish1 = false;
		for (long i = 1; i <= (1E12) + 1 && (!finish0 || !finish1); i++) {
			u = f(u);
			if (i % 2 == 0) {
				if (u == prev0) {
					finish0 = true;
				}
				prev0 = u;
			} else {
				if (u == prev1) {
					finish1 = true;
				}
				prev1 = u;
			}
		}
		System.out.printf("%.9f", prev0 + prev1);
	}

	static double f(double u) {
		return Math.floor(Math.pow(2, 30.403243784 - u * u)) * 1E-9;
	}
}
