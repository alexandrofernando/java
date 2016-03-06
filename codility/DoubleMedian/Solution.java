package DoubleMedian;

// Nu 2011
// https://codility.com/demo/results/demoK6B9KT-SUR/

import java.util.Arrays;

public class Solution {
	public int solution(int[] A, int[] B, int[] P, int[] Q, int[] R, int[] S) {
		int[] medians = new int[P.length];
		for (int i = 0; i < medians.length; i++) {
			medians[i] = findMedianSortedArrays(A, P[i], Q[i], B, R[i], S[i]);
		}
		Arrays.sort(medians);
		return medians[medians.length / 2];
	}

	int findMedianSortedArrays(int[] A, int beginA, int endA, int[] B,
			int beginB, int endB) {
		int lengthA = endA - beginA + 1;
		int lengthB = endB - beginB + 1;
		int totalLength = lengthA + lengthB;
		return findMedianSortedArrays(A, beginA, endA, B, beginB, endB,
				(totalLength + 1) / 2);
	}

	int findMedianSortedArrays(int[] A, int beginA, int endA, int[] B,
			int beginB, int endB, int k) {
		int lengthA = endA - beginA + 1;
		int lengthB = endB - beginB + 1;
		if (lengthA == 0) {
			return B[beginB + k - 1];
		}
		if (lengthB == 0) {
			return A[beginA + k - 1];
		}

		int lastK = lengthA + lengthB - k + 1;
		int middleA = (beginA + endA) / 2;
		int middleB = (beginB + endB) / 2;
		if (A[middleA] < B[middleB]) {
			if (middleA - beginA + 1 >= k) {
				return findMedianSortedArrays(A, beginA, middleA, B, beginB,
						middleB - 1, k);
			} else if (endB - middleB + 1 >= lastK) {
				int nextK = (endA - middleA) + (endB - middleB + 1) + 1 - lastK;
				return findMedianSortedArrays(A, middleA + 1, endA, B, middleB,
						endB, nextK);
			} else if ((middleA - beginA + 1) + (middleB - beginB) >= k) {
				return findMedianSortedArrays(A, beginA, endA, B, beginB,
						middleB - 1, k);
			} else {
				int nextK = (endA - middleA) + lengthB + 1 - lastK;
				return findMedianSortedArrays(A, middleA + 1, endA, B, beginB,
						endB, nextK);
			}
		} else {
			if (middleB - beginB + 1 >= k) {
				return findMedianSortedArrays(A, beginA, middleA - 1, B,
						beginB, middleB, k);
			} else if (endA - middleA + 1 >= lastK) {
				int nextK = (endA - middleA + 1) + (endB - middleB) + 1 - lastK;
				return findMedianSortedArrays(A, middleA, endA, B, middleB + 1,
						endB, nextK);
			} else if ((middleA - beginA) + (middleB - beginB + 1) >= k) {
				return findMedianSortedArrays(A, beginA, middleA - 1, B,
						beginB, endB, k);
			} else {
				int nextK = lengthA + (endB - middleB) + 1 - lastK;
				return findMedianSortedArrays(A, beginA, endA, B, middleB + 1,
						endB, nextK);
			}
		}
	}
}
