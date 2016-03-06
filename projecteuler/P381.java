import java.util.ArrayList;
import java.util.Arrays;

public class P381 {
	public static void main(String args[]) {
		final int LIMIT = 100000000;
		long sum = 0;
		ArrayList<Integer> primes = sievePrimes(LIMIT);
		for (int p : primes) {
			if (p < 5) {
				continue;
			}
			sum += S(p);
		}
		System.out.println(sum);
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrimes[] = new boolean[limit];
		Arrays.fill(isPrimes, true);
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);
				for (int j = i + i; j < isPrimes.length; j += i) {
					isPrimes[j] = false;
				}
			}
		}
		return primes;
	}

	static int S(int p) {
		int result = p - 1;
		for (int i = p - 1; i >= p - 4; i--) {
			result = divideMod(result, i, p);
		}
		result = multiplyMod(result, 9, p);
		return result;
	}

	static int multiplyMod(int a, int b, int mod) {
		return (int) ((long) a * b % mod);
	}

	static int divideMod(int a, int b, int mod) {
		return multiplyMod(a, inverseMod(b, mod), mod);
	}

	static int inverseMod(int a, int mod) {
		Solution s = extendEuclid(mod, a);
		return (s.y % mod + mod) % mod;
	}

	static Solution extendEuclid(int a, int b) {
		if (b == 0) {
			return new Solution(1, 0);
		} else {
			Solution s = extendEuclid(b, a % b);
			return new Solution(s.y, s.x - a / b * s.y);
		}
	}
}

class Solution {
	int x;
	int y;

	Solution(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
}
