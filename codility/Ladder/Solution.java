package Ladder;

// https://codility.com/demo/results/demoNTGGRF-S5S/

public class Solution {
	public int[] solution(int[] A, int[] B) {
		final int MODULO = 1 << 30;
		int[] ways = new int[A.length + 1];
		for (int i = 0; i < ways.length; i++) {
			if (i <= 2) {
				ways[i] = i;
			} else {
				ways[i] = (ways[i - 2] + ways[i - 1]) % MODULO;
			}
		}

		int[] result = new int[A.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = ways[A[i]] % (1 << B[i]);
		}
		return result;
	}
}
