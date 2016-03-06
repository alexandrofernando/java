package MaxProfit;

// http://codility.com/demo/results/demoNG8MWF-S7U/

public class Solution {
	public int solution(int[] A) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : A) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		return maxProfit;
	}
}
