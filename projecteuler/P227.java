public class P227 {
	static final int PLAYER_NUM = 100;
	static final int SIGNIFICANT_DIGIT_NUM = 10;
	static final int ITERATOR_NUM = 100000;

	public static void main(String args[]) {
		double transfer[][] = new double[PLAYER_NUM / 2 + 1][PLAYER_NUM / 2 + 1];
		for (int from = 1; from < transfer.length; from++) {
			transfer[from][distance(from + 2)] += 1.0 / 36;
			transfer[from][distance(from + 1)] += 8.0 / 36;
			transfer[from][from] += 18.0 / 36;
			transfer[from][distance(from - 1)] += 8.0 / 36;
			transfer[from][distance(from - 2)] += 1.0 / 36;
		}
		double possible[] = new double[PLAYER_NUM / 2 + 1];
		possible[PLAYER_NUM / 2] = 1;
		double turnE = 0;
		for (int turn = 1; turn <= ITERATOR_NUM; turn++) {
			possible = multiply(possible, transfer);
			double newTurnE = turnE + turn * possible[0];
			turnE = newTurnE;
		}
		System.out.printf("%.6f\n", turnE);
	}

	static double[] multiply(double a[], double b[][]) {
		double c[] = new double[a.length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i] += a[j] * b[j][i];
			}
		}
		return c;
	}

	static int distance(int d) {
		if (d < 0) {
			return -d;
		} else if (d + d > PLAYER_NUM) {
			return PLAYER_NUM - d;
		} else {
			return d;
		}
	}
}
