package MaxDoubleSliceSum;

// http://codility.com/demo/results/demoB3K7BW-GGA/

public class Solution {
	public int solution(int[] A) {
		int[] maxLeftSums = new int[A.length];
		int sum = 0;
		for (int i = 1; i < A.length; i++) {
			sum += A[i];
			if (sum < 0) {
				sum = 0;
			}
			maxLeftSums[i] = sum;
		}

		int[] maxRightSums = new int[A.length];
		sum = 0;
		for (int i = A.length - 2; i >= 0; i--) {
			sum += A[i];
			if (sum < 0) {
				sum = 0;
			}
			maxRightSums[i] = sum;
		}

		int maxSum = 0;
		for (int i = 1; i + 1 < A.length; i++) {
			maxSum = Math.max(maxSum, maxLeftSums[i - 1] + maxRightSums[i + 1]);
		}
		return maxSum;
	}
}
