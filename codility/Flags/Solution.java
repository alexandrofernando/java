package Flags;

// Boron 2013
// http://codility.com/demo/results/demoPUZWTF-4MF/

import java.util.ArrayList;

public class Solution {
	public int solution(int[] A) {
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		for (int i = 1; i + 1 < A.length; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				peaks.add(i);
			}
		}
		for (int flagNum = 1;; flagNum++) {
			int count = 0;
			int lastPeak = -1;
			for (int peak : peaks) {
				if (lastPeak < 0 || peak - lastPeak >= flagNum) {
					lastPeak = peak;
					count++;
				}
			}
			if (count < flagNum) {
				return flagNum - 1;
			}
		}
	}
}
