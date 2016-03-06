package PermMissingElem;

// http://codility.com/demo/results/demoW37GVC-WAR/

public class Solution {
	public int solution(int[] A) {
		int N = A.length;
		long left = (long) (N + 1) * (N + 2) / 2;
		for (int elem : A) {
			left -= elem;
		}
		return (int) left;
	}
}
