public class P114 {
	public static void main(String args[]) {
		final int LENGTH = 50;
		long ways[][] = new long[LENGTH + 1][2];
		ways[0][0] = 0;
		ways[0][1] = 1;
		for (int i = 1; i < ways.length; i++) {
			ways[i][1] = ways[i - 1][0] + ways[i - 1][1];
			for (int j = 3; i - j >= 0; j++) {
				ways[i][0] += ways[i - j][1];
			}
		}
		System.out.println(ways[LENGTH][0] + ways[LENGTH][1]);
	}
}
