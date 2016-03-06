package FloodedIsland;

// Nitrogenium 2013
// http://codility.com/cert/view/certW7PM7W-XBDT7AFBEWVZ77K2

import java.util.ArrayList;

public class Solution {
	@SuppressWarnings("unchecked")
	public int[] solution(int[] A, int[] B) {
		int maxB = getMax(B);
		ArrayList<Integer>[] indices = new ArrayList[maxB + 1];
		for (int i = 0; i < indices.length; i++) {
			indices[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= maxB) {
				indices[A[i]].add(i);
			}
		}

		boolean[] underWaters = new boolean[A.length];
		int[] islandNums = new int[maxB + 1];
		int currentIslandNum = 1;
		for (int i = 0; i < islandNums.length; i++) {
			for (int index : indices[i]) {
				int delta = -1;
				if (index > 0 && !underWaters[index - 1]) {
					delta++;
				}
				if (index < A.length - 1 && !underWaters[index + 1]) {
					delta++;
				}
				currentIslandNum += delta;
				underWaters[index] = true;
			}
			islandNums[i] = currentIslandNum;
		}

		int[] results = new int[B.length];
		for (int i = 0; i < results.length; i++) {
			results[i] = islandNums[B[i]];
		}

		return results;
	}

	int getMax(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int num : a) {
			max = Math.max(max, num);
		}
		return max;
	}
}
