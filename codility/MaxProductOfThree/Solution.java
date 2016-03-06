package MaxProductOfThree;

// http://codility.com/demo/results/demo856VHH-6FM/

import java.util.Arrays;

public class Solution {
	public int solution(int[] A) {
		Arrays.sort(A);
		int maxProduct = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
		if (A[0] < 0) {
			maxProduct = Math.max(maxProduct, A[0] * A[1] * A[A.length - 1]);
		}
		return maxProduct;
	}
}
