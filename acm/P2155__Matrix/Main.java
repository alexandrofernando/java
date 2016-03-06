package P2155__Matrix;

import java.util.Scanner;

public class Main {
	static int treeArray[][];
	static int N;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			if (t > 1) {
				System.out.println();
			}
			N = in.nextInt();
			treeArray = new int[N + 1][N + 1];
			int T = in.nextInt();
			for (int i = 0; i < T; i++) {
				String command = in.next();
				if (command.equals("C")) {
					int x1 = in.nextInt();
					int y1 = in.nextInt();
					int x2 = in.nextInt();
					int y2 = in.nextInt();
					change(x1, y1);
					change(x1, y2 + 1);
					change(x2 + 1, y1);
					change(x2 + 1, y2 + 1);
				} else if (command.equals("Q")) {
					int x = in.nextInt();
					int y = in.nextInt();
					System.out.println(getSumMod2(x, y));
				}
			}
		}
	}

	static int lowBit(int x) {
		return x & (-x);
	}

	static void change(int x, int y) {
		for (int i = x; i <= N; i = i + lowBit(i)) {
			for (int j = y; j <= N; j = j + lowBit(j)) {
				treeArray[i][j] = 1 - treeArray[i][j];
			}
		}
	}

	static int getSumMod2(int x, int y) {
		int sum = 0;
		for (int i = x; i >= 1; i -= lowBit(i)) {
			for (int j = y; j >= 1; j -= lowBit(j)) {
				sum = (sum + treeArray[i][j]) % 2;
			}
		}
		return sum;
	}
}