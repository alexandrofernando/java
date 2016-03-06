public class P052 {
	public static void main(String args[]) {
		for (int i = 1;; i++) {
			if (new String(i + "").length() != new String(i * 6 + "").length()) {
				continue;
			}
			int digitCounts[][] = new int[7][];
			for (int j = 1; j <= 6; j++) {
				digitCounts[j] = getDigitCounts(i * j);
			}
			boolean sameDigits = true;
			for (int j = 2; j <= 6; j++) {
				for (int k = 0; k < 10; k++) {
					if (digitCounts[1][k] != digitCounts[j][k]) {
						sameDigits = false;
						break;
					}
				}
				if (!sameDigits) {
					break;
				}
			}
			if (sameDigits) {
				System.out.println(i);
				break;
			}
		}
	}

	static int[] getDigitCounts(int number) {
		int counts[] = new int[10];
		while (number != 0) {
			counts[number % 10]++;
			number /= 10;
		}
		return counts;
	}
}
