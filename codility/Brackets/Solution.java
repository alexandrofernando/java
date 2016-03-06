package Brackets;

// http://codility.com/demo/results/demoMYEVXY-MJH/

import java.util.Stack;

public class Solution {
	public int solution(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return 0;
				}
				char top = stack.pop();
				if (!((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}'))) {
					return 0;
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
