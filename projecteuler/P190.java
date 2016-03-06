public class P190 {
	public static void main(String args[]) {
		int sum = 0;
		for (int m = 2; m <= 15; m++) {
			double p = 1;
			double x = 0;
			for (int i = 1; i <= m; i++) {
				x += 2.0 / (m + 1);
				for (int j = 0; j < i; j++) {
					p *= x;
				}
			}
			sum += (int) p;
		}
		System.out.println(sum);
	}
}
