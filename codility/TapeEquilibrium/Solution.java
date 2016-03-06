package TapeEquilibrium;

// http://codility.com/demo/results/demo32NWEJ-EMG/

public class Solution {
	public int solution(int[] A) {
		int total = 0;
		for (int elem : A) {
			total += elem;
		}
		int minDiff = Integer.MAX_VALUE;
		int leftSum = 0;
		for (int i = 0; i < A.length - 1; i++) {
			leftSum += A[i];
			int rightSum = total - leftSum;
			minDiff = Math.min(minDiff, Math.abs(leftSum - rightSum));
		}
		return minDiff;
	}
}
