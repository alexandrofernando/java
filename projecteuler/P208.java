import java.util.HashMap;

public class P208 {
	static final int STEP = 70;
	static int part = STEP / 5;
	static HashMap<Integer, Long> history = new HashMap<Integer, Long>();

	public static void main(String args[]) {
		System.out.println(go(part, part, part, part, part, 0));
	}

	static long go(int c0, int c1, int c2, int c3, int c4, int direction) {
		if (c0 < 0 || c1 < 0 || c2 < 0 || c3 < 0 || c4 < 0) {
			return 0;
		}
		if (c0 == 0 && c1 == 0 && c2 == 0 && c3 == 0 && c4 == 0) {
			return 1;
		}
		int code = encode(c0, c1, c2, c3, c4, direction);
		Long ret = history.get(code);
		if (ret != null) {
			return ret;
		}
		long result;
		if (direction == 0) {
			result = go(c0, c1, c2, c3, c4 - 1, 4)
					+ go(c0 - 1, c1, c2, c3, c4, 1);
		} else if (direction == 1) {
			result = go(c0 - 1, c1, c2, c3, c4, 0)
					+ go(c0, c1 - 1, c2, c3, c4, 2);
		} else if (direction == 2) {
			result = go(c0, c1 - 1, c2, c3, c4, 1)
					+ go(c0, c1, c2 - 1, c3, c4, 3);
		} else if (direction == 3) {
			result = go(c0, c1, c2 - 1, c3, c4, 2)
					+ go(c0, c1, c2, c3 - 1, c4, 4);
		} else {
			result = go(c0, c1, c2, c3 - 1, c4, 3)
					+ go(c0, c1, c2, c3, c4 - 1, 0);
		}
		history.put(code, result);
		return result;
	}

	static int encode(int c0, int c1, int c2, int c3, int c4, int direction) {
		return c0 * part * part * part * part * part + c1 * part * part * part
				* part + c2 * part * part * part + c3 * part * part + c4 * part
				+ direction;
	}
}
