package GenomicRangeQuery;

// http://codility.com/demo/results/demoMUEPD6-EYF/

import java.util.Arrays;

public class Solution {
	public int[] solution(String S, int[] P, int[] Q) {
		int[][] nextIndices = new int[S.length()][5];
		int[] indices = new int[5];
		Arrays.fill(indices, Integer.MAX_VALUE);
		for (int i = S.length() - 1; i >= 0; i--) {
			int value = getValue(S.charAt(i));
			indices[value] = i;
			nextIndices[i] = Arrays.copyOf(indices, indices.length);
		}

		int[] mins = new int[P.length];
		for (int i = 0; i < mins.length; i++) {
			for (int value = 1;; value++) {
				if (nextIndices[P[i]][value] <= Q[i]) {
					mins[i] = value;
					break;
				}
			}
		}
		return mins;
	}

	int getValue(char letter) {
		if (letter == 'A') {
			return 1;
		} else if (letter == 'C') {
			return 2;
		} else if (letter == 'G') {
			return 3;
		} else { // letter == 'T'
			return 4;
		}
	}
}
