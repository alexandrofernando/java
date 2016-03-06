package P3083__Children_of_the_Candy_Corn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int OFFSET_X[] = { -1, 0, 1, 0 };
	static final int OFFSET_Y[] = { 0, 1, 0, -1 };

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			int width = in.nextInt();
			int height = in.nextInt();
			char maze[][] = new char[height][width];
			Point start = null;
			for (int i = 0; i < height; i++) {
				String line = in.next();
				for (int j = 0; j < width; j++) {
					maze[i][j] = line.charAt(j);
					if (maze[i][j] == 'S') {
						start = new Point(i, j);
					}
				}
			}

			int startDirection;
			if (start.x == 0) {
				startDirection = 2;
			} else if (start.x == height - 1) {
				startDirection = 0;
			} else if (start.y == 0) {
				startDirection = 1;
			} else {
				startDirection = 3;
			}
			int leftDistance = findHandDistance(maze, start, startDirection, -1);
			int rightDistance = findHandDistance(maze, start, startDirection, 1);
			int shortestDistance = findShortestDistance(maze, start);
			System.out.println(leftDistance + " " + rightDistance + " "
					+ shortestDistance);
		}

		in.close();
	}

	static int findShortestDistance(char maze[][], Point start) {
		int distances[][] = new int[maze.length][maze[0].length];
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(start);
		distances[start.x][start.y] = 1;
		while (true) {
			Point head = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = head.x + OFFSET_X[i];
				int nextY = head.y + OFFSET_Y[i];
				if (nextX >= 0 && nextX < maze.length && nextY >= 0
						&& nextY < maze[0].length && maze[nextX][nextY] != '#'
						&& distances[nextX][nextY] == 0) {
					distances[nextX][nextY] = distances[head.x][head.y] + 1;
					if (maze[nextX][nextY] == 'E') {
						return distances[nextX][nextY];
					}
					queue.offer(new Point(nextX, nextY));
				}
			}
		}
	}

	static int findHandDistance(char maze[][], Point start, int startDirection,
			int wallDirection) {
		int distance = 1;
		Point p = new Point(start);
		int direction = startDirection;
		while (maze[p.x][p.y] != 'E') {
			while (maze[p.x + OFFSET_X[direction]][p.y + OFFSET_Y[direction]] == '#') {
				direction = turn(direction, -wallDirection);
			}
			p.x += OFFSET_X[direction];
			p.y += OFFSET_Y[direction];
			distance++;
			if (maze[p.x + OFFSET_X[turn(direction, wallDirection)]][p.y
					+ OFFSET_Y[turn(direction, wallDirection)]] != '#') {
				direction = turn(direction, wallDirection);
				p.x += OFFSET_X[direction];
				p.y += OFFSET_Y[direction];
				distance++;
			}
		}
		return distance;
	}

	static int turn(int direction, int offset) {
		return (direction + offset + 4) % 4;
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
}