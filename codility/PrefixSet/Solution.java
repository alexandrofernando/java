package PrefixSet;

// Alpha 2010
// http://codility.com/demo/results/demoBN8B7N-P8D/

public class Solution {
	public int solution(int[] A) {
		boolean[] appears = new boolean[A.length];
		int firstCoverPrefix = -1;
		for (int i = 0; i < A.length; i++) {
			if (!appears[A[i]]) {
				firstCoverPrefix = i;
				appears[A[i]] = true;
			}
		}
		return firstCoverPrefix;
	}
}
