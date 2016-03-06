package FibFrog;

// https://codility.com/demo/results/demo5BUDBH-8GG/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int solution(int[] A) {
		ArrayList<Integer> steps = new ArrayList<Integer>();
		steps.add(1);
		steps.add(2);
		while (true) {
			int nextStep = steps.get(steps.size() - 2)
					+ steps.get(steps.size() - 1);
			if (nextStep > A.length + 1) {
				break;
			}
			steps.add(nextStep);
		}

		int[] jumps = new int[A.length + 2];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0] = 0;
		for (int i = 0; i < A.length + 1; i++) {
			if ((i == 0 || A[i - 1] == 1) && jumps[i] != Integer.MAX_VALUE) {
				for (int step : steps) {
					int nextPos = i + step;
					if (nextPos < jumps.length) {
						jumps[nextPos] = Math.min(jumps[nextPos], jumps[i] + 1);
					}
				}
			}
		}

		return jumps[A.length + 1] == Integer.MAX_VALUE ? -1
				: jumps[A.length + 1];
	}
}
