package HamiltonianRoutesCount;

// Eta 2011
// https://codility.com/demo/results/demoTWV63P-P7E/

import java.util.HashMap;

public class Solution {
	public int solution(int[] A) {
		int m = A.length / 2 + 1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == A[(i + 1) % A.length]) {
				return -2;
			}
		}

		int[] townCounts = new int[m];
		for (int town : A) {
			townCounts[town]++;
		}
		for (int townCount : townCounts) {
			if (townCount != 1 && townCount != 3) {
				return -2;
			}
		}

		HashMap<Road, Integer> road2count = new HashMap<Road, Integer>();
		for (int i = 0; i < A.length; i++) {
			Road road = new Road(A[i], A[(i + 1) % A.length]);
			if (!road2count.containsKey(road)) {
				road2count.put(road, 0);
			}
			road2count.put(road, road2count.get(road) + 1);
		}
		for (int count : road2count.values()) {
			if (count != 2) {
				return -2;
			}
		}

		return 3;
	}
}

class Road {
	int town1;
	int town2;

	Road(int t1, int t2) {
		town1 = Math.min(t1, t2);
		town2 = Math.max(t1, t2);
	}

	public int hashCode() {
		return town1 * town2;
	}

	public boolean equals(Object obj) {
		Road other = (Road) obj;
		return town1 == other.town1 && town2 == other.town2;
	}
}