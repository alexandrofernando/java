package MinPerimeterRectangle;

// http://codility.com/demo/results/demoDMGS5F-4E5/

public class Solution {
	public int solution(int N) {
		int minPerimeter = Integer.MAX_VALUE;
		for (int i = 1; i * i <= N; i++) {
			if (N % i == 0) {
				minPerimeter = Math.min(minPerimeter, 2 * (i + N / i));
			}
		}
		return minPerimeter;
	}
}
