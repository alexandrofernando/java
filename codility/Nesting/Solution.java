package Nesting;

// http://codility.com/demo/results/demoZYKJ7V-B9X/

public class Solution {
	public int solution(String S) {
		int leftNum = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				leftNum++;
			} else {
				if (leftNum == 0) {
					return 0;
				}
				leftNum--;
			}
		}
		return leftNum == 0 ? 1 : 0;
	}
}
