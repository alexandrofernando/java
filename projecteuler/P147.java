import java.util.ArrayList;

public class P147 {
	public static void main(String args[]) {
		final int ROW = 43;
		final int COLUMN = 47;
		int faces[][] = new int[ROW][COLUMN];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				faces[i][j] = Math.min(i, j) * 2 + 1;
			}
		}
		int points[][] = new int[ROW + 1][COLUMN + 1];
		for (int i = 0; i <= ROW; i++) {
			for (int j = 0; j <= COLUMN; j++) {
				points[i][j] = Math.min(i, j) * 2;
			}
		}
		int counts[][] = new int[ROW][COLUMN];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				counts[i][j] += (i + 1) * (j + 1);
				ArrayList<Integer> lengths = new ArrayList<Integer>();
				lengths.add(points[i + 1][j]);
				for (int r = i, c = j; r >= 0 && c < COLUMN; r--, c++) {
					lengths.add(faces[r][c]);
					lengths.add(points[r][c + 1]);
				}
				for (int k = 1; k < lengths.size(); k++) {
					counts[i][j + (k - 1) / 2] += Math.min(lengths.get(0),
							lengths.get(k));
				}
				for (int k = 2; k < lengths.size(); k++) {
					counts[i][j + (k - 1) / 2] += Math.min(lengths.get(1),
							lengths.get(k));
				}
			}
		}
		int sums[][] = new int[ROW][COLUMN];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				if (i == 0 && j == 0) {
					sums[i][j] = counts[i][j];
				} else if (i == 0) {
					sums[i][j] = sums[i][j - 1] + counts[i][j];
				} else if (j == 0) {
					sums[i][j] = sums[i - 1][j] + counts[i][j];
				} else {
					sums[i][j] = sums[i - 1][j] + sums[i][j - 1]
							- sums[i - 1][j - 1] + counts[i][j];
				}
			}
		}
		int total = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				total += sums[i][j];
			}
		}
		System.out.println(total);
	}
}
