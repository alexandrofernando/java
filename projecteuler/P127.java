import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class P127 {
	public static void main(String args[]) {
		final int LIMIT = 120000;
		Radical radicals[] = new Radical[LIMIT];
		Radical orderedRadicals[] = new Radical[LIMIT];
		for (int i = 0; i < radicals.length; i++) {
			radicals[i] = new Radical(i);
			orderedRadicals[i] = radicals[i];
		}
		Arrays.sort(orderedRadicals);
		int sum = 0;
		for (int c = 3; c < LIMIT; c++) {
			if (radicals[c].value == c) {
				continue;
			}
			int limit = c / (int) radicals[c].value;
			for (int index = 0; orderedRadicals[index].value < limit; index++) {
				int a = orderedRadicals[index].number;
				if (a >= c - a || gcd(c, a) != 1) {
					continue;
				}
				Radical rAC = Radical.multiply(radicals[a], radicals[c]);
				if (rAC.value >= c) {
					continue;
				}
				int b = c - a;
				if (radicals[b].value >= c) {
					continue;
				}
				Radical rABC = Radical.multiply(rAC, radicals[b]);
				if (rABC.value >= c) {
					continue;
				}
				sum += c;
			}
		}
		System.out.println(sum);
	}

	static int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}

class Radical implements Comparable<Radical> {
	int number;
	long value;
	HashSet<Integer> factors;

	Radical(int theNumber) {
		this.number = theNumber;
		this.value = 1;
		this.factors = new HashSet<Integer>();
		for (int i = 2; i * i <= theNumber; i++) {
			if (isPrime(i) && theNumber % i == 0) {
				this.value *= i;
				factors.add(i);
				while (theNumber % i == 0) {
					theNumber /= i;
				}
			}
		}
		if (theNumber > 1) {
			this.value *= theNumber;
			this.factors.add(theNumber);
		}
	}

	Radical(HashSet<Integer> theFactors) {
		this.value = 1;
		this.factors = theFactors;
		Iterator<Integer> iter = theFactors.iterator();
		while (iter.hasNext()) {
			this.value *= iter.next();
		}
	}

	boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static Radical multiply(Radical a, Radical b) {
		HashSet<Integer> resultFactors = new HashSet<Integer>();
		Iterator<Integer> iter = a.factors.iterator();
		while (iter.hasNext()) {
			resultFactors.add(iter.next());
		}
		iter = b.factors.iterator();
		while (iter.hasNext()) {
			resultFactors.add(iter.next());
		}
		return new Radical(resultFactors);
	}

	public int compareTo(Radical another) {
		if (this.value < another.value) {
			return -1;
		} else if (this.value > another.value) {
			return 1;
		} else {
			return 0;
		}
	}
}