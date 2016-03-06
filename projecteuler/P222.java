public class P222 {
	public static void main(String args[]) {
		int r[] = new int[21];
		for (int i = 0; i < 10; i++) {
			r[i] = (49 - i * 2) * 1000;
		}
		for (int i = 10; i < r.length; i++) {
			r[i] = (10 + i * 2) * 1000;
		}
		double x = r[0];
		for (int i = 1; i < r.length; i++) {
			int longer = 100000 - r[i - 1];
			double offset = Math.sqrt((double) (r[i] + r[i - 1])
					* (r[i] + r[i - 1]) - (double) (longer - r[i])
					* (longer - r[i]));
			x += offset;
		}
		System.out.println(Math.round(x + r[r.length - 1]));
	}
}
