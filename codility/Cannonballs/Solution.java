package Cannonballs;

// Chi 2012
// http://codility.com/demo/results/demoKQ2WXJ-XPG/

import java.util.Arrays;

public class Solution {
	public int[] solution(int[] A, int[] B) {
		int maxCannon = -1;
		for (int cannon : B) {
			maxCannon = Math.max(maxCannon, cannon);
		}

		int[] blockIndices = new int[maxCannon + 1];
		Arrays.fill(blockIndices, Integer.MAX_VALUE);
		int prevGround = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > prevGround) {
				for (int j = prevGround + 1; j <= A[i]
						&& j < blockIndices.length; j++) {
					blockIndices[j] = i;
				}
				prevGround = A[i];
			}
		}

		int[] A1 = Arrays.copyOf(A, A.length);
		for (int cannon : B) {
			int blockIndex = blockIndices[cannon];
			if (blockIndex == 0 || blockIndex == Integer.MAX_VALUE) {
				continue;
			}
			A1[blockIndex - 1]++;
			blockIndices[A1[blockIndex - 1]] = Math.min(
					blockIndices[A1[blockIndex - 1]], blockIndex - 1);
		}

		return A1;
	}
}
