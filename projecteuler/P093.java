import java.util.Iterator;
import java.util.TreeSet;

public class P093 {
	public static void main(String args[]) {
		int maxN = -1;
		String answer = null;
		for (int i = 1; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				for (int k = j + 1; k <= 9; k++) {
					for (int p = k + 1; p <= 9; p++) {
						int set[] = new int[] { i, j, k, p };
						TreeSet<Integer> results = new TreeSet<Integer>();
						permutation(set, 0, results);
						Iterator<Integer> iter = results.iterator();
						int n = 0;
						while (iter.hasNext()) {
							if (iter.next() != n + 1) {
								break;
							}
							n++;
						}
						if (n > maxN) {
							maxN = n;
							answer = "" + set[0] + set[1] + set[2] + set[3];
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	static void permutation(int set[], int index, TreeSet<Integer> results) {
		if (index == set.length) {
			search(set, results, set[0], 1, 1);
		} else {
			for (int i = index; i < set.length; i++) {
				if (i != index) {
					int temp = set[i];
					set[i] = set[index];
					set[index] = temp;
				}
				permutation(set, index + 1, results);
				if (i != index) {
					int temp = set[i];
					set[i] = set[index];
					set[index] = temp;
				}
			}
		}
	}

	static void search(int set[], TreeSet<Integer> results, int numerator,
			int denominator, int index) {
		if (index == set.length) {
			if (numerator % denominator == 0 && numerator / denominator > 0) {
				results.add(numerator / denominator);
			}
		} else {
			search(set, results, numerator + set[index] * denominator,
					denominator, index + 1);
			search(set, results, numerator - set[index] * denominator,
					denominator, index + 1);
			search(set, results, set[index] * denominator - numerator,
					denominator, index + 1);
			search(set, results, numerator * set[index], denominator, index + 1);
			search(set, results, numerator, denominator * set[index], index + 1);
			if (numerator != 0) {
				search(set, results, set[index] * denominator, numerator,
						index + 1);
			}
		}
	}
}
