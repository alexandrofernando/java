package StoneWall;

// Sigma 2012
// http://codility.com/demo/results/demoRX6A3A-2JY/

import java.util.Stack;

public class Solution {
	public int solution(int[] H) {
		int blockNum = 0;
		Stack<Integer> heights = new Stack<Integer>();
		for (int oneH : H) {
			while (!heights.isEmpty() && heights.peek() > oneH) {
				heights.pop();
				blockNum++;
			}
			if (!heights.isEmpty() && heights.peek() == oneH) {
				continue;
			}
			heights.push(oneH);
		}
		blockNum += heights.size();
		return blockNum;
	}
}
