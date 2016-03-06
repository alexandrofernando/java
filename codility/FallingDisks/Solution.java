package FallingDisks;

// Omega 2013
// http://codility.com/demo/results/demoKQ3R5T-M29/

import java.util.Stack;

public class Solution {
	public int solution(int[] A, int[] B) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int ring : A) {
			stack.push(Math.min(ring, stack.isEmpty() ? Integer.MAX_VALUE
					: stack.peek()));
		}
		int diskFitNum = 0;
		for (int disk : B) {
			while (!stack.isEmpty() && stack.peek() < disk) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				break;
			}
			diskFitNum++;
			stack.pop();
		}
		return diskFitNum;
	}
}
