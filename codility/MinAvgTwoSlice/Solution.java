package MinAvgTwoSlice;

// https://codility.com/demo/results/demoUYU35Z-NBG/

public class Solution {
	public int solution(int[] A) {
		if (A.length == 2) {
			return 0;
		}
		int startIndex2 = computeStartIndex(A, 2);
		int startIndex3 = computeStartIndex(A, 3);
		int diff = sum(A, startIndex2, 2) * 3 - sum(A, startIndex3, 3) * 2;
		if (diff < 0) {
			return startIndex2;
		} else if (diff > 0) {
			return startIndex3;
		} else {
			return Math.min(startIndex2, startIndex3);
		}
	}

	int computeStartIndex(int[] A, int length) {
		int startIndex = 0;
		for (int i = 1; i <= A.length - length; i++) {
			if (sum(A, i, length) < sum(A, startIndex, length)) {
				startIndex = i;
			}
		}
		return startIndex;
	}

	int sum(int[] A, int start, int length) {
		int result = 0;
		for (int i = start; i < start + length; i++) {
			result += A[i];
		}
		return result;
	}
}
