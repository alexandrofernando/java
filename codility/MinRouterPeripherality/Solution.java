package MinRouterPeripherality;

// lambda 2011
// https://codility.com/demo/results/demoFXEQPC-RX2/

import java.util.Arrays;

public class Solution {
	public int solution(int[] T) {
		int n = T.length;
		int[] degrees = new int[n];
		for (int current = 0; current < n; current++) {
			int parent = T[current];
			if (parent != current) {
				degrees[parent]++;
			}
		}

		int[] orders = new int[n];
		int orderIndex = 0;
		for (int i = 0; i < n; i++) {
			if (degrees[i] == 0) {
				orders[orderIndex] = i;
				orderIndex++;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int current = orders[i];
			int parent = T[current];
			degrees[parent]--;
			if (degrees[parent] == 0) {
				orders[orderIndex] = parent;
				orderIndex++;
			}
		}

		long[] pathLens = new long[n];
		int[] sizes = new int[n];
		Arrays.fill(sizes, 1);
		for (int i = 0; i < n - 1; i++) {
			int current = orders[i];
			int parent = T[current];
			sizes[parent] += sizes[current];
			pathLens[parent] += pathLens[current] + sizes[current];
		}

		for (int i = n - 2; i >= 0; i--) {
			int current = orders[i];
			int parent = T[current];
			pathLens[current] = pathLens[parent] - sizes[current] + n
					- sizes[current];
		}

		int result = 0;
		for (int i = 1; i < n; i++) {
			if (pathLens[i] < pathLens[result]) {
				result = i;
			}
		}
		return result;
	}
}
