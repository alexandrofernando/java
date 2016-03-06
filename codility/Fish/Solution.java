package Fish;

// http://codility.com/demo/results/demoTTJ8NA-SKQ/

import java.util.Stack;

public class Solution {
	public int solution(int[] A, int[] B) {
		int aliveNum = 0;
		Stack<Integer> downIndices = new Stack<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (B[i] == 1) {
				downIndices.push(i);
			} else {
				while (!downIndices.isEmpty() && A[downIndices.peek()] < A[i]) {
					downIndices.pop();
				}
				if (downIndices.isEmpty()) {
					aliveNum++;
				}
			}
		}
		aliveNum += downIndices.size();
		return aliveNum;
	}
}
