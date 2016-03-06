package PassingCars;

// http://codility.com/demo/results/demoJSRP2H-UKN/

public class Solution {
	public int solution(int[] A) {
		final int LIMIT = 1000000000;
		int passingNum = 0;
		int zeroNum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				zeroNum++;
			} else {
				passingNum += zeroNum;
				if (passingNum > LIMIT) {
					return -1;
				}
			}
		}
		return passingNum;
	}
}
