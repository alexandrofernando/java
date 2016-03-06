package P1840__Eqs;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a[] = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = Math.abs(in.nextInt());
		}
		Arrays.sort(a);
		int leftCoefs[] = { a[0], a[1], a[2] };
		int rightCoefs[] = { -a[3], -a[4] };

		HashMap<Integer, Integer> sum2countLeft = buildHash(leftCoefs);
		HashMap<Integer, Integer> sum2countRight = buildHash(rightCoefs);

		int result = 0;
		Set<Entry<Integer, Integer>> leftEntries = sum2countLeft.entrySet();
		for (Entry<Integer, Integer> leftEntry : leftEntries) {
			if (sum2countRight.containsKey(leftEntry.getKey())) {
				result += leftEntry.getValue()
						* sum2countRight.get(leftEntry.getKey());
			}
		}
		System.out.println(result);

		in.close();
	}

	static HashMap<Integer, Integer> buildHash(int coefs[]) {
		HashMap<Integer, Integer> sum2count = new HashMap<Integer, Integer>();
		sum2count.put(0, 1);
		for (int coef : coefs) {
			HashMap<Integer, Integer> nextSum2count = new HashMap<Integer, Integer>();
			for (int xi = 1; xi <= 50; xi++) {
				int part = coef * xi * xi * xi;
				Set<Entry<Integer, Integer>> entries = sum2count.entrySet();
				for (Entry<Integer, Integer> entry : entries) {
					increaseSum2count(nextSum2count, entry.getKey() + part,
							entry.getValue());
					increaseSum2count(nextSum2count, entry.getKey() - part,
							entry.getValue());
				}
			}
			sum2count = nextSum2count;
		}
		return sum2count;
	}

	static void increaseSum2count(HashMap<Integer, Integer> sum2count, int key,
			int valueAddition) {
		int newValue = valueAddition
				+ (sum2count.containsKey(key) ? sum2count.get(key) : 0);
		sum2count.put(key, newValue);
	}
}
