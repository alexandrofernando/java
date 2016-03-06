public class P112 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1;; i++) {
			if (!isBouncy(i)) {
				count++;
			}
			if (i % 100 == 0 && i / 100 * 99 == count) {
				System.out.println(i);
				break;
			}
		}
	}

	static boolean isBouncy(int number) {
		String str = number + "";
		boolean increasing = true;
		boolean decreasing = true;
		for (int i = 0; i < str.length() - 1; i++) {
			char ch1 = str.charAt(i);
			char ch2 = str.charAt(i + 1);
			if (ch1 < ch2) {
				decreasing = false;
			} else if (ch1 > ch2) {
				increasing = false;
			}
			if (!increasing && !decreasing) {
				return false;
			}
		}
		return true;
	}
}
