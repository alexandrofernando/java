package P3752__Alphabetical_rotation_game;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int column = in.nextInt();
		char matrix[][] = new char[row][column];
		char current = 'Z';
		int currentX = 0;
		int currentY = -1;
		int offsetX[] = new int[] { 0, 1, 0, -1 };
		int offsetY[] = new int[] { 1, 0, -1, 0 };
		int step[] = new int[] { column, row - 1 };
		int direction = 0;
		while (step[direction % 2] != 0) {
			for (int i = 0; i < step[direction % 2]; i++) {
				currentX += offsetX[direction];
				currentY += offsetY[direction];
				current = (char) ((current - 'A' + 1) % 26 + 'A');
				matrix[currentX][currentY] = current;
			}
			step[direction % 2]--;
			direction = (direction + 1) % 4;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("   " + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
