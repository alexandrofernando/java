import java.util.PriorityQueue;

public class P126 {
	public static void main(String args[]) {
		final int TARGET = 1000;
		PriorityQueue<Geometry> pq = new PriorityQueue<Geometry>();
		pq.add(new Geometry(1, 1, 1, 1, 1));
		int currentCubeNum = -1;
		int count = 0;
		while (true) {
			Geometry g = pq.poll();
			if (g.cubeNum == currentCubeNum) {
				count++;
			} else {
				if (count == TARGET) {
					System.out.println(currentCubeNum);
					break;
				}
				currentCubeNum = g.cubeNum;
				count = 1;
			}
			if (g.layer == 1) {
				if (g.addPos == 1) {
					pq.add(new Geometry(g.a + 1, g.b, g.c, 1, 1));
				}
				if (g.addPos <= 2 && g.b + 1 <= g.a) {
					pq.add(new Geometry(g.a, g.b + 1, g.c, 1, 2));
				}
				if (g.addPos <= 3 && g.c + 1 <= g.b) {
					pq.add(new Geometry(g.a, g.b, g.c + 1, 1, 3));
				}
			}
			pq.add(new Geometry(g.a, g.b, g.c, g.layer + 1, g.addPos));
		}
	}
}

class Geometry implements Comparable<Geometry> {
	int a;
	int b;
	int c;
	int layer;
	int cubeNum;
	int addPos;

	Geometry(int A, int B, int C, int theLayer, int theAddPos) {
		this.a = A;
		this.b = B;
		this.c = C;
		this.layer = theLayer;
		this.addPos = theAddPos;
		int C1 = 2 * (A * B + B * C + C * A);
		int C2 = (theLayer > 1) ? (theLayer - 1) * 4 * (A + B + C) : 0;
		int C3 = (theLayer > 2) ? (theLayer - 1) * (theLayer - 2) / 2 * 8 : 0;
		this.cubeNum = C1 + C2 + C3;
	}

	public int compareTo(Geometry another) {
		return this.cubeNum - another.cubeNum;
	}
}