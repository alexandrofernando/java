public class P318 {
	public static void main(String args[]) {
		final int LIMIT = 2011;
		int sum = 0;
		for (int p = 1; p + p + 1 <= LIMIT; p++) {
			for (int q = p + 1; p + q <= LIMIT
					&& (q + p - 1) * (q + p - 1) < 4 * p * q; q++) {
				int Npq = (int) Math.ceil(2011 / (2 * Math.log10(1 / (Math
						.sqrt(q) - Math.sqrt(p)))));
				sum += Npq;
			}
		}
		System.out.println(sum);
	}
}
