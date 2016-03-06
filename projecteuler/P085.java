public class P085 {
	public static void main(String args[]) {
		int nearest = 0;
		int area = 0;
		for (int m = 1;; m++) {
			int start = (int) Math.sqrt(8000000.0 / m / (m + 1)) - 1;
			if (start < m) {
				break;
			}
			for (int n = start;; n++) {
				int number = m * (m + 1) / 2 * n * (n + 1) / 2;
				if (Math.abs(number - 2000000) < Math.abs(nearest - 2000000)) {
					nearest = number;
					area = m * n;
				}
				if (number > 20000000) {
					break;
				}
			}
		}
		System.out.println(area);
	}
}
