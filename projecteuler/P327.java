public class P327 {
	public static void main(String args[]) {
		long sum = 0;
		for (int c = 3; c <= 40; c++) {
			sum += M(c, 30);
		}
		System.out.println(sum);
	}

	static long M(int c, int r) {
		long result = 0;
		for (int i = 0; i < r + 1; i++) {
			if (result < c) {
				result++;
			} else {
				long backNum = (result - c + 1) / (c - 2);
				long remainder = (result - c + 1) % (c - 2);
				result = backNum * c + (remainder == 0 ? 0 : (remainder + 2))
						+ c;
			}
		}
		return result;
	}
}
