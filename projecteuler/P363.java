public class P363 {
	public static void main(String args[]) {
		final double ERROR = 1E-11;

		// PI/4 = Area = (-3v^2+12v+10)/20
		double v = solveQuadraticEquation(3, -12, 5 * Math.PI - 10);

		int segmentNum = 1;
		double result = -1;
		while (true) {
			double x = 0;
			double y = 0;
			double length = 0;
			for (int j = 0; j <= segmentNum; j++) {
				double t = (double) j / segmentNum;
				double nextX = getX(t, v);
				double nextY = getY(t, v);
				if (j > 0) {
					length += distance(x, y, nextX, nextY);
				}
				x = nextX;
				y = nextY;
			}
			double newResult = 100 * (length - Math.PI / 2) / (Math.PI / 2);
			if (Math.abs(newResult - result) < ERROR) {
				break;
			}
			result = newResult;
			segmentNum *= 2;
		}
		System.out.printf("%.10f\n", result);
	}

	static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	static double getX(double t, double v) {
		return 3 * t * (1 - t) * (1 - t) * v + 3 * t * t * (1 - t) + t * t * t;
	}

	static double getY(double t, double v) {
		return (1 - t) * (1 - t) * (1 - t) + 3 * t * (1 - t) * (1 - t) + 3 * t
				* t * (1 - t) * v;
	}

	static double solveQuadraticEquation(double a, double b, double c) {
		return (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
	}
}
