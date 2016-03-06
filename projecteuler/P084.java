public class P084 {
	// Algorithm - Markov Stochastic Process

	static String board[] = new String[] { "GO", "A1", "CC1", "A2", "T1", "R1",
			"B1", "CH1", "B2", "B3", "JAIL", "C1", "U1", "C2", "C3", "R2",
			"D1", "CC2", "D2", "D3", "FP", "E1", "CH2", "E2", "E3", "R3", "F1",
			"F2", "U2", "F3", "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3",
			"H1", "T2", "H2" };
	static double T[][];
	static final int DICE_SIDE = 4;

	public static void main(String args[]) {
		T = new double[120][120]; // 1-step stochastic state transition matrix
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 3; j++) {
				for (int dice1 = 1; dice1 <= DICE_SIDE; dice1++) {
					for (int dice2 = 1; dice2 <= DICE_SIDE; dice2++) {
						move(i, j, dice1 + dice2, dice1 == dice2,
								1.0 / (DICE_SIDE * DICE_SIDE));
					}
				}
			}
		}
		double p[] = new double[120];
		p[0] = 1;
		double prevP[];
		do {
			prevP = p;
			p = multiply(prevP, T);
		} while (!errorWithin(p, prevP, 1E-9));
		double sumP[] = new double[40];
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 3; j++) {
				sumP[i] += p[i * 3 + j];
			}
		}
		int max1 = -1;
		int max2 = -1;
		int max3 = -1;
		for (int i = 0; i < 40; i++) {
			if (max1 == -1 || sumP[i] > sumP[max1]) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if (max2 == -1 || sumP[i] > sumP[max2]) {
				max3 = max2;
				max2 = i;
			} else if (max3 == -1 || sumP[i] > sumP[max3]) {
				max3 = i;
			}
		}
		System.out.printf("%02d%02d%02d", max1, max2, max3);
	}

	static void move(int from, int doubleNumber, int step, boolean isDouble,
			double p) {
		if (doubleNumber == 2 && isDouble) {
			T[from * 3 + doubleNumber][10 * 3] += p;
			return;
		}
		int nextDoubleNumber = isDouble ? doubleNumber + 1 : 0;
		int to = (from + step) % 40;
		if (board[to].equals("G2J")) {
			T[from * 3 + doubleNumber][10 * 3 + nextDoubleNumber] += p;
		} else if (board[to].startsWith("CC")) {
			T[from * 3 + doubleNumber][to * 3 + nextDoubleNumber] += p
					* (14.0 / 16);
			T[from * 3 + doubleNumber][0 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][10 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
		} else if (board[to].startsWith("CH")) {
			T[from * 3 + doubleNumber][to * 3 + nextDoubleNumber] += p
					* (6.0 / 16);
			T[from * 3 + doubleNumber][0 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][10 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][11 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][24 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][39 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][5 * 3 + nextDoubleNumber] += p
					* (1.0 / 16);
			T[from * 3 + doubleNumber][searchNext(to, "R") * 3
					+ nextDoubleNumber] += p * (1.0 / 16) * 2;
			T[from * 3 + doubleNumber][searchNext(to, "U") * 3
					+ nextDoubleNumber] += p * (1.0 / 16);
			move(from, doubleNumber, step - 3, isDouble, p * (1.0 / 16));
		} else {
			T[from * 3 + doubleNumber][to * 3 + nextDoubleNumber] += p;
		}
	}

	static int searchNext(int pos, String target) {
		while (!board[pos].startsWith(target)) {
			pos = (pos + 1) % board.length;
		}
		return pos;
	}

	static double[] multiply(double a[], double matrix[][]) {
		int size = a.length;
		double b[] = new double[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				b[i] += a[j] * matrix[j][i];
			}
		}
		return b;
	}

	static boolean errorWithin(double a[], double b[], double threshold) {
		for (int i = 0; i < a.length; i++) {
			if (Math.abs(a[i] - b[i]) >= threshold) {
				return false;
			}
		}
		return true;
	}
}
