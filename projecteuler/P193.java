// VM arguments: -Xms32m -Xmx800m

import java.util.ArrayList;

public class P193 {
	static final long LIMIT = 1L << 50;
	static final int SQRT_LIMIT = 1 << 25;
	static long squareNum = 0;
	static ArrayList<Long> primeSquares = new ArrayList<Long>();

	public static void main(String args[]) {
		findPrimeSquares();
		long minProduct = 1;
		for (int i = 1; i <= primeSquares.size(); i++) {
			minProduct *= primeSquares.get(i - 1);
			if (minProduct >= LIMIT) {
				break;
			}
			search(i, 0, 1, i % 2 == 1);
		}
		System.out.println(LIMIT - 1 - squareNum);
	}

	static void findPrimeSquares() {
		boolean sieved[] = new boolean[SQRT_LIMIT];
		for (int i = 2; i < sieved.length; i++) {
			if (!sieved[i]) {
				primeSquares.add((long) i * i);
				for (int j = i; j < sieved.length; j += i) {
					sieved[j] = true;
				}
			}
		}
	}

	static void search(int rest, int index, long product, boolean plus) {
		if (rest == 0) {
			long num = (LIMIT - 1) / product;
			if (plus) {
				squareNum += num;
			} else {
				squareNum -= num;
			}
			return;
		}
		for (int i = index; i <= primeSquares.size() - rest; i++) {
			long ps = primeSquares.get(i);
			if (ps > LIMIT / product || product * ps == LIMIT) {
				break;
			}
			search(rest - 1, i + 1, product * ps, plus);
		}
	}
}
