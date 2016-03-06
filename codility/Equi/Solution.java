package Equi;

// http://codility.com/demo/results/demoBCKR5F-77G/

public class Solution {
	public int solution(int[] A) {
		long total = 0;
		for (int elem : A) {
			total += elem;
		}
		long left = 0;
		long right = total;
		for (int i = 0; i < A.length; i++) {
			if (left == right - A[i]) {
				return i;
			}
			left += A[i];
			right -= A[i];
		}
		return -1;
	}
}
