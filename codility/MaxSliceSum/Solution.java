package MaxSliceSum;

// http://codility.com/demo/results/demoU7BQWT-9ZY/

public class Solution {
	public int solution(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int num : A) {
			sum += num;
			maxSum = Math.max(maxSum, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
