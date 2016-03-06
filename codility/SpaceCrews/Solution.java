package SpaceCrews;

// Kappa 2011
// https://codility.com/demo/results/demoQBS5FE-VQP/

public class Solution {
	static final int MODULO = 1410000017;
	static final int LIMIT = 1000000;

	public int solution(int[] T, int[] D) {
		int[] factorials = computeFactorials();

		int result = 1;
		for (int i = 0; i < T.length; i++) {
			result = multiplyMod(result, C(T[i], D[i], factorials));
		}
		return result;
	}

	int[] computeFactorials() {
		int[] factorials = new int[LIMIT + 1];
		int factorial = 1;
		for (int i = 0; i < factorials.length; i++) {
			if (i != 0) {
				factorial = multiplyMod(factorial, i);
			}
			factorials[i] = factorial;
		}
		return factorials;
	}

	int C(int n, int m, int[] factorials) {
		return multiplyMod(
				multiplyMod(factorials[n],
						computeMultiplicativeInverse(factorials[m])),
				computeMultiplicativeInverse(factorials[n - m]));
	}

	int multiplyMod(int a, int b) {
		return (int) ((long) a * b % MODULO);
	}

	int computeMultiplicativeInverse(int number) {
		return (int) (((long) extendedEuclid(number, MODULO).x + MODULO) % MODULO);
	}

	ExtendedEuclidResult extendedEuclid(int a, int b) {
		if (b == 0) {
			return new ExtendedEuclidResult(a, 1, 0);
		}
		ExtendedEuclidResult eer = extendedEuclid(b, a % b);
		return new ExtendedEuclidResult(eer.d, eer.y, eer.x - a / b * eer.y);
	}
}

class ExtendedEuclidResult {
	int d;
	int x;
	int y;

	public ExtendedEuclidResult(int d, int x, int y) {
		this.d = d;
		this.x = x;
		this.y = y;
	}
}