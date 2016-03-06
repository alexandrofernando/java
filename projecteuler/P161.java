import java.math.BigInteger;
import java.util.HashMap;

public class P161 {
	static final int ROW = 12;
	static final int COLUMN = 9;
	static boolean grid[][] = new boolean[ROW][COLUMN];
	static HashMap<BigInteger, Long> history = new HashMap<BigInteger, Long>();

	public static void main(String args[]) {
		long way = search(0, 0, 0);
		System.out.println(way);
	}

	static long search(int depth, int x, int y) {
		BigInteger code = encode();
		Long result = history.get(code);
		if (result != null) {
			return result;
		}
		long way = 0;
		if (depth * 3 == ROW * COLUMN) {
			way = 1;
		} else {
			int offsetX[][] = new int[][] { { 0, 0, 0 }, { 0, 0, 1 },
					{ 0, 0, 1 }, { 0, 1, 1 }, { 0, 1, 1 }, { 0, 1, 2 } };
			int offsetY[][] = new int[][] { { 0, 1, 2 }, { 0, 1, 0 },
					{ 0, 1, 1 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 0, 0 } };
			for (int i = 0; i < offsetX.length; i++) {
				if (empty(x, y, offsetX[i], offsetY[i])) {
					fill(x, y, offsetX[i], offsetY[i], true);
					int nextX = x;
					int nextY = y;
					do {
						nextY++;
						if (!valid(nextX, nextY)) {
							nextX++;
							nextY = 0;
						}
					} while (nextX < ROW && grid[nextX][nextY]);
					way += search(depth + 1, nextX, nextY);
					fill(x, y, offsetX[i], offsetY[i], false);
				}
			}
		}
		history.put(code, way);
		return way;
	}

	static BigInteger encode() {
		BigInteger code = BigInteger.ZERO;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				code = code.multiply(new BigInteger(2 + "")).add(
						grid[i][j] ? BigInteger.ONE : BigInteger.ZERO);
			}
		}
		return code;
	}

	static boolean valid(int x, int y) {
		return x >= 0 && x < ROW && y >= 0 && y < COLUMN;
	}

	static boolean empty(int x, int y, int deltaX[], int deltaY[]) {
		for (int i = 0; i < deltaX.length; i++) {
			if (!valid(x + deltaX[i], y + deltaY[i])
					|| grid[x + deltaX[i]][y + deltaY[i]]) {
				return false;
			}
		}
		return true;
	}

	static void fill(int x, int y, int deltaX[], int deltaY[], boolean value) {
		for (int i = 0; i < deltaX.length; i++) {
			grid[x + deltaX[i]][y + deltaY[i]] = value;
		}
	}
}
