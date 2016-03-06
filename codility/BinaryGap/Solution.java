package BinaryGap;

// http://codility.com/demo/results/demo97RKDX-ZTW/

public class Solution {
	public int solution(int N) {
		int maxGap = 0;
		int gap = -1;
		while (N != 0) {
			int digit = N % 2;
			if (digit == 1) {
				gap = 0;
			} else if (gap >= 0) {
				gap++;
				maxGap = Math.max(maxGap, gap);
			}
			N /= 2;
		}
		return maxGap;
	}
}
