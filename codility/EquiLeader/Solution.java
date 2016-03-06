package EquiLeader;

// http://codility.com/demo/results/demo34TBNY-MEG/

public class Solution {
	public int solution(int[] A) {
		int candidate = -1;
		int size = 0;
		for (int elem : A) {
			if (size == 0) {
				candidate = elem;
				size = 1;
			} else if (elem == candidate) {
				size++;
			} else {
				size--;
			}
		}
		if (size == 0) {
			return 0;
		}
		int count = 0;
		for (int elem : A) {
			if (elem == candidate) {
				count++;
			}
		}
		if (count * 2 <= A.length) {
			return 0;
		}

		int leader = candidate;
		int result = 0;
		int countLeft = 0;
		for (int s = 0; s < A.length; s++) {
			if (A[s] == leader) {
				countLeft++;
			}
			if (countLeft * 2 > s + 1
					&& (count - countLeft) * 2 > A.length - s - 1) {
				result++;
			}
		}
		return result;
	}
}
