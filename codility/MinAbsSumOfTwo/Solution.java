package MinAbsSumOfTwo;

// https://codility.com/demo/results/demoQX695S-XP2/

import java.util.Arrays;

public class Solution {
	public int solution(int[] A) {
		int minAbsSum = Integer.MAX_VALUE;
		Arrays.sort(A);
		for (int number : A) {
			int index = Arrays.binarySearch(A, -number);
			if (index >= 0) {
				return 0;
			}
			index = -1 - index;
			if (index > 0) {
				minAbsSum = Math
						.min(minAbsSum, Math.abs(number + A[index - 1]));
			}
			if (index < A.length) {
				minAbsSum = Math.min(minAbsSum, Math.abs(number + A[index]));
			}
		}
		return minAbsSum;
	}
}
