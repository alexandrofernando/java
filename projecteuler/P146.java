// VM arguments: -Xms32m -Xmx800m

import java.util.ArrayList;

public class P146 {
	public static void main(String args[]) {
		final int LIMIT = 150000000;
		boolean composites[] = new boolean[LIMIT + 1];
		boolean targetComposites[] = new boolean[] { false, false, true, false,
				false, true, false, true, true, true, true, true, true, false };
		boolean impossibleN[] = new boolean[LIMIT + 1];
		ArrayList<Integer> oddPrimes = new ArrayList<Integer>();
		for (int i = 2; i < composites.length; i++) {
			if (composites[i]) {
				continue;
			}
			for (int j = i + i; j < composites.length; j += i) {
				composites[j] = true;
			}
		}
		for (int i = 3; i < composites.length; i += 2) {
			if (!composites[i]) {
				oddPrimes.add(i);
			}
		}
		for (int i = 0; i < targetComposites.length; i++) {
			System.out.println("i=" + i);
			boolean compositeN[] = new boolean[LIMIT + 1];
			for (int j = 0; j < oddPrimes.size(); j++) {
				int p = oddPrimes.get(j);
				int n = (p - (i * 2 + 1) % p) % p;
				if (n == 0) {
					sieve(compositeN, p, 0, i * 2 + 1);
				} else if (jacobi(n, p) == 1) {
					int R = Tonelli_Shanks(p, n);
					sieve(compositeN, p, R, i * 2 + 1);
					sieve(compositeN, p, p - R, i * 2 + 1);
				}
			}
			for (int j = 0; j < impossibleN.length; j++) {
				if (compositeN[j] != targetComposites[i]) {
					impossibleN[j] = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < impossibleN.length; i++) {
			if (i % 2 == 1) {
				continue;
			}
			if (!impossibleN[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
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

	static void sieve(boolean compositeN[], int p, int r, int m) {
		for (int i = r; i < compositeN.length; i += p) {
			compositeN[i] = true;
		}
		int n = (int) Math.round(Math.sqrt(p - m));
		if (n * n + m == p) {
			compositeN[n] = false;
		}
	}
}
