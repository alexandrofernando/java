import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P270 {
	static final int MODULO = 100000000;
	static HashMap<ArrayList<Integer>, Integer> history = new HashMap<ArrayList<Integer>, Integer>();

	public static void main(String args[]) {
		final int N = 30;
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			sizes.add(N);
		}
		System.out.println(calcWay(sizes));
	}

	static int calcWay(ArrayList<Integer> sizes) {
		if (sizes.size() < 3) {
			return 0;
		}
		if (isNonCuttable(sizes)) {
			return 1;
		}

		Collections.sort(sizes);
		if (history.containsKey(sizes)) {
			return history.get(sizes);
		}

		@SuppressWarnings("unchecked")
		ArrayList<Integer> newSizes = (ArrayList<Integer>) sizes.clone();
		cutCorner(newSizes);
		int way = calcWay(newSizes);
		for (int i = 1; i < sizes.size() - 1; i++) {
			for (int j = (i == 1) ? 1 : 0; j < sizes.get(i); j++) {
				ArrayList<Integer> rightSizes = new ArrayList<Integer>();
				for (int k = 0; k < i; k++) {
					rightSizes.add(sizes.get(k));
				}
				if (j > 0) {
					rightSizes.add(j);
				}
				rightSizes.add(1);
				cutCorner(rightSizes);

				ArrayList<Integer> leftSizes = new ArrayList<Integer>();
				leftSizes.add(1);
				leftSizes.add(sizes.get(i) - j);
				for (int k = i + 1; k < sizes.size(); k++) {
					leftSizes.add(sizes.get(k));
				}

				way = addMod(way,
						multiplyMod(calcWay(rightSizes), calcWay(leftSizes)));
			}
		}
		history.put(sizes, way);
		return way;
	}

	static int addMod(int a, int b) {
		return (a + b) % MODULO;
	}

	static int multiplyMod(int a, int b) {
		return (int) ((long) a * b % MODULO);
	}

	static void cutCorner(ArrayList<Integer> sizes) {
		if (isNonCuttable(sizes)) {
			return;
		}
		if (sizes.get(0) == 1) {
			sizes.remove(0);
		} else {
			sizes.set(0, sizes.get(0) - 1);
		}
		if (sizes.get(sizes.size() - 1) == 1) {
			sizes.remove(sizes.size() - 1);
		} else {
			sizes.set(sizes.size() - 1, sizes.get(sizes.size() - 1) - 1);
		}
		sizes.add(1);
	}

	static boolean isNonCuttable(ArrayList<Integer> sizes) {
		return sizes.size() == 3 && sizes.get(0) == 1 && sizes.get(1) == 1
				&& sizes.get(2) == 1;
	}
}
