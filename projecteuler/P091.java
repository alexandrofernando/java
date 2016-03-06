public class P091 {
	public static void main(String args[]) {
		final int SIZE = 51;
		int count = 0;
		for (int p1 = 1; p1 < SIZE * SIZE; p1++) {
			int x1 = p1 / SIZE;
			int y1 = p1 % SIZE;
			for (int p2 = p1 + 1; p2 < SIZE * SIZE; p2++) {
				int x2 = p2 / SIZE;
				int y2 = p2 % SIZE;
				if (x1 * x2 + y1 * y2 == 0
						|| (x1 - x2) * x1 + (y1 - y2) * y1 == 0
						|| (x2 - x1) * x2 + (y2 - y1) * y2 == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
