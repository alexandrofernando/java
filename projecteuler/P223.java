import java.util.ArrayList;
import java.util.Arrays;

public class P223 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static int answer = 0;

	public static void main(String args[]) {
		final int PRIME_LIMIT = 5000;
		final int LIMIT = 25000000;
		sievePrimes(PRIME_LIMIT);
		@SuppressWarnings("unchecked")
		ArrayList<Factor> factors[] = new ArrayList[3];
		for (int i = 0; i < factors.length; i++) {
			factors[i] = factorize(i + 1);
		}
		int factorIndex = 1;
		for (int perimeter = 2; perimeter <= LIMIT; perimeter++) {
			if (perimeter % 2 == 1) {
				ArrayList<Factor> product = multiply(
						factors[(factorIndex + 2) % 3],
						factors[(factorIndex + 1) % 3]);
				divideBy2(product);
				long number = valueOf(product);
				for (int i = 0; i < product.size(); i++) {
					search(i, 1, number, perimeter, product);
				}
			}
			factors[(factorIndex + 2) % 3] = factorize(perimeter + 2);
			factorIndex++;
		}
		System.out.println(answer);
	}

	static boolean isTriangle(long a, long b, long c) {
		return a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && c + a > b;
	}

	static void search(int index, long d1, long d2, int perimeter,
			ArrayList<Factor> total) {
		if (index == total.size()) {
			return;
		}
		int prime = total.get(index).prime;
		long nextD1 = d1;
		long nextD2 = d2;
		for (int i = 0; i < total.get(index).power; i++) {
			nextD1 *= prime;
			nextD2 /= prime;
			if (nextD1 > nextD2) {
				break;
			}
			if (isTriangle(perimeter - nextD1, perimeter - nextD2, nextD1
					+ nextD2 - perimeter)) {
				answer++;
			}
			for (int j = index + 1; j < total.size(); j++) {
				search(j, nextD1, nextD2, perimeter, total);
			}
		}
	}

	static long valueOf(ArrayList<Factor> factors) {
		long number = 1;
		for (Factor factor : factors) {
			for (int i = 0; i < factor.power; i++) {
				number *= factor.prime;
			}
		}
		return number;
	}

	static void divideBy2(ArrayList<Factor> factors) {
		int pos = 0;
		while (factors.get(pos).prime != 2) {
			pos++;
		}
		Factor factor = factors.remove(pos);
		if (factor.power > 1) {
			factors.add(pos, new Factor(2, factor.power - 1));
		}
	}

	static ArrayList<Factor> multiply(ArrayList<Factor> a, ArrayList<Factor> b) {
		ArrayList<Factor> c = new ArrayList<Factor>();
		int indexA = 0;
		int indexB = 0;
		while (indexA < a.size() || indexB < b.size()) {
			if (indexA == a.size()) {
				c.add(b.get(indexB));
				indexB++;
			} else if (indexB == b.size()) {
				c.add(a.get(indexA));
				indexA++;
			} else if (a.get(indexA).prime == b.get(indexB).prime) {
				c.add(new Factor(a.get(indexA).prime, a.get(indexA).power
						+ b.get(indexB).power));
				indexA++;
				indexB++;
			} else if (a.get(indexA).prime < b.get(indexB).prime) {
				c.add(a.get(indexA));
				indexA++;
			} else {
				c.add(b.get(indexB));
				indexB++;
			}
		}
		return c;
	}

	static void sievePrimes(int limit) {
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

	static ArrayList<Factor> factorize(int number) {
		ArrayList<Factor> factors = new ArrayList<Factor>();
		for (int prime : primes) {
			if (prime * prime > number) {
				break;
			}
			if (number % prime == 0) {
				int power = 0;
				do {
					number /= prime;
					power++;
				} while (number % prime == 0);
				factors.add(new Factor(prime, power));
			}
		}
		if (number > 1) {
			factors.add(new Factor(number, 1));
		}
		return factors;
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