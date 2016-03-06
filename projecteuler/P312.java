// VM arguments: -Xms32m -Xmx4000m

import java.util.HashMap;

public class P312 {
	public static void main(String args[]) {
		final int N = 10000;
		final int MODULO = (int) Math.pow(13, 8);

		int modulos[] = new int[3];
		Cycle cycles[] = new Cycle[3];
		for (int i = 0; i < modulos.length; i++) {
			if (i == 0) {
				modulos[i] = MODULO;
			} else {
				modulos[i] = cycles[i - 1].period;
			}
			cycles[i] = findCycle(modulos[i]);
		}

		int n = N;
		for (int i = modulos.length - 1; i >= 0; i--) {
			if (n < cycles[i].start) {
				n = calcC(n, modulos[i]);
			} else {
				n = calcC(cycles[i].start + (n - cycles[i].start)
						% cycles[i].period, modulos[i]);
			}
		}
		System.out.println(n);

	}

	static int calcC(int n, int modulo) {
		if (n <= 2) {
			return 1;
		}
		Sierpinski s = new Sierpinski(1, 2, 3);
		for (int i = 3; i <= n; i++) {
			s = s.next(modulo);
		}
		return s.cycleNum;
	}

	static Cycle findCycle(int modulo) {
		HashMap<Sierpinski, Integer> history = new HashMap<Sierpinski, Integer>();
		Sierpinski s = new Sierpinski(1, 2, 3);
		for (int i = 2;; i++) {
			if (i != 2) {
				s = s.next(modulo);
			}
			if (history.containsKey(s)) {
				int begin = history.get(s);
				int period = i - begin;
				return new Cycle(begin, period);
			}
			history.put(s, i);
		}
	}

	static int multiplyMod(int numbers[], int modulo) {
		int product = 1;
		for (int number : numbers) {
			product = (int) ((long) product * number % modulo);
		}
		return product;
	}
}

class Cycle {
	int start;
	int period;

	public Cycle(int start, int period) {
		this.start = start;
		this.period = period;
	}
}

class Sierpinski {
	int cycleNum;
	int crossNum;
	int crossWithoutTopNum;

	public Sierpinski(int cycleNum, int crossNum, int crossWithoutTopNum) {
		this.cycleNum = cycleNum;
		this.crossNum = crossNum;
		this.crossWithoutTopNum = crossWithoutTopNum;
	}

	@Override
	public int hashCode() {
		return cycleNum * crossNum * crossWithoutTopNum;
	}

	@Override
	public boolean equals(Object obj) {
		Sierpinski other = (Sierpinski) obj;
		return cycleNum == other.cycleNum && crossNum == other.crossNum
				&& crossWithoutTopNum == other.crossWithoutTopNum;
	}

	Sierpinski next(int modulo) {
		int nextCycleNum = multiplyMod(
				new int[] { crossNum, crossNum, crossNum }, modulo);
		int nextCrossNum = multiplyMod(new int[] { 2, crossWithoutTopNum,
				crossNum, crossNum }, modulo);
		int nextCrossWithoutTopNum = multiplyMod(new int[] { 2,
				crossWithoutTopNum, crossWithoutTopNum, crossNum }, modulo);
		return new Sierpinski(nextCycleNum, nextCrossNum,
				nextCrossWithoutTopNum);
	}

	int multiplyMod(int numbers[], int modulo) {
		int product = 1;
		for (int number : numbers) {
			product = (int) ((long) product * number % modulo);
		}
		return product;
	}
}