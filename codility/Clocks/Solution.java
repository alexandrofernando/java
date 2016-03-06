package Clocks;

// http://codility.com/demo/results/demoB5P7M9-8B6/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class Solution {
	public int solution(int[][] A, int P) {
		ArrayList<Integer>[] keys = new ArrayList[A.length];
		HashMap<ArrayList<Integer>, Integer> key2count = new HashMap<ArrayList<Integer>, Integer>();
		for (int i = 0; i < keys.length; i++) {
			keys[i] = computeKey(A[i], P);
			if (!key2count.containsKey(keys[i])) {
				key2count.put(keys[i], 0);
			}
			key2count.put(keys[i], key2count.get(keys[i]) + 1);
		}
		int pairNum = 0;
		for (int count : key2count.values()) {
			pairNum += count * (count - 1) / 2;
		}
		return pairNum;
	}

	ArrayList<Integer> computeKey(int[] hands, int P) {
		Arrays.sort(hands);
		int[] diffs = new int[hands.length];
		for (int i = 0; i < hands.length - 1; i++) {
			diffs[i] = hands[i + 1] - hands[i];
		}
		diffs[diffs.length - 1] = P - hands[hands.length - 1] + hands[0];
		return findMinRotation(diffs);
	}

	ArrayList<Integer> findMinRotation(int[] a) {
		int i = 0;
		int j = 1;
		int len = a.length;
		int k = 0;
		while (i < len && j < len && k < len) {
			int t = a[(i + k) % len] - a[(j + k) % len];
			if (t == 0) {
				k++;
			} else {
				if (t > 0) {
					i += k + 1;
				} else {
					j += k + 1;
				}
				if (i == j) {
					j++;
				}
				k = 0;
			}
		}
		int start = Math.min(i, j);

		ArrayList<Integer> minRotation = new ArrayList<Integer>();
		for (int s = 0; s < len; s++) {
			minRotation.add(a[(start + s) % len]);
		}
		return minRotation;
	}
}
