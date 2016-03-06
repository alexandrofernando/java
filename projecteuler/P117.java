public class P117 {
	public static void main(String args[]) {
		final int LENGTH = 50;
		System.out.println(replace(LENGTH, new int[] { 1, 2, 3, 4 }));
	}

	static long replace(int length, int tiles[]) {
		long ways[] = new long[length + 1];
		ways[0] = 1;
		for (int i = 1; i < ways.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (i - tiles[j] >= 0) {
					ways[i] += ways[i - tiles[j]];
				}
			}
		}
		return ways[length];
	}
}
