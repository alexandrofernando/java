package AbsDistinct;

// http://codility.com/demo/results/demoHXKNQX-B4A/

public class Solution {
	public int solution(int[] A) {
		int nonNegIndex = 0;
		while (nonNegIndex < A.length && A[nonNegIndex] < 0) {
			nonNegIndex++;
		}
		int negIndex = nonNegIndex - 1;
		int count = 0;
		int prevAbsolute = -1;
		while (negIndex >= 0 || nonNegIndex < A.length) {
			int absolute;
			if (nonNegIndex >= A.length
					|| (negIndex >= 0 && -A[negIndex] < A[nonNegIndex])) {
				absolute = -A[negIndex];
				negIndex--;
			} else {
				absolute = A[nonNegIndex];
				nonNegIndex++;
			}
			if (absolute != prevAbsolute) {
				prevAbsolute = absolute;
				count++;
			}
		}
		return count;
	}
}
