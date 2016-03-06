public class P101 {
	public static void main(String args[]) {
		final int DEGREE = 10;
		long u[] = new long[DEGREE + 1];
		for (int i = 1; i < u.length; i++) {
			u[i] = U(i);
		}
		long sum = 0;
		for (int i = 1; i < u.length; i++) {
			sum += OP(i, u, i + 1);
		}
		System.out.println(sum);
	}

	static long OP(int interpolationNum, long y[], long x) {
		long result = 0;
		for (int i = 1; i <= interpolationNum; i++) {
			result += y[i] * L(interpolationNum, i, y, x);
		}
		return result;
	}

	static long L(int interpolationNum, int index, long y[], long x) {
		long result = 1;
		for (int i = 1; i <= interpolationNum; i++) {
			if (i != index) {
				result *= x - i;
			}
		}
		for (int i = 1; i <= interpolationNum; i++) {
			if (i != index) {
				result /= index - i;
			}
		}
		return result;
	}

	static long U(long n) {
		return 1
				+ n
				* (-1 + n
						* (1 + n
								* (-1 + n
										* (1 + n
												* (-1 + n
														* (1 + n
																* (-1 + n
																		* (1 + n
																				* (-1 + n)))))))));
	}
}
