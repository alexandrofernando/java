public class P135 {
	public static void main(String args[]) {
		int count = 0;
		for (int n = 1; n < 1000000; n++) {
			int solutionNum = 0;
			for (int y1 = 1; y1 * y1 <= n; y1++) {
				if (n % y1 == 0) {
					int y2 = n / y1;
					if ((y1 + y2) % 4 == 0) {
						int delta = (y1 + y2) / 4;
						if (delta < y1) {
							solutionNum++;
						}
						if (y1 != y2 && delta < y2) {
							solutionNum++;
						}
					}
				}
			}
			if (solutionNum == 10) {
				count++;
			}
		}
		System.out.println(count);
	}
}
