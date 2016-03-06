public class P235 {
	public static void main(String args[]) {
		double lower = 1;
		double upper = 1.01;
		double r = 1;
		while (true) {
			double middle = (lower + upper) / 2;
			if (Math.abs(middle - r) < 5E-13) {
				System.out.printf("%.12f", r);
				break;
			}
			r = middle;
			if (S(middle) > -600000000000.0) {
				lower = middle;
			} else {
				upper = middle;
			}
		}
	}

	static double S(double r) {
		double sum = 0;
		for (int i = 1; i <= 5000; i++) {
			sum += U(i, r);
		}
		return sum;
	}

	static double U(int k, double r) {
		return (900 - 3 * k) * Math.pow(r, k - 1);
	}
}
