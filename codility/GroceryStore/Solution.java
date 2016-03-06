package GroceryStore;

// Hydrogenium 2013
// http://codility.com/demo/results/demoVK2NZ7-K5T/

public class Solution {
	public int solution(int[] A, int[] B, int[] C, int[] D) {
		int n = D.length;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < A.length; i++) {
			matrix[A[i]][B[i]] = Math.min(matrix[A[i]][B[i]], C[i]);
			matrix[B[i]][A[i]] = Math.min(matrix[B[i]][A[i]], C[i]);
		}
		boolean[] visited = new boolean[n];
		int[] distances = new int[n];
		for (int i = 0; i < n; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[0] = 0;
		for (int i = 0; i < n; i++) {
			int minIndex = -1;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && distances[j] != Integer.MAX_VALUE
						&& (minIndex < 0 || distances[j] < distances[minIndex])) {
					minIndex = j;
				}
			}
			if (minIndex < 0) {
				break;
			}
			if (distances[minIndex] <= D[minIndex]) {
				return distances[minIndex];
			}
			visited[minIndex] = true;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && matrix[minIndex][j] != Integer.MAX_VALUE) {
					distances[j] = Math.min(distances[j], distances[minIndex]
							+ matrix[minIndex][j]);
				}
			}
		}
		return -1;
	}
}
