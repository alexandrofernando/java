package P2318__TOYS;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		boolean firstCase = true;
		while (true) {
			int n = in.nextInt();
			if (n == 0) {
				break;
			}
			int m = in.nextInt();
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int uppers[] = new int[n + 2];
			int lowers[] = new int[n + 2];
			uppers[0] = x1;
			lowers[0] = x1;
			uppers[n + 1] = x2;
			lowers[n + 1] = x2;
			for (int i = 1; i <= n; i++) {
				uppers[i] = in.nextInt();
				lowers[i] = in.nextInt();
			}

			int counts[] = new int[n + 1];
			for (int i = 0; i < m; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				if (x < x1 || x > x2 || y < y2 || y > y1) {
					continue;
				}
				for (int j = 0; j < counts.length; j++) {
					if (compareTo(x, y, uppers[j], y1, lowers[j], y2) > 0
							&& compareTo(x, y, uppers[j + 1], y1,
									lowers[j + 1], y2) < 0) {
						counts[j]++;
						break;
					}
				}
			}
			if (!firstCase) {
				System.out.println();
			} else {
				firstCase = false;
			}
			for (int i = 0; i < counts.length; i++) {
				System.out.println(i + ": " + counts[i]);
			}
		}

		in.close();
	}

	static int compareTo(int x, int y, int x1, int y1, int x2, int y2) {
		return x * (y1 - y2) - ((x1 - x2) * y + (x2 * y1 - x1 * y2));
	}
}
