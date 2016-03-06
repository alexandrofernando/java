public class P216 {
	public static void main(String args[]) {
		final int LIMIT = 50000000;
		boolean compositeN[] = new boolean[LIMIT + 1];
		boolean composites[] = new boolean[(int) (LIMIT * Math.sqrt(2)) + 1];
		for (int i = 2; i < composites.length; i++) {
			if (composites[i]) {
				continue;
			}
			if (i % 2 == 1 && jacobi((i + 1) / 2, i) == 1) {
				int R = Tonelli_Shanks(i, (i + 1) / 2);
				sieve(compositeN, i, R);
				sieve(compositeN, i, i - R);
			}
			for (int j = i + i; j < composites.length; j += i) {
				composites[j] = true;
			}
		}
		int count = 0;
		for (int i = 2; i < compositeN.length; i++) {
			if (!compositeN[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

	static int pow_mod(int base, int power, int modulo) {
		if (power == 0)
			return 1;
		if (power % 2 == 0)
			return pow_mod((int) ((long) base * base % modulo), power / 2,
					modulo);
		return (int) ((long) base * pow_mod(base, power - 1, modulo) % modulo);
	}

	static int sign(boolean p) {
		return p ? 1 : -1;
	}

	static int jacobi(int a, int n) {
		if (a < 0)
			return sign(n % 4 == 1) * jacobi(-a, n);
		if (a < 2)
			return a;
		if (a % 2 == 0)
			return sign(n % 8 == 1 || n % 8 == 7) * jacobi(a / 2, n);
		return sign(a % 4 == 1 || n % 4 == 1) * jacobi(n % a, a);
	}

	static int Tonelli_Shanks(int p, int n) {
		int S = 0;
		int Q = p - 1;
		while (Q % 2 == 0) {
			S++;
			Q /= 2;
		}
		if (S == 1) {
			return pow_mod(n, (p + 1) / 4, p);
		}
		int z = 1;
		while (jacobi(z, p) != -1) {
			z++;
		}
		int c = pow_mod(z, Q, p);
		int R = pow_mod(n, (Q + 1) / 2, p);
		int t = pow_mod(n, Q, p);
		int M = S;
		while (t != 1) {
			int temp = t;
			for (int i = 1; i < M; i++) {
				temp = pow_mod(temp, 2, p);
				if (temp == 1) {
					int b = c;
					for (int j = 0; j < M - i - 1; j++) {
						b = pow_mod(b, 2, p);
					}
					R = (int) ((long) R * b % p);
					t = (int) ((long) t * b % p * b % p);
					c = pow_mod(b, 2, p);
					M = i;
					break;
				}
			}
		}
		return R;
	}

	static void sieve(boolean compositeN[], int p, int r) {
		for (int i = r; i < compositeN.length; i += p) {
			compositeN[i] = true;
		}
		int n = (int) Math.round(Math.sqrt((p + 1) / 2));
		if (2 * n * n - 1 == p) {
			compositeN[n] = false;
		}
	}
}
