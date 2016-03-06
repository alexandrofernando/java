import java.util.HashMap;

public class P189 {
	static HashMap<Integer, Long> counts = new HashMap<Integer, Long>();
	static int power3[] = new int[] { 1, 3, 9, 27, 81, 243, 729, 2187, 6561 };
	static int FLOOR = 8;

	public static void main(String args[]) {
		for (int i = 0; i < power3[FLOOR]; i++) {
			counts.put(i, 1L);
		}
		for (int i = FLOOR; i >= 2; i--) {
			transfer(i, i - 1);
			transfer(i - 1, i - 1);
		}
		long sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += counts.get(i);
		}
		System.out.println(sum);
	}

	static void transfer(int prev, int next) {
		HashMap<Integer, Long> nextCounts = new HashMap<Integer, Long>();
		for (int i = 0; i < power3[next]; i++) {
			nextCounts.put(i, 0L);
		}
		for (int i = 0; i < power3[prev]; i++) {
			for (int j = 0; j < power3[next]; j++) {
				if (valid(j, next, i, prev)) {
					nextCounts.put(j, nextCounts.get(j) + counts.get(i));
				}
			}
		}
		counts = nextCounts;
	}

	static boolean valid(int code1, int size1, int code2, int size2) {
		int layout1[] = decode(code1, size1);
		int layout2[] = decode(code2, size2);
		for (int i = 0; i < layout1.length; i++) {
			if (layout1[i] == layout2[i]
					|| (size1 + 1 == size2 && layout1[i] == layout2[i + 1])) {
				return false;
			}
		}
		return true;
	}

	static int[] decode(int code, int size) {
		int layout[] = new int[size];
		for (int i = 0; i < layout.length; i++) {
			layout[i] = code % 3;
			code /= 3;
		}
		return layout;
	}
}
