import java.util.ArrayList;
import java.util.Collections;

public class P321 {
	public static void main(String args[]) {
		final int TARGET_FOUND = 40;
		Pair pairs[] = new Pair[2];
		pairs[0] = new Pair(1, 2);
		pairs[1] = new Pair(3, 5);
		ArrayList<Pair> order = new ArrayList<Pair>();
		order.add(pairs[0]);
		order.add(pairs[1]);
		while (true) {
			boolean update = false;
			for (int i = 0; i < 2; i++) {
				pairs[i] = next(pairs[i]);
				if (order.size() < TARGET_FOUND
						|| order.get(TARGET_FOUND - 1).n > pairs[i].n) {
					int pos = Collections.binarySearch(order, pairs[i]);
					if (pos < 0) {
						pos = -1 - pos;
					}
					order.add(pos, pairs[i]);
					update = true;
				}
			}
			if (!update) {
				break;
			}
		}
		long sum = 0;
		for (int i = 0; i < TARGET_FOUND; i++) {
			sum += order.get(i).n;
		}
		System.out.println(sum);
	}

	static Pair next(Pair p) {
		long nextN = 3 * p.n + 2 * p.m + 3;
		long nextM = 4 * p.n + 3 * p.m + 5;
		return new Pair(nextN, nextM);
	}
}

class Pair implements Comparable<Pair> {
	long n;
	long m;

	Pair(long N, long M) {
		this.n = N;
		this.m = M;
	}

	@Override
	public int compareTo(Pair another) {
		if (this.n < another.n) {
			return -1;
		} else if (this.n > another.n) {
			return 1;
		} else {
			return 0;
		}
	}
}