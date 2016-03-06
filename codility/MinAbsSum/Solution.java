package MinAbsSum;

// Delta 2011
// http://codility.com/demo/results/demoCXPAHX-8XM/

public class Solution {
	public int solution(int[] A) {
		int max = 0;
		int total = 0;
		for (int i = 0; i < A.length; i++) {
			A[i] = Math.abs(A[i]);
			max = Math.max(max, A[i]);
			total += A[i];
		}
		int[] counts = new int[max + 1];
		for (int number : A) {
			counts[number]++;
		}
		boolean[] reaches = new boolean[total / 2 + 1];
		reaches[0] = true;
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] > 0) {
				int[] remains = new int[reaches.length];
				for (int j = 0; j < remains.length; j++) {
					if (reaches[j]) {
						remains[j] = counts[i];
					} else {
						remains[j] = -1;
					}
				}
				for (int j = 0; j < remains.length; j++) {
					if (remains[j] > 0 && j + i < remains.length) {
						remains[j + i] = Math.max(remains[j + i],
								remains[j] - 1);
					}
				}
				for (int j = 0; j < remains.length; j++) {
					if (remains[j] >= 0) {
						reaches[j] = true;
					}
				}
			}
		}
		for (int i = reaches.length - 1;; i--) {
			if (reaches[i]) {
				return total - i - i;
			}
		}
	}
}
