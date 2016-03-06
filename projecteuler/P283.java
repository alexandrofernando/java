import java.util.ArrayList;
import java.util.Arrays;

// http://www.andrewewhite.net/wordpress/2010/05/07/finding-integer-triangles-ratios/

public class P283 {
	static ArrayList<Integer> primes;

	public static void main(String args[]) {
		final int LIMIT = 1000;
		primes = sievePrimes(16 * LIMIT * LIMIT);
		ArrayList<Triangle> triangles = new ArrayList<Triangle>();
		for (int i = 1; i <= LIMIT; i++) {
			findTriangles(i, triangles);
		}
		long result = 0;
		for (Triangle triangle : triangles) {
			result += triangle.a + triangle.b + triangle.c;
		}
		System.out.println(result);
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit + 1];
		Arrays.fill(isPrimes, true);
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (long j = (long) i * i; j < isPrimes.length; j += i) {
					isPrimes[(int) j] = false;
				}
			}
		}
		return primes;
	}

	static void findTriangles(int r, ArrayList<Triangle> triangles) {
		ArrayList<Factor> factors_r = factorize(r);
		ArrayList<Factor> factors_2 = factorize(2);
		ArrayList<Factor> factors_2r = merge(factors_r, factors_2);
		for (long u : getDivisors(factors_2r)) {
			for (long v = 1; v * v <= 3 * u * u; v++) {
				if (gcd(u, v) != 1) {
					continue;
				}
				ArrayList<Factor> factors_4rr = merge(factors_2r, factors_2r);
				ArrayList<Factor> factors_uu_vv = factorize((int) (u * u + v
						* v));
				ArrayList<Factor> factors_lhs = merge(factors_4rr,
						factors_uu_vv);
				long lhs = 4 * r * r * (u * u + v * v);
				for (long d1 : getDivisors(factors_lhs)) {
					long d2 = lhs / d1;
					if (d1 > d2) {
						continue;
					}
					if (u < v && 2 * r * (v * v - u * u) > d1 * u) {
						continue;
					}
					if ((d1 + 2 * r * u) % v == 0 && (d2 + 2 * r * u) % v == 0) {
						long a = (d1 + 2 * r * u) / v + 2 * r * v / u;
						long b = (d2 + 2 * r * u) / v + 2 * r * v / u;
						long c = (d1 + d2 + 4 * r * u) / v;
						triangles.add(new Triangle(a, b, c));
					}
				}
			}
		}
	}

	static long gcd(long a, long b) {
		if (a < b) {
			return gcd(b, a);
		}
		while (b != 0) {
			long c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	static ArrayList<Factor> factorize(int number) {
		ArrayList<Factor> factors = new ArrayList<Factor>();
		for (int prime : primes) {
			if (prime * prime > number) {
				break;
			}
			int exponent = 0;
			while (number % prime == 0) {
				number /= prime;
				exponent++;
			}
			if (exponent > 0) {
				factors.add(new Factor(prime, exponent));
			}
		}
		if (number > 1) {
			factors.add(new Factor(number, 1));
		}
		return factors;
	}

	static ArrayList<Factor> merge(ArrayList<Factor> factors1,
			ArrayList<Factor> factors2) {
		ArrayList<Factor> merged = new ArrayList<Factor>();
		int index1 = 0;
		int index2 = 0;
		while (index1 < factors1.size() || index2 < factors2.size()) {
			if (index1 < factors1.size()) {
				Factor f1 = factors1.get(index1);
				if (index2 == factors2.size()
						|| f1.prime < factors2.get(index2).prime) {
					merged.add(f1);
					index1++;
				} else {
					Factor f2 = factors2.get(index2);
					if (f1.prime > f2.prime) {
						merged.add(f2);
						index2++;
					} else {
						merged.add(new Factor(f1.prime, f1.exponent
								+ f2.exponent));
						index1++;
						index2++;
					}
				}
			} else {
				merged.add(factors2.get(index2));
				index2++;
			}
		}
		return merged;
	}

	static ArrayList<Long> getDivisors(ArrayList<Factor> factors) {
		ArrayList<Long> divisors = new ArrayList<Long>();
		searchDivisors(0, 1, divisors, factors);
		return divisors;
	}

	static void searchDivisors(int index, long divisor,
			ArrayList<Long> divisors, ArrayList<Factor> factors) {
		if (index == factors.size()) {
			divisors.add(divisor);
			return;
		}
		Factor f = factors.get(index);
		long power = 1;
		for (int i = 0; i <= f.exponent; i++) {
			searchDivisors(index + 1, divisor * power, divisors, factors);
			power *= f.prime;
		}
	}
}

class Triangle {
	long a;
	long b;
	long c;

	Triangle(long a, long b, long c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

class Factor {
	int prime;
	int exponent;

	Factor(int prime, int exponent) {
		this.prime = prime;
		this.exponent = exponent;
	}
}