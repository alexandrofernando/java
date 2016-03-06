import java.util.ArrayList;

public class P294 {
	static final int DIGIT_SUM_SIZE = 24;
	static final int MOD_SIZE = 23;
	static final int MODULO = 1000000000;

	public static void main(String args[]) {
		final long N = (long) Math.pow(11, 12);
		long amounts[] = new long[DIGIT_SUM_SIZE * MOD_SIZE];
		amounts[getDim1Index(0, 0)] = 1;
		int base = 1;
		long cycleTransfer[][] = buildEntityTransferMatrix();
		ArrayList<long[][]> transfers = new ArrayList<long[][]>();
		do {
			long transfer[][] = buildTransferMatrix(base);
			transfers.add(transfer);
			cycleTransfer = multiply(cycleTransfer, transfer);
			base = base * 10 % 23;
		} while (base != 1);
		long whole = N / transfers.size();
		long remainder = N % transfers.size();
		amounts = multiply(amounts, pow(cycleTransfer, whole));
		for (int i = 0; i < remainder; i++) {
			amounts = multiply(amounts, transfers.get(i));
		}
		System.out.println(amounts[getDim1Index(23, 0)]);
	}

	static long[][] pow(long a[][], long exponent) {
		long result[][] = buildEntityTransferMatrix();
		long base[][] = a.clone();
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = multiply(result, base);
			}
			base = multiply(base, base);
			exponent /= 2;
		}
		return result;
	}

	static long addMod(long a, long b) {
		return (a + b) % MODULO;
	}

	static long multiplyMod(long a, long b) {
		return a * b % MODULO;
	}

	static long[][] multiply(long a[][], long b[][]) {
		long c[][] = new long[a.length][b[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] = addMod(c[i][j], multiplyMod(a[i][k], b[k][j]));
				}
			}
		}
		return c;
	}

	static long[] multiply(long a[], long b[][]) {
		long c[] = new long[a.length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i] = addMod(c[i], multiplyMod(a[j], b[j][i]));
			}
		}
		return c;
	}

	static int getDim1Index(int r, int c) {
		return r * MOD_SIZE + c;
	}

	static long[][] buildEntityTransferMatrix() {
		long transfer[][] = new long[DIGIT_SUM_SIZE * MOD_SIZE][DIGIT_SUM_SIZE
				* MOD_SIZE];
		for (int i = 0; i < transfer.length; i++) {
			transfer[i][i] = 1;
		}
		return transfer;
	}

	static long[][] buildTransferMatrix(int base) {
		long transfer[][] = new long[DIGIT_SUM_SIZE * MOD_SIZE][DIGIT_SUM_SIZE
				* MOD_SIZE];
		for (int digitSum = 0; digitSum < DIGIT_SUM_SIZE; digitSum++) {
			for (int d = 0; d <= 9; d++) {
				if (digitSum + d > 23) {
					break;
				}
				for (int mod = 0; mod < MOD_SIZE; mod++) {
					transfer[getDim1Index(digitSum, mod)][getDim1Index(digitSum
							+ d, (mod + d * base) % 23)] = 1;
				}
			}
		}
		return transfer;
	}
}
