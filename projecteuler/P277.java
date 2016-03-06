public class P277 {
	public static void main(String args[]) {
		final long LIMIT = 1000000000000000L;
		final String sequence = "UDDDUdddDDUDDddDdDddDDUDDdUUDd";
		long interval = 1;
		long number = 1;
		for (int i = 0; i < sequence.length(); i++) {
			while (true) {
				if (sequence.charAt(i) == step(number, i + 1)) {
					break;
				}
				number += interval;
			}
			interval *= 3;
		}
		System.out.println(((LIMIT - number) / interval + 1) * interval
				+ number);
	}

	static char step(long number, int n) {
		char ret = 0;
		for (int i = 0; i < n; i++) {
			long remainder = number % 3;
			if (remainder == 0) {
				number /= 3;
				ret = 'D';
			} else if (remainder == 1) {
				number = (4 * number + 2) / 3;
				ret = 'U';
			} else {
				number = (2 * number - 1) / 3;
				ret = 'd';
			}
		}
		return ret;
	}
}
