package PermCheck;

// http://codility.com/demo/results/demoRGEPGW-JYA/

public class Solution {
	public int solution(int[] A) {
		boolean[] used = new boolean[A.length + 1];
		for (int elem : A) {
			if (elem < 1 || elem > A.length || used[elem]) {
				return 0;
			}
			used[elem] = true;
		}
		return 1;
	}
}
