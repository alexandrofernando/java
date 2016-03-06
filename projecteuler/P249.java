import java.util.ArrayList;

public class P249 {
	public static void main(String args[]) {
		int LIMIT_S = 4999;
		int LIMIT_SUM = 1548136;
		boolean sieved[] = new boolean[LIMIT_SUM + 1];
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (int i = 2; i < sieved.length; i++) {
			if (!sieved[i]) {
				if (i <= LIMIT_S) {
					s.add(i);
				}
				for (int j = i + i; j < sieved.length; j += i) {
					sieved[j] = true;
				}
			}
		}
		long counts[] = new long[LIMIT_SUM + 1];
		for (int p : s) {
			long next[] = new long[LIMIT_SUM + 1];
			next[p] = modAdd(next[p], 1);
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] > 0) {
					next[i] = modAdd(next[i], counts[i]);
					next[i + p] = modAdd(next[i + p], counts[i]);
				}
			}
			counts = next;
		}
		long answer = 0;
		for (int i = 0; i < counts.length; i++) {
			if (!sieved[i]) {
				answer = modAdd(answer, counts[i]);
			}
		}
		System.out.println(answer);
	}

	static long modAdd(long a, long b) {
		return (a + b) % 10000000000000000L;
	}
}
