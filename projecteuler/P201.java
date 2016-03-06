public class P201 {
	static int solutionCount;
	static int s[] = new int[100];
	static int sums[][] = new int[s.length][s.length];

	public static void main(String args[]) {
		final int ELEMENT = 50;
		for (int i = 0; i < s.length; i++) {
			s[i] = (i + 1) * (i + 1);
		}
		for (int i = 0; i < sums.length; i++) {
			sums[i][i] = s[i];
			for (int j = i + 1; j < sums.length; j++) {
				sums[i][j] = sums[i][j - 1] + s[j];
			}
		}
		int answer = 0;
		for (int target = sums[ELEMENT][s.length - 1]; target >= sums[0][ELEMENT - 1]; target--) {
			solutionCount = 0;
			search(target, s.length - 1, ELEMENT);
			if (solutionCount == 1) {
				answer += target;
			}
		}
		System.out.println(answer);
	}

	static void search(int target, int index, int count) {
		if (target == 0 && count == 0) {
			solutionCount++;
			return;
		}
		if (target < sums[0][count - 1]
				|| target > sums[index - count + 1][index]) {
			return;
		}
		if (index + 1 > count) {
			search(target, index - 1, count);
			if (solutionCount > 1) {
				return;
			}
		}
		if (s[index] <= target) {
			search(target - s[index], index - 1, count - 1);
			if (solutionCount > 1) {
				return;
			}
		}
	}
}
