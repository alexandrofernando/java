public class P282 {
	static final int MODULO = (int) Math.round(Math.pow(14, 8));

	public static void main(String args[]) {
		int result = 0;
		for (int n = 0; n <= 6; n++) {
			result = addMod(result, r(n));
		}
		System.out.println(result);
	}

	static int addMod(int a, int b) {
		return (int) (((long) a % MODULO + b % MODULO + MODULO) % MODULO);
	}

	static int ackermann(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (n == 0) {
			return ackermann(m - 1, 1);
		} else {
			return ackermann(m - 1, ackermann(m, n - 1));
		}
	}

	static int r(int n) {
		if (n <= 3) {
			return ackermann(n, n);
		} else if (n == 4) {
			return addMod(tetrationOf2AndMod(7, MODULO), -3);
		} else {
			return addMod(tetrationOf2AndMod(10, MODULO), -3);
		}
	}

	static int tetrationOf2AndMod(int n, int M) {
		if (n <= 4) {
			int tetrations[] = { 1, 2, 4, 16, 65536 };
			return tetrations[n] % M;
		} else {
			int m = M;
			while (m % 2 == 0) {
				m /= 2;
			}
			int yn;
			if (m == 1) {
				yn = 0;
			} else {
				yn = powerOf2AndMod(tetrationOf2AndMod(n - 1, totient(m)), m);
			}
			for (int Yn = 0; Yn <= M - 1; Yn++) {
				if (Yn % m == yn && Yn % (M / m) == 0) {
					return Yn;
				}
			}
			return -1;
		}
	}

	static int powerOf2AndMod(int n, int M) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = (int) (2L * result % M);
		}
		return result;
	}

	static int totient(int n) {
		int phi = n;
		for (int p = 2; p * p <= n; p++) {
			if (isPrime(p) && n % p == 0) {
				phi = (int) ((long) phi * (p - 1) / p);
				while (n % p == 0) {
					n /= p;
				}
			}
		}
		if (n > 1) {
			phi = (int) ((long) phi * (n - 1) / n);
		}
		return phi;
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
