import java.util.ArrayList;
import java.util.HashMap;

public class P309 {
	public static void main(String args[]) {
		final int LIMIT = 1000000;
		HashMap<Integer, ArrayList<Integer>> pairLengths = new HashMap<Integer, ArrayList<Integer>>();
		for (int n = 1; n * n * 2 < LIMIT; n++) {
			for (int m = n + 1;; m += 2) {
				int a = m * m - n * n;
				int b = 2 * m * n;
				int c = m * m + n * n;
				if (c >= LIMIT) {
					break;
				}
				if (gcd(m, n) != 1) {
					continue;
				}
				for (int i = 1;; i++) {
					int ai = a * i;
					int bi = b * i;
					int ci = c * i;
					if (ci >= LIMIT) {
						break;
					}
					addPair(pairLengths, ai, bi);
					addPair(pairLengths, bi, ai);
				}
			}
		}
		int result = 0;
		for (ArrayList<Integer> lengths : pairLengths.values()) {
			for (int i = 0; i < lengths.size(); i++) {
				for (int j = i + 1; j < lengths.size(); j++) {
					int h1 = lengths.get(i);
					int h2 = lengths.get(j);
					if ((long) h1 * h2 % (h1 + h2) == 0) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

	static int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	static void addPair(HashMap<Integer, ArrayList<Integer>> pairLengths,
			int length1, int length2) {
		ArrayList<Integer> lengths = pairLengths.get(length1);
		if (lengths == null) {
			lengths = new ArrayList<Integer>();
			pairLengths.put(length1, lengths);
		}
		lengths.add(length2);
	}
}
