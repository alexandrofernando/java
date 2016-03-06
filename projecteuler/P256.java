import java.util.ArrayList;

public class P256 {
	/*
	 * http://oeis.org/A068920/a068920.txt
	 */
	static final int TARGET_T = 200;
	static int restPossible;
	static int restTarget;

	public static void main(String args[]) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int s = 2;; s++) {
			ArrayList<Factor> factors = factorize(s, primes);
			if (s % 2 == 0) {
				int possibleMaxT = calcPossibleMaxT(factors);
				if (check(s, factors, possibleMaxT)) {
					System.out.println(s);
					break;
				}
			}
		}
	}

	static boolean check(int number, ArrayList<Factor> factors, int possibleMaxT) {
		restPossible = possibleMaxT;
		restTarget = TARGET_T;
		if (!necessaryContinue()) {
			return false;
		}
		search(number, factors, 0, 1);
		return restPossible == 0 && restTarget == 0;
	}

	static void search(int number, ArrayList<Factor> factors, int index, int a) {
		int b = number / a;
		if (a > b) {
			return;
		}
		restPossible--;
		if (!canCover(a, b)) {
			restTarget--;
		}
		for (int i = index; i < factors.size(); i++) {
			Factor factor = factors.get(i);
			int nextA = a;
			for (int j = 0; j < factor.power; j++) {
				nextA *= factor.prime;
				search(number, factors, i + 1, nextA);
				if (!necessaryContinue()) {
					return;
				}
			}
		}
	}

	static boolean canCover(int a, int b) {
		if (a == 1) {
			return b % 2 == 0;
		} else if (a == 2) {
			return true;
		} else if (a % 2 == 1) {
			return canComposite(b, a - 1, a + 1);
		} else {
			return b == 1 || b == a - 2 || b == a
					|| canComposite(b, a - 1, a + 1)
					|| canComposite(b - 1, a - 1, a + 1)
					|| canComposite(b - a + 2, a - 1, a + 1)
					|| canComposite(b - a, a - 1, a + 1);
		}
	}

	// ax + by = sum
	static boolean canComposite(int sum, int a, int b) {
		boolean remainderA[] = new boolean[a];
		while (sum >= 0) {
			int rem = sum % a;
			if (rem == 0) {
				return true;
			} else if (remainderA[rem]) {
				return false;
			}
			remainderA[rem] = true;
			sum -= b;
		}
		return false;
	}

	static boolean necessaryContinue() {
		return restPossible >= restTarget && restTarget >= 0;
	}

	static int calcPossibleMaxT(ArrayList<Factor> factors) {
		int divisorNum = 1;
		for (Factor factor : factors) {
			divisorNum *= factor.power + 1;
		}
		if (divisorNum % 2 == 0) {
			return divisorNum / 2;
		} else {
			return (divisorNum + 1) / 2;
		}
	}

	static ArrayList<Factor> factorize(int number, ArrayList<Integer> primes) {
		ArrayList<Factor> factors = new ArrayList<Factor>();
		for (int prime : primes) {
			if (prime * prime > number) {
				break;
			}
			int power = 0;
			while (number % prime == 0) {
				number /= prime;
				power++;
			}
			if (power > 0) {
				factors.add(new Factor(prime, power));
			}
		}
		if (number > 1) {
			factors.add(new Factor(number, 1));
			if (primes.isEmpty() || number > primes.get(primes.size() - 1)) {
				primes.add(number);
			}
		}
		return factors;
	}
}

class Factor {
	int prime;
	int power;

	public Factor(int prime, int power) {
		this.prime = prime;
		this.power = power;
	}
}
