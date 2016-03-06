package CountSemiprimes;

// http://codility.com/demo/results/demoGCGAMW-DAF/

import java.util.ArrayList;

public class Solution {
	public int[] solution(int N, int[] P, int[] Q) {
		boolean[] composites = new boolean[N + 1];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < composites.length; i++) {
			if (!composites[i]) {
				primes.add(i);
				for (long j = (long) i * i; j < composites.length; j += i) {
					composites[(int) j] = true;
				}
			}
		}
		boolean[] semiprimes = new boolean[N + 1];
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i; j < primes.size(); j++) {
				long number = (long) primes.get(i) * primes.get(j);
				if (number >= semiprimes.length) {
					break;
				}
				semiprimes[(int) number] = true;
			}
		}
		int[] semiprimeNums = new int[N + 1];
		for (int i = 1; i < semiprimeNums.length; i++) {
			semiprimeNums[i] = semiprimeNums[i - 1] + (semiprimes[i] ? 1 : 0);
		}
		int[] result = new int[P.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = semiprimeNums[Q[i]] - semiprimeNums[P[i] - 1];
		}
		return result;
	}
}
