import java.util.HashSet;
import java.util.Iterator;

public class P032 {
	public static void main(String args[]) {
		HashSet<Integer> products = new HashSet<Integer>();
		int sum = 0;
		boolean used[] = new boolean[10];
		for (int a = 1; a <= 9; a++) {
			used[a] = true;
			for (int b = 1; b <= 9; b++) {
				if (used[b]) {
					continue;
				}
				used[b] = true;
				for (int c = 1; c <= 9; c++) {
					if (used[c]) {
						continue;
					}
					used[c] = true;
					for (int d = 1; d <= 9; d++) {
						if (used[d]) {
							continue;
						}
						used[d] = true;
						for (int e = 1; e <= 9; e++) {
							if (used[e]) {
								continue;
							}
							used[e] = true;
							int product = (10 * a + b) * (100 * c + 10 * d + e);
							if (isValid(product, used)) {
								products.add(product);
							}
							product = a * (1000 * b + 100 * c + 10 * d + e);
							if (isValid(product, used)) {
								products.add(product);
							}
							used[e] = false;
						}
						used[d] = false;
					}
					used[c] = false;
				}
				used[b] = false;
			}
			used[a] = false;
		}
		Iterator<Integer> iter = products.iterator();
		while (iter.hasNext()) {
			sum += iter.next();
		}
		System.out.println(sum);
	}

	static boolean isValid(int number, boolean used[]) {
		if (number >= 10000) {
			return false;
		}
		int digits[] = new int[4];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = number % 10;
			if (digits[i] == 0) {
				return false;
			}
			number /= 10;
		}
		if (digits[0] == digits[1] || digits[0] == digits[2]
				|| digits[0] == digits[3] || digits[1] == digits[2]
				|| digits[1] == digits[3] || digits[2] == digits[3]) {
			return false;
		}
		return !(used[digits[0]] || used[digits[1]] || used[digits[2]] || used[digits[3]]);
	}
}
