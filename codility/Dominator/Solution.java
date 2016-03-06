package Dominator;

// http://codility.com/demo/results/demoD6DAXW-Z7A/

public class Solution {
	public int solution(int[] A) {
		int dominatorIndex = -1;
		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if (size == 0) {
				dominatorIndex = i;
				size = 1;
			} else if (A[i] == A[dominatorIndex]) {
				size++;
			} else {
				size--;
			}
		}
		if (size == 0 || dominatorIndex < 0) {
			return -1;
		}
		int candidate = A[dominatorIndex];
		int count = 0;
		for (int elem : A) {
			if (elem == candidate) {
				count++;
			}
		}
		if (count * 2 > A.length) {
			return dominatorIndex;
		}
		return -1;
	}
}
