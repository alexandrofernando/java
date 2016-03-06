public class P120 {
	public static void main(String args[]) {
		int sum = 0;
		for (int a = 3; a <= 1000; a++) {
			boolean used[] = new boolean[a * a];
			int maxR = -1;
			for (int r = a << 1; !used[r]; r = (r + (a << 2)) % used.length) {
				used[r] = true;
				maxR = Math.max(maxR, r);
			}
			sum += maxR;
		}
		System.out.println(sum);
	}
}
