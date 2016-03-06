import java.util.ArrayList;

public class P213 {
	static final int SIZE = 30;

	public static void main(String args[]) {
		final int RING = 50;
		double transfer[][] = new double[SIZE * SIZE][SIZE * SIZE];
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				int from = encode(x, y);
				int offsetX[] = new int[] { -1, 0, 1, 0 };
				int offsetY[] = new int[] { 0, 1, 0, -1 };
				ArrayList<Integer> directions = new ArrayList<Integer>();
				for (int i = 0; i < 4; i++) {
					int newX = x + offsetX[i];
					int newY = y + offsetY[i];
					if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
						directions.add(i);
					}
				}
				for (int i = 0; i < directions.size(); i++) {
					int direction = directions.get(i);
					int to = encode(x + offsetX[direction], y
							+ offsetY[direction]);
					transfer[from][to] = 1.0 / directions.size();
				}
			}
		}
		double t[][] = new double[SIZE * SIZE][SIZE * SIZE];
		for (int i = 0; i < t.length; i++) {
			t[i][i] = 1;
		}
		for (int i = RING; i > 1; i >>= 1) {
			if ((i & 1) == 1) {
				t = multiple(t, transfer);
			}
			transfer = multiple(transfer, transfer);
		}
		t = multiple(t, transfer);
		double nonOccupied[][] = new double[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				nonOccupied[i][j] = 1;
			}
		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				double p[][] = new double[1][SIZE * SIZE];
				p[0][encode(i, j)] = 1;
				p = multiple(p, t);
				for (int x = 0; x < SIZE; x++) {
					for (int y = 0; y < SIZE; y++) {
						nonOccupied[x][y] *= 1 - p[0][encode(x, y)];
					}
				}
			}
		}
		double sum = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sum += nonOccupied[i][j];
			}
		}
		System.out.printf("%.6f", sum);
	}

	static double[][] multiple(double a[][], double b[][]) {
		double c[][] = new double[a.length][b[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	static int encode(int x, int y) {
		return x * SIZE + y;
	}
}
