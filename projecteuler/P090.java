import java.util.ArrayList;

public class P090 {
	public static void main(String args[]) {
		ArrayList<int[]> arrangements = new ArrayList<int[]>();
		for (int i = 0; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				for (int k = j + 1; k <= 9; k++) {
					for (int p = k + 1; p <= 9; p++) {
						for (int q = p + 1; q <= 9; q++) {
							for (int r = q + 1; r <= 9; r++) {
								arrangements
										.add(new int[] { i, j, k, p, q, r });
							}
						}
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < arrangements.size(); i++) {
			for (int j = i; j < arrangements.size(); j++) {
				int squares[] = new int[] { 1, 4, 9, 16, 25, 36, 49, 64, 81 };
				boolean valid = true;
				for (int k = 0; k < squares.length; k++) {
					if (!(contain(squares[k] / 10, arrangements.get(i)) && contain(
							squares[k] % 10, arrangements.get(j)))
							&& !(contain(squares[k] % 10, arrangements.get(i)) && contain(
									squares[k] / 10, arrangements.get(j)))) {
						valid = false;
						break;
					}
				}
				if (valid) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	static boolean contain(int digit, int cube[]) {
		for (int i = 0; i < cube.length; i++) {
			if (digit == cube[i] || (digit == 6 && cube[i] == 9)
					|| (digit == 9 && cube[i] == 6)) {
				return true;
			}
		}
		return false;
	}
}
