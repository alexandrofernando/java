public class P246 {
	static long aa = 7500 * 7500;
	static long bb = 2500 * 2500 * 5;

	public static void main(String args[]) {
		long xMin = 0;
		long xMax = 0;
		int result = 0;
		for (long y = 0;; y++) {
			while (xMin > 0 && isOutOfEllipse(xMin, y)) {
				xMin--;
			}
			while (!isOutOfEllipse(xMin, y)) {
				xMin++;
			}
			while (!isOutOfEllipse(xMax, y)) {
				xMax++;
			}
			while (!isRPSWithin45Degree(xMax, y)) {
				xMax++;
			}
			while (isRPSWithin45Degree(xMax, y)) {
				xMax--;
			}
			if (xMax < 0) {
				break;
			}
			int latticeLine = (int) ((xMin == 0) ? (xMax * 2 + 1) : ((xMax
					- xMin + 1) * 2));
			if (y == 0) {
				result += latticeLine;
			} else {
				result += latticeLine * 2;
			}
		}
		System.out.println(result);
	}

	static boolean isOutOfEllipse(long x, long y) {
		return bb * x * x + aa * y * y > aa * bb;
	}

	static boolean isRPSWithin45Degree(long x, long y) {
		return x * x + y * y - aa - bb > 0
				&& 4 * (x * x * bb + y * y * aa - aa * bb) <= (x * x + y * y
						- aa - bb)
						* (x * x + y * y - aa - bb);
	}
}
