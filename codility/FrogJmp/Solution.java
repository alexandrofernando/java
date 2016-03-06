package FrogJmp;

// http://codility.com/demo/results/demoY7SXRN-G9V/

public class Solution {
	public int solution(int X, int Y, int D) {
		int distance = Y - X;
		return distance / D + (distance % D == 0 ? 0 : 1);
	}
}
