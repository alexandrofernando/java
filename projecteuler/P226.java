public class P226 {
	public static void main(String args[]) {
		final double error = 5E-9;
		double prevArea = -1;
		int pieceNum = 1;
		double area;
		while (true) {
			area = 0;
			for (int i = 0; i < pieceNum; i++) {
				double x = 0.5 * i / pieceNum;
				double y = 0;
				long pow2 = 1;
				while (1 >= pow2 * error) {
					double valueS = s(pow2 * x);
					y += valueS / pow2;
					pow2 <<= 1;
				}
				double c = 0;
				c = 0.5 - Math.sqrt(1.0 / 16 - (x - 1.0 / 4) * (x - 1.0 / 4));
				if (y > c) {
					area += 0.5 * (y - c) / pieceNum;
				}
			}
			if (Math.abs(area - prevArea) < error) {
				break;
			}
			System.out.println("area = " + area);
			prevArea = area;
			pieceNum <<= 1;
		}
		System.out.printf("%.8f\n", area);
	}

	static double s(double x) {
		return Math.abs(x - Math.round(x));
	}
}
