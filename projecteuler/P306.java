public class P306 {
	public static void main(String args[]) {
		final int LIMIT = 1000000;
		final int PRECEDING[] = { 0, 1, 1, 2, 0, 3, 1, 1, 0, 3, 3, 2, 2, 4, 0,
				5, 2, 2, 3, 3, 0, 1, 1, 3, 0, 2, 1, 1, 0, 4, 5, 2, 7, 4, 0, 1,
				1, 2, 0, 3, 1, 1, 0, 3, 3, 2, 2, 4, 4, 5, 5, 2 };
		final int CYCLE[] = { 3, 3, 0, 1, 1, 3, 0, 2, 1, 1, 0, 4, 5, 3, 7, 4,
				8, 1, 1, 2, 0, 3, 1, 1, 0, 3, 3, 2, 2, 4, 4, 5, 5, 9 };
		int cycleZero = 0;
		for (int nimber : CYCLE) {
			if (nimber == 0) {
				cycleZero++;
			}
		}
		int countZero = 0;
		for (int nimber : PRECEDING) {
			if (nimber == 0) {
				countZero++;
			}
		}
		int rest = LIMIT - PRECEDING.length;
		countZero += rest / CYCLE.length * cycleZero;
		rest %= CYCLE.length;
		for (int i = 0; i < rest; i++) {
			if (CYCLE[i] == 0) {
				countZero++;
			}
		}
		System.out.println(LIMIT - countZero);
	}
}
