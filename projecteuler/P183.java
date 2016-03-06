public class P183 {
	public static void main(String args[]) {
		int sum = 0;
		for (int n = 5; n <= 10000; n++) {
			int lower = (int) Math.floor(n / Math.E);
			int upper = lower + 1;
			int part;
			if (p(n, lower) > p(n, upper)) {
				part = lower;
			} else {
				part = upper;
			}
			if (isTerminate(n, part)) {
				sum -= n;
			} else {
				sum += n;
			}
		}
		System.out.println(sum);
	}

	static boolean isTerminate(int numerator, int denominator) {
		boolean visited[] = new boolean[denominator];
		int reminder = numerator % denominator;
		while (!visited[reminder] && reminder != 0) {
			visited[reminder] = true;
			reminder = reminder * 10 % denominator;
		}
		return reminder == 0;
	}

	static double p(int n, int k) {
		return k * Math.log((double) n / k);
	}
}
