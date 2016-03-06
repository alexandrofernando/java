public class ProductOfDigits {
	public int smallestNumber(int N) {
		int digitNum = 0;
		for (int digit = 9; digit >= 2; digit--) {
			while (N % digit == 0) {
				N /= digit;
				digitNum++;
			}
		}
		if (N > 1) {
			return -1;
		}
		return Math.max(1, digitNum);
	}
}
