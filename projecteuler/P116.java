public class P116 {
	public static void main(String args[]) {
		final int LENGTH = 50;
		System.out.println((replace(LENGTH, new int[] { 1, 2 }) - 1)
				+ (replace(LENGTH, new int[] { 1, 3 }) - 1)
				+ (replace(LENGTH, new int[] { 1, 4 }) - 1));
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
