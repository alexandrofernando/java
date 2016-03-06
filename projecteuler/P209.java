import java.util.ArrayList;
import java.util.HashMap;

public class P209 {
	static HashMap<Long, Long> counts = new HashMap<Long, Long>();
	@SuppressWarnings("unchecked")
	static ArrayList<SixTuple> adjacents[][][][][][] = new ArrayList[2][2][2][2][2][2];

	public static void main(String args[]) {
		for (int a = 0; a < 2; a++) {
			for (int b = 0; b < 2; b++) {
				for (int c = 0; c < 2; c++) {
					for (int d = 0; d < 2; d++) {
						for (int e = 0; e < 2; e++) {
							for (int f = 0; f < 2; f++) {
								adjacents[a][b][c][d][e][f] = new ArrayList<SixTuple>();
							}
						}
					}
				}
			}
		}
		for (int a = 0; a < 2; a++) {
			for (int b = 0; b < 2; b++) {
				for (int c = 0; c < 2; c++) {
					for (int d = 0; d < 2; d++) {
						for (int e = 0; e < 2; e++) {
							for (int f = 0; f < 2; f++) {
								int g = a ^ (b & c);
								adjacents[a][b][c][d][e][f].add(new SixTuple(b,
										c, d, e, f, g));
								adjacents[b][c][d][e][f][g].add(new SixTuple(a,
										b, c, d, e, f));
							}
						}
					}
				}
			}
		}
		long answer = search(0, 0, 0, 0, 0, 0, new boolean[2][2][2][2][2][2]);
		System.out.println(answer);
	}

	static long search(int a, int b, int c, int d, int e, int f,
			boolean determined[][][][][][]) {
		long code = encode(determined);
		Long count = counts.get(code);
		if (count != null) {
			return count;
		}
		if (a == 2) {
			return 1;
		}
		int nextA = a;
		int nextB = b;
		int nextC = c;
		int nextD = d;
		int nextE = e;
		int nextF = f + 1;
		if (nextF == 2) {
			nextF = 0;
			nextE++;
			if (nextE == 2) {
				nextE = 0;
				nextD++;
				if (nextD == 2) {
					nextD = 0;
					nextC++;
					if (nextC == 2) {
						nextC = 0;
						nextB++;
						if (nextB == 2) {
							nextB = 0;
							nextA++;
						}
					}
				}
			}
		}
		if (determined[a][b][c][d][e][f]) {
			return search(nextA, nextB, nextC, nextD, nextE, nextF, determined);
		}
		long sum = 0;
		determined[a][b][c][d][e][f] = true;
		sum += search(nextA, nextB, nextC, nextD, nextE, nextF, determined);
		ArrayList<SixTuple> changed = new ArrayList<SixTuple>();
		if (a != 0 || b != 0 || c != 0 || d != 0 || e != 0 || f != 0) {
			for (int i = 0; i < adjacents[a][b][c][d][e][f].size(); i++) {
				SixTuple adj = adjacents[a][b][c][d][e][f].get(i);
				if (!determined[adj.a][adj.b][adj.c][adj.d][adj.e][adj.f]) {
					determined[adj.a][adj.b][adj.c][adj.d][adj.e][adj.f] = true;
					changed.add(adj);
				}
			}
			sum += search(nextA, nextB, nextC, nextD, nextE, nextF, determined);
			for (int i = 0; i < changed.size(); i++) {
				SixTuple adj = changed.get(i);
				determined[adj.a][adj.b][adj.c][adj.d][adj.e][adj.f] = false;
			}
		}
		determined[a][b][c][d][e][f] = false;
		counts.put(code, sum);
		return sum;
	}

	static long encode(boolean determined[][][][][][]) {
		long code = 0;
		for (int a = 0; a < 2; a++) {
			for (int b = 0; b < 2; b++) {
				for (int c = 0; c < 2; c++) {
					for (int d = 0; d < 2; d++) {
						for (int e = 0; e < 2; e++) {
							for (int f = 0; f < 2; f++) {
								code = code
										* 2
										+ (determined[a][b][c][d][e][f] ? 1 : 0);
							}
						}
					}
				}
			}
		}
		return code;
	}
}

class SixTuple {
	int a;
	int b;
	int c;
	int d;
	int e;
	int f;

	SixTuple(int A, int B, int C, int D, int E, int F) {
		this.a = A;
		this.b = B;
		this.c = C;
		this.d = D;
		this.e = E;
		this.f = F;
	}
}