package MaxCounters;

// http://codility.com/demo/results/demoF76GS6-3VK/

public class Solution {
	public int[] solution(int N, int[] A) {
		int max = 0;
		int baseMax = max;
		int baseIndex = 0;
		int[] increases = new int[N + 1];
		int[] bases = new int[N + 1];
		for (int i = 0; i < A.length; i++) {
			if (A[i] == N + 1) {
				baseMax = max;
				baseIndex = i + 1;
			} else {
				int x = A[i];
				if (bases[x] == baseIndex) {
					increases[x]++;
				} else {
					bases[x] = baseIndex;
					increases[x] = 1;
				}
				max = Math.max(max, baseMax + increases[x]);
			}
		}
		int[] counters = new int[N];
		for (int i = 0; i < counters.length; i++) {
			if (bases[i + 1] != baseIndex) {
				increases[i + 1] = 0;
			}
			counters[i] = baseMax + increases[i + 1];
		}
		return counters;
	}
}
