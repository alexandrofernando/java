package Triangle;

// http://codility.com/demo/results/demoAUR8JJ-3PN/

import java.util.Arrays;

public class Solution {
	public int solution(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i + 2 < A.length; i++) {
			if ((long) A[i] + A[i + 1] > A[i + 2]) {
				return 1;
			}
		}
		return 0;
	}
}
