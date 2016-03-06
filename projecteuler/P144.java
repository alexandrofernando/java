public class P144 {
	public static void main(String args[]) {
		double x = 1.4;
		double y = -9.6;
		double k = (-9.6 - 10.1) / (1.4 - 0.0);
		int times = 0;
		while (!(x >= -0.01 && x <= 0.01 && y > 0)) {
			times++;
			double kn = -4 * x / y;
			double kn_2 = 2 * kn / (1 - kn * kn);
			k = (kn_2 - k) / (1 + kn_2 * k);
			double a = k * k + 4;
			double b = 2 * y * k - 2 * x * k * k;
			double c = y * y + x * x * k * k - 2 * x * y * k - 100;
			double sqrtDelta = Math.sqrt(b * b - 4 * a * c);
			double x0 = (-b - sqrtDelta) / (2 * a);
			double x1 = (-b + sqrtDelta) / (2 * a);
			double newX = (Math.abs(x - x0) < Math.abs(x - x1)) ? x1 : x0;
			y = y + k * (newX - x);
			x = newX;
		}
		System.out.println(times);
	}
}
