public class P207 {
	public static void main(String args[]) {
		long x = 1;
		for (int t = 1;; t++) {
			x *= 2;
			if (t * 12345 < x - 1) {
				x = (t - 1) * 12345 + 2;
				System.out.println(x * x - x);
				break;
			}
		}
	}
}
