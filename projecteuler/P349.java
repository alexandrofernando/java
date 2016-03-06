public class P349 {
	static final int CYCLE = 104;
	static boolean history[] = new boolean[CYCLE * 2];
	static int pos = 0;

	public static void main(String args[]) {
		final long STEP = 1000000000000000000L;
		final int AFTER_STEP = 10000;
		final int ROW = 1000;
		final int COLUMN = 1000;
		final int OFFSET_X[] = new int[] { -1, 0, 1, 0 };
		final int OFFSET_Y[] = new int[] { 0, 1, 0, -1 };
		int direction = 0;
		boolean grids[][] = new boolean[ROW][COLUMN];
		int x = ROW / 2;
		int y = COLUMN / 2;
		int blackNum = 0;
		int count = 0;
		while (count <= AFTER_STEP || !isRepeated()) {
			if (grids[x][y]) {
				direction = (direction + 3) % 4;
				blackNum--;
			} else {
				direction = (direction + 1) % 4;
				blackNum++;
			}
			grids[x][y] = !grids[x][y];
			history[pos] = grids[x][y];
			pos = (pos + 1) % history.length;
			count++;
			x += OFFSET_X[direction];
			y += OFFSET_Y[direction];
		}
		int cycleDelta = countBlackDelta(CYCLE);
		long cycleNum = (STEP - count) / CYCLE;
		int rest = (int) ((STEP - count) % CYCLE);
		int restDelta = countBlackDelta(rest);
		long answer = blackNum + cycleDelta * cycleNum + restDelta;
		System.out.println(answer);
	}

	static int countBlackDelta(int number) {
		int delta = 0;
		for (int i = 0; i < number; i++) {
			if (history[(pos + i) % history.length]) {
				delta++;
			} else {
				delta--;
			}
		}
		return delta;
	}

	static boolean isRepeated() {
		for (int i = 0; i < CYCLE; i++) {
			if (history[(pos + i) % history.length] != history[(pos + i + CYCLE)
					% history.length]) {
				return false;
			}
		}
		return true;
	}
}
