import java.util.ArrayList;
import java.util.Arrays;

public class P251 {
	static final int LIMIT = 110000000;
	static ArrayList<Integer> primes;
	static ArrayList<Factor> f_bb;
	static int a;
	static int count = 0;

	public static void main(String args[]) {
		sievePrimes((int) Math.ceil(Math.sqrt(8 * LIMIT - 1)));
		for (a = 2; a < LIMIT; a += 3) {
			ArrayList<Factor> f1 = factorise(a + 1);
			ArrayList<Factor> f2 = factorise(8 * a - 1);
			ArrayList<Factor> fg = multiply(multiply(f1, f1), f2);
			ArrayList<Factor> f_bbc = divide27(fg);
			f_bb = f_bbc;
			ArrayList<Factor> f_c = separateUnique(f_bb);
			long c = longValue(f_c, 1);
			long b = longValue(f_bb, 2);
			if (a + c < LIMIT) {
				search(0, b, c);
			}
		}
		System.out.println(count);
	}

	static void search(int index, long b, long c) {
		if (index == f_bb.size()) {
			if (a + b + c <= LIMIT) {
				if (a < 0 || b < 0 || c < 0) {
					System.out.println(a + ", " + b + ", " + c);
				}
				count++;
			}
			return;
		}
		long nextB = b;
		long nextC = c;
		for (int i = 0; i <= f_bb.get(index).power / 2; i++) {
			if (a + nextC >= LIMIT) {
				return;
			}
			search(index + 1, nextB, nextC);
			int p = f_bb.get(index).prime;
			long pp = (long) p * p;
			if (a + pp >= LIMIT) {
				return;
			}
			nextB /= p;
			nextC *= pp;
		}
	}

	static long longValue(ArrayList<Factor> factors, int d) {
		long value = 1;
		for (Factor factor : factors) {
			for (int i = 0; i < factor.power / d; i++) {
				value *= factor.prime;
			}
		}
		return value;
	}

	static ArrayList<Factor> separateUnique(ArrayList<Factor> a) {
		ArrayList<Factor> b = new ArrayList<Factor>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).power % 2 == 1) {
				b.add(new Factor(a.get(i).prime, 1));
				if (a.get(i).power == 1) {
					a.remove(i);
					i--;
				} else {
					a.get(i).power--;
				}
			}
		}
		return b;
	}

	static ArrayList<Factor> divide27(ArrayList<Factor> a) {
		ArrayList<Factor> b = new ArrayList<Factor>(a);
		for (int i = 0; i < b.size(); i++) {
			if (b.get(i).prime == 3) {
				if (b.get(i).power == 3) {
					b.remove(i);
				} else {
					b.get(i).power -= 3;
				}
				break;
			}
		}
		return b;
	}

	static ArrayList<Factor> multiply(ArrayList<Factor> a, ArrayList<Factor> b) {
		ArrayList<Factor> c = new ArrayList<Factor>();
		int indexA = 0;
		int indexB = 0;
		while (indexA < a.size() || indexB < b.size()) {
			if (indexA < a.size() && indexB < b.size()
					&& a.get(indexA).prime == b.get(indexB).prime) {
				c.add(new Factor(a.get(indexA).prime, a.get(indexA).power
						+ b.get(indexB).power));
				indexA++;
				indexB++;
			} else if (indexA < a.size()
					&& (indexB < b.size() || a.get(indexA).prime < b
							.get(indexB).prime)) {
				c.add(a.get(indexA));
				indexA++;
			} else {
				c.add(b.get(indexB));
				indexB++;
			}
		}
		return c;
	}

	static ArrayList<Factor> factorise(int number) {
		ArrayList<Factor> factors = new ArrayList<Factor>();
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (prime * prime > number) {
				break;
			}
			if (number % prime == 0) {
				int count = 0;
				do {
					count++;
					number /= prime;
				} while (number % prime == 0);
				factors.add(new Factor(prime, count));
			}
		}
		if (number > 1) {
			factors.add(new Factor(number, 1));
		}
		return factors;
	}

	static void sievePrimes(int limit) {
		primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit + 1];
		Arrays.fill(isPrimes, true);
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (int j = i + i; j < isPrimes.length; j += i) {
					isPrimes[j] = false;
				}
			}
		}
	}
}

class Factor {
	int prime;
	int power;

	Factor(int thePrime, int thePower) {
		this.prime = thePrime;
		this.power = thePower;
	}
}