package P3414__Pots;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int A;
	static int B;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		A = in.nextInt();
		B = in.nextInt();
		int C = in.nextInt();

		MoveFrom moveFroms[][] = new MoveFrom[A + 1][B + 1];
		moveFroms[0][0] = new MoveFrom(null, null);
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0));
		boolean found = false;
		while (!queue.isEmpty()) {
			Point head = queue.poll();
			Operation operations[] = { Operation.FILL1, Operation.FILL2,
					Operation.DROP1, Operation.DROP2, Operation.POUR12,
					Operation.POUR21 };
			Point nextPoints[] = { fill1(head), fill2(head), drop1(head),
					drop2(head), pour12(head), pour21(head) };
			Point end = null;
			for (int i = 0; i < operations.length; i++) {
				if (moveFroms[nextPoints[i].x][nextPoints[i].y] != null) {
					continue;
				}
				moveFroms[nextPoints[i].x][nextPoints[i].y] = new MoveFrom(
						head, operations[i]);
				if (nextPoints[i].x == C || nextPoints[i].y == C) {
					end = nextPoints[i];
					break;
				}
				queue.offer(nextPoints[i]);
			}
			if (end != null) {
				Point p = end;
				Stack<Operation> path = new Stack<Operation>();
				while (p != null) {
					if (moveFroms[p.x][p.y].operation != null) {
						path.push(moveFroms[p.x][p.y].operation);
					}
					p = moveFroms[p.x][p.y].prevPoint;
				}
				System.out.println(path.size());
				while (!path.empty()) {
					System.out.println(path.pop());
				}
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("impossible");
		}

		in.close();
	}

	static Point fill1(Point p) {
		return new Point(A, p.y);
	}

	static Point fill2(Point p) {
		return new Point(p.x, B);
	}

	static Point drop1(Point p) {
		return new Point(0, p.y);
	}

	static Point drop2(Point p) {
		return new Point(p.x, 0);
	}

	static Point pour12(Point p) {
		int amount = Math.min(p.x, B - p.y);
		return new Point(p.x - amount, p.y + amount);
	}

	static Point pour21(Point p) {
		int amount = Math.min(A - p.x, p.y);
		return new Point(p.x + amount, p.y - amount);
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

class MoveFrom {
	Point prevPoint;
	Operation operation;

	public MoveFrom(Point prevPoint, Operation operation) {
		this.prevPoint = prevPoint;
		this.operation = operation;
	}
}

enum Operation {
	FILL1("FILL(1)"), FILL2("FILL(2)"), DROP1("DROP(1)"), DROP2("DROP(2)"), POUR12(
			"POUR(1,2)"), POUR21("POUR(2,1)");
	String text;

	private Operation(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
