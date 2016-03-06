import java.util.HashSet;

public class P310 {
	public static void main(String args[]) {
		final int LIMIT = 100000;
		int nimbers[] = new int[LIMIT + 1];
		int maxNimber = -1;
		for (int i = 0; i < nimbers.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 1; j * j <= i; j++) {
				set.add(nimbers[i - j * j]);
			}
			nimbers[i] = mex(set);
			maxNimber = Math.max(maxNimber, nimbers[i]);
		}
		long nimberCounts[] = new long[maxNimber + 1];
		for (int nimber : nimbers) {
			nimberCounts[nimber]++;
		}
		long result = 0;
		for (int x = 0; x < nimberCounts.length; x++) {
			for (int y = 0; y < nimberCounts.length; y++) {
				for (int z = 0; z < nimberCounts.length; z++) {
					if ((x ^ y ^ z) != 0) {
						continue;
					}
					if (x == y && y == z) {
						result += nimberCounts[x] * (nimberCounts[x] + 1)
								* (nimberCounts[x] + 2) / 6;
					} else if (x == y && y != z) {
						result += nimberCounts[x] * (nimberCounts[x] + 1) / 2
								* nimberCounts[z];
					} else if (x < y && y < z) {
						result += nimberCounts[x] * nimberCounts[y]
								* nimberCounts[z];
					}
				}
			}
		}
		System.out.println(result);
	}

	static int mex(HashSet<Integer> set) {
		for (int i = 0;; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
	}
}
