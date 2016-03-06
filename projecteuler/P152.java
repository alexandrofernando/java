import java.util.ArrayList;

public class P152 {
	static int LIMIT = 80;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static int bases[] = new int[LIMIT + 1];
	@SuppressWarnings("unchecked")
	static ArrayList<Rational> fractions[] = new ArrayList[LIMIT + 1];
	static int sequences[] = new int[LIMIT - 1];
	static int have[] = new int[LIMIT + 1];
	static int answer = 0;

	public static void main(String args[]) {
		findPrimes();
		buildBases();
		buildFractions();
		sort();

		have[2] = 2; // start with 2 / (2^2) = 1 / 2
		search(0);
		System.out.println(answer);
	}

	static void search(int index) {
		if (index == sequences.length) {
			answer++;
			return;
		}
		int n = sequences[index];
		if (have[n] == 0) {
			search(index + 1);
		}
		if (have[n] != 0 || bases[n] == 0) {
			for (Rational f : fractions[n]) {
				have[f.r1] -= f.r0;
				balanceAt(f.r1);
			}
			if (have[n] == 0) {
				search(index + 1);
			}
			for (Rational f : fractions[n]) {
				have[f.r1] += f.r0;
				balanceAt(f.r1);
			}
		}
	}

	static void balanceAt(int pp) {
		int prime = bases[pp];
		int p2 = prime * prime;
		while (pp > 1) {
			if (have[pp] < p2 && have[pp] > -p2) {
				return;
			}
			int up = pp / prime;
			if (have[pp] >= p2) {
				have[pp] -= p2;
				have[up]++;
			} else if (have[pp] <= -p2) {
				have[pp] += p2;
				have[up]--;
			}
			pp = up;
		}
	}

	static void sort() {
		boolean used[] = new boolean[LIMIT + 1];
		int index = 0;
		while (index < sequences.length) {
			for (int i = LIMIT; i >= 2; i--) {
				if (!used[i] && bases[i] > 0 && locks(i, used) == 0) {
					used[i] = true;
					sequences[index] = i;
					index++;
				}
			}
			for (int i = LIMIT; i >= 2; i--) {
				if (!used[i]) {
					used[i] = true;
					sequences[index] = i;
					index++;
					break;
				}
			}
		}
	}

	static int locks(int n, boolean used[]) {
		int count = 0;
		for (int i = n + n; i <= LIMIT; i += n) {
			if (!used[i]) {
				count++;
			}
		}
		return count;
	}

	static void findPrimes() {
		boolean sieved[] = new boolean[LIMIT + 1];
		for (int i = 2; i < sieved.length; i++) {
			if (!sieved[i]) {
				primes.add(i);
				for (int j = i + i; j < sieved.length; j += i) {
					sieved[j] = true;
				}
			}
		}
	}

	static void buildBases() {
		for (int prime : primes) {
			for (int j = prime; j < bases.length; j *= prime) {
				bases[j] = prime;
			}
		}
	}

	static void buildFractions() {
		for (int i = 2; i < fractions.length; i++) {
			fractions[i] = new ArrayList<Rational>();
			int m = 1;
			int n = i;
			for (int prime : primes) {
				int p2 = prime * prime;
				int pp = 1;
				while (n % prime == 0) {
					pp *= prime;
					n /= prime;
				}
				if (pp > 1) {
					int g[] = extendGCD(n * n, pp * pp);
					g[0] *= m;
					g[1] *= m;
					int k = g[0] / (pp * pp);
					g[0] -= k * pp * pp;
					g[1] += k * n * n;
					while (g[0] != 0) {
						if (g[0] % p2 != 0) {
							fractions[i].add(new Rational(g[0] % p2, pp));
						}
						pp /= prime;
						g[0] /= p2;
					}
					m = g[1];
				}
			}
		}
	}

	static int[] extendGCD(int a, int b) {
		if (b == 0) {
			return new int[] { 1, 0 };
		} else {
			int x[] = extendGCD(b, a % b);
			return new int[] { x[1], x[0] - a / b * x[1] };
		}
	}
}

class Rational { // r = r0 / r1^2
	int r0;
	int r1;

	Rational(int R0, int R1) {
		this.r0 = R0;
		this.r1 = R1;
	}
}
