package P1185__Artillery_Position;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	static int m;
	static HashMap<Integer, Integer> max[];
	static int index;
	static int occupy[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		m = in.nextInt();
		boolean bad[][] = new boolean[n + 1][m + 5];
		for (int i = 1; i <= n; i++) {
			String str = in.next();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'H') {
					bad[i][j + 3] = true;
				}
			}
		}
		max = new HashMap[2];
		for (int i = 0; i < 2; i++) {
			max[i] = new HashMap<Integer, Integer>();
		}
		index = 1;

		max[0].put(0, 0);
		for (int i = 1; i <= n; i++) {
			max[index] = new HashMap<Integer, Integer>();
			Iterator<Entry<Integer, Integer>> iterator = max[(index + 1) % 2]
					.entrySet().iterator();
			while (iterator.hasNext() == true) {
				Entry<Integer, Integer> one = iterator.next();
				occupy = decode(one.getKey());
				search(bad[i], 1, one.getValue());
			}
			index = (index + 1) % 2;
		}
		index = (index + 1) % 2;
		int result = -1;
		Iterator<Entry<Integer, Integer>> iterator = max[index].entrySet()
				.iterator();
		while (iterator.hasNext() == true) {
			Entry<Integer, Integer> one = iterator.next();
			if (one.getValue() > result) {
				result = one.getValue();
			}
		}
		System.out.println(result);
	}

	static int[] decode(int number) {
		int result[] = new int[m + 5];
		for (int i = m + 4; i >= 1; i--) {
			result[i] = number % 3;
			number /= 3;
		}
		return result;
	}

	static int encode(int a[]) {
		int result = 0;
		for (int i = 1; i <= m + 4; i++) {
			if (a[i] > 0) {
				result = result * 3 + a[i] - 1;
			} else {
				result = result * 3;
			}
		}
		return result;
	}

	static void search(boolean rowBad[], int column, int chips) {
		if (column > m) {
			int number = encode(occupy);
			if (max[index].containsKey(number) == false
					|| max[index].get(number) < chips) {
				max[index].put(number, chips);
			}
		} else {
			search(rowBad, column + 1, chips);
			if (column <= m && occupy[column + 2] == 0 && !rowBad[column + 2]) {
				occupy[column + 2] = 3;
				search(rowBad, column + 3, chips + 1);
				occupy[column + 2] = 0;
			}
		}
	}
}