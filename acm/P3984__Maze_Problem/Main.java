package P3984__Maze_Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		final int SIZE = 5;
		Scanner in = new Scanner(System.in);
		int maze[][] = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				maze[i][j] = in.nextInt();
			}
		}

		Point prevPoints[][] = new Point[SIZE][SIZE];
		prevPoints[0][0] = new Point(-1, -1);
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0));
		boolean found = false;
		while (true) {
			Point head = queue.poll();
			int offsetX[] = { -1, 0, 1, 0 };
			int offsetY[] = { 0, 1, 0, -1 };
			for (int i = 0; i < 4; i++) {
				int nextX = head.x + offsetX[i];
				int nextY = head.y + offsetY[i];
				if (nextX >= 0 && nextX < SIZE && nextY >= 0 && nextY < SIZE
						&& maze[nextX][nextY] == 0
						&& prevPoints[nextX][nextY] == null) {
					prevPoints[nextX][nextY] = new Point(head.x, head.y);
					if (nextX == SIZE - 1 && nextY == SIZE - 1) {
						found = true;
						break;
					}
					queue.offer(new Point(nextX, nextY));
				}
			}
			if (found) {
				break;
			}
		}

		Stack<Point> path = new Stack<Point>();
		int x = SIZE - 1;
		int y = SIZE - 1;
		while (x >= 0 && y >= 0) {
			path.push(new Point(x, y));
			Point prevPoint = prevPoints[x][y];
			x = prevPoint.x;
			y = prevPoint.y;
		}
		while (!path.empty()) {
			Point p = path.pop();
			System.out.println("(" + p.x + ", " + p.y + ")");
		}

		in.close();
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}