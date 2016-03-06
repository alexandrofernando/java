// VM arguments: -Xms32m -Xmx800m

public class P136 {
	public static void main(String args[]) {
		final int LIMIT = 50000000;
		int solutionNumbers[] = new int[LIMIT];
		for (long z = 1; z < LIMIT * 2; z++) {
			long a0 = z / 3 + 1;
			long n = -z * z + 2 * a0 * z + 3 * a0 * a0;
			for (long a = a0;; a++, n += 2 * z + 6 * a - 3) {
				if (n >= LIMIT) {
					break;
				}
				solutionNumbers[(int) n]++;
			}
		}
		int count = 0;
		for (int i = 1; i < solutionNumbers.length; i++) {
			if (solutionNumbers[i] == 1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
