import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P143 {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		int LIMIT = 120000;
		ArrayList<Integer> pairs[] = new ArrayList[LIMIT - 1];
		for (int i = 0; i < pairs.length; i++) {
			pairs[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= LIMIT - 2; i++) {
			long value = (long) i * i + (long) (i + 1) * (i + 1) + (long) i
					* (i + 1);
			for (int j = i + 1; i + j <= LIMIT - 1; j++) {
				if (isSquare(value)) {
					pairs[i].add(j);
				}
				value += 2 * j + 1 + i;
			}
		}
		HashSet<Integer> sumPQRs = new HashSet<Integer>();
		for (int p = 1; p < pairs.length; p++) {
			for (int q : pairs[p]) {
				for (int r : pairs[q]) {
					if (p + q + r <= LIMIT
							&& Collections.binarySearch(pairs[p], r) >= 0) {
						sumPQRs.add(p + q + r);
					}
				}
			}
		}
		int total = 0;
		for (int sum : sumPQRs) {
			total += sum;
		}
		System.out.println(total);
	}

	static boolean isSquare(long number) {
		long root = Math.round(Math.sqrt(number));
		return root * root == number;
	}
}
