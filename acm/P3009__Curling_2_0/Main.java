package P3009__Curling_2_0;

import java.util.Scanner;

public class Main {
	static final int MOVE_NUM_LIMIT = 10;
	static int minMoveNum;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			int width = in.nextInt();
			int height = in.nextInt();
			if (width == 0 && height == 0) {
				break;
			}
			int[][] board = new int[height][width];
			int startR = -1;
			int startC = -1;
			int goalR = -1;
			int goalC = -1;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					board[i][j] = in.nextInt();
					if (board[i][j] == 2) {
						startR = i;
						startC = j;
					} else if (board[i][j] == 3) {
						goalR = i;
						goalC = j;
					}
				}
			}

			minMoveNum = Integer.MAX_VALUE;
			dfs(board, startR, startC, goalR, goalC, 0);
			if (minMoveNum == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(minMoveNum);
			}
		}

		in.close();
	}

	static void dfs(int[][] board, int startR, int startC, int goalR,
			int goalC, int moveNum) {
		int width = board.length;
		int height = board[0].length;
		int[] offsetR = { -1, 0, 1, 0 };
		int[] offsetC = { 0, 1, 0, -1 };
		for (int i = 0; i < offsetR.length; i++) {
			int nextR = startR;
			int nextC = startC;
			while (true) {
				nextR += offsetR[i];
				nextC += offsetC[i];
				if (nextR < 0 || nextR >= width || nextC < 0 || nextC >= height) {
					break;
				}
				if (nextR == goalR && nextC == goalC) {
					minMoveNum = Math.min(minMoveNum, moveNum + 1);
					break;
				}
				if (board[nextR][nextC] == 1) {
					if (moveNum + 1 < MOVE_NUM_LIMIT) {
						int nextStartR = nextR - offsetR[i];
						int nextStartC = nextC - offsetC[i];
						if (!(nextStartR == startR && nextStartC == startC)) {
							board[nextR][nextC] = 0;
							dfs(board, nextStartR, nextStartC, goalR, goalC,
									moveNum + 1);
							board[nextR][nextC] = 1;
						}
					}
					break;
				}
			}
		}
	}
}
