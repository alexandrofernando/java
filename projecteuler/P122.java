public class P122 {
	static final int MAX_DEPTH = 12;
	static final int LIMIT = 200;
	static int history[] = new int[MAX_DEPTH];
	static int m[] = new int[LIMIT + 1];

	public static void main(String args[]) {
		m[1] = 0;
		m[2] = 1;
		for (int i = 3; i <= LIMIT; i++) {
			m[i] = Integer.MAX_VALUE;
		}
		int sum = 0;
		history[0] = 1;
		history[1] = 2;
		search(2);
		for (int i = 1; i <= LIMIT; i++) {
			sum += m[i];
		}
		System.out.println(sum);
	}

	static void search(int depth) {
		if (depth == MAX_DEPTH) {
			for (int i = 2; i < MAX_DEPTH; i++) {
				if (history[i] <= LIMIT && m[history[i]] > i) {
					m[history[i]] = i;
				}
			}
			return;
		}
		for (int i = depth - 1; i >= 0; i--) {
			history[depth] = history[depth - 1] + history[i];
			search(depth + 1);
		}
	}
}
