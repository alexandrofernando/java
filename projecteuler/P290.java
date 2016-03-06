public class P290 {
	public static void main(String args[]) {
		final int POWER = 18;
		final int FACTOR = 137;
		long amounts[][][] = new long[9 * POWER + 1][FACTOR][9 * POWER + 1];
		amounts[0][0][0] = 1;
		int s_limit = 0;
		for (int i = 0; i < POWER; i++) {
			long nextAmounts[][][] = new long[amounts.length][amounts[0].length][amounts[0][0].length];
			for (int s_n = 0; s_n <= s_limit; s_n++) {
				for (int carry = 0; carry < amounts[0].length; carry++) {
					for (int s_remainder = 0; s_remainder <= s_limit; s_remainder++) {
						for (int digit = 0; digit <= 9; digit++) {
							int temp = 137 * digit + carry;
							nextAmounts[s_n + digit][temp / 10][s_remainder
									+ temp % 10] += amounts[s_n][carry][s_remainder];
						}
					}
				}
			}
			amounts = nextAmounts;
			s_limit += 9;
		}
		long result = 0;
		for (int s_n = 0; s_n < amounts.length; s_n++) {
			for (int carry = 0; carry < amounts[0].length; carry++) {
				int s_remainder = s_n - calcDigitSum(carry);
				if (s_remainder >= 0) {
					result += amounts[s_n][carry][s_remainder];
				}
			}
		}
		System.out.println(result);
	}

	static int calcDigitSum(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}
