package ArrayInversionCount;

// http://codility.com/demo/results/demoAZJWT4-7QC/

import java.util.ArrayList;

public class Solution {
	public int solution(int[] A) {
		return countInversion(A, 0, A.length - 1);
	}

	int countInversion(int[] A, int begin, int end) {
		if (begin >= end) {
			return 0;
		}
		int middle = (begin + end) / 2;
		int inversionNum = countInversion(A, begin, middle)
				+ countInversion(A, middle + 1, end);
		ArrayList<Integer> merged = new ArrayList<Integer>();
		int index1 = begin;
		int index2 = middle + 1;
		while (index1 != middle + 1 || index2 != end + 1) {
			if (index2 == end + 1
					|| (index1 != middle + 1 && A[index1] <= A[index2])) {
				merged.add(A[index1]);
				index1++;
			} else {
				merged.add(A[index2]);
				index2++;
				inversionNum += middle + 1 - index1;
			}
		}
		for (int i = begin; i <= end; i++) {
			A[i] = merged.get(i - begin);
		}
		return inversionNum;
	}
}
