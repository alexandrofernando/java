package NailingPlanks;

// https://codility.com/demo/results/demo5E2ZCZ-5VS/

import java.util.Arrays;

public class Solution {
	public int solution(int[] A, int[] B, int[] C) {
		int result = -1;
		int lower = 1;
		int upper = C.length;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;
			if (check(A, B, Arrays.copyOfRange(C, 0, middle), C.length * 2)) {
				result = middle;
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}
		return result;
	}

	boolean check(int[] A, int[] B, int[] nails, int limit) {
		Arrays.sort(nails);
		int[] rightNails = new int[limit + 1];
		for (int i = 0; i <= nails[0]; i++) {
			rightNails[i] = nails[0];
		}
		for (int i = 0; i < nails.length - 1; i++) {
			for (int j = nails[i] + 1; j <= nails[i + 1]; j++) {
				rightNails[j] = nails[i + 1];
			}
		}
		for (int i = nails[nails.length - 1] + 1; i < rightNails.length; i++) {
			rightNails[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < A.length; i++) {
			if (B[i] < rightNails[A[i]]) {
				return false;
			}
		}
		return true;
	}
}
