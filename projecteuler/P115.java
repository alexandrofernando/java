public class P115 {
	public static void main(String args[]) {
		final int M = 50;
		int prevWaysSum = 1;
		int prevWays1[] = new int[M];
		for (int i = 0; i < M; i++) {
			prevWays1[i] = 1;
		}
		int prevSumWays1 = 0;
		for (int n = M;; n++) {
			prevSumWays1 += prevWays1[n % M];
			int currentWays0 = prevSumWays1;
			int currentWays1 = prevWaysSum;
			int currentWaysSum = currentWays0 + currentWays1;
			if (currentWaysSum > 1000000) {
				System.out.println(n);
				break;
			}
			prevWaysSum = currentWaysSum;
			prevWays1[n % M] = currentWays1;
		}
	}
}
