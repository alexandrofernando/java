public class P086 {
	public static void main(String args[]) {
		int total = 0;
		for (int m = 1;; m++) {
			int sum = 0;
			for (int a = 1; a <= m * 2; a++) {
				if (isSquare(m * m + a * a)) {
					sum += a / 2 - ((a > m) ? (a - m - 1) : 0);
				}
			}
			total += sum;
			if (total > 1000000) {
				System.out.println(m);
				break;
			}
		}
	}

	static boolean isSquare(int number) {
		int squareRoot = (int) Math.round(Math.sqrt(number));
		return squareRoot * squareRoot == number;
	}
}
