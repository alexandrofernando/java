package MinMaxDivision;

// https://codility.com/demo/results/demoXYG7H6-XWH/

public class Solution {
	public int solution(int K, int[] A) {
		int result = -1;
		int lower = max(A);
		int upper = sum(A);
		while (lower <= upper) {
			int middle = (lower + upper) / 2;
			if (countBlocks(A, middle) <= K) {
				result = middle;
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}
		return result;
	}

	int max(int[] a) {
		int result = Integer.MIN_VALUE;
		for (int number : a) {
			result = Math.max(result, number);
		}
		return result;
	}

	int sum(int[] a) {
		int result = 0;
		for (int number : a) {
			result += number;
		}
		return result;
	}

	int countBlocks(int[] a, int limit) {
		int blockNum = 1;
		int sum = 0;
		for (int number : a) {
			if (sum + number <= limit) {
				sum += number;
			} else {
				blockNum++;
				sum = number;
			}
		}
		return blockNum;
	}
}
