package Peaks;

// http://codility.com/demo/results/demoK9SVPD-53K/

public class Solution {
	public int solution(int[] A) {
		int[] peakNums = new int[A.length + 1];
		for (int i = 1; i <= A.length; i++) {
			peakNums[i] = peakNums[i - 1]
					+ (i - 2 >= 0 && i < A.length && A[i - 1] > A[i - 2]
							&& A[i - 1] > A[i] ? 1 : 0);
		}
		if (peakNums[A.length] == 0) {
			return 0;
		}
		for (int interval = 1;; interval++) {
			if (A.length % interval == 0) {
				boolean valid = true;
				for (int i = 0; i < A.length; i += interval) {
					int containPeak = peakNums[i + interval] - peakNums[i];
					if (containPeak == 0) {
						valid = false;
						break;
					}
				}
				if (valid) {
					return A.length / interval;
				}
			}
		}
	}
}
