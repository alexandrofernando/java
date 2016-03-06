import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class P203 {
	public static void main(String args[]) {
		final int LIMIT = 51;
		long coefficients[][] = new long[LIMIT][];
		coefficients[0] = new long[] { 1 };
		coefficients[1] = new long[] { 1, 1 };
		HashSet<Long> set = new HashSet<Long>();
		set.add(1L);
		long count = 1;
		for (int i = 2; i < LIMIT; i++) {
			coefficients[i] = new long[i + 1];
			coefficients[i][0] = 1;
			coefficients[i][i] = 1;
			for (int j = 1; j < i; j++) {
				coefficients[i][j] = coefficients[i - 1][j - 1]
						+ coefficients[i - 1][j];
			}
			HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
			for (int upper = i, lower = 1; upper > lower; upper--, lower++) {
				ArrayList<PrimeFactor> pfs = findPrimeFactor(upper);
				for (int j = 0; j < pfs.size(); j++) {
					PrimeFactor pf = pfs.get(j);
					Integer old = primeFactors.get(pf.base);
					if (old != null) {
						primeFactors.put(pf.base, old.intValue() + pf.exponent);
					} else {
						primeFactors.put(pf.base, pf.exponent);
					}
				}
				pfs = findPrimeFactor(lower);
				for (int j = 0; j < pfs.size(); j++) {
					PrimeFactor pf = pfs.get(j);
					primeFactors.put(pf.base, primeFactors.get(pf.base)
							- pf.exponent);
				}
				if (!containPrimeSquare(primeFactors)
						&& !set.contains(coefficients[i][lower])) {
					count += coefficients[i][lower];
					set.add(coefficients[i][lower]);
				}
			}
		}
		System.out.println(count);
	}

	static ArrayList<PrimeFactor> findPrimeFactor(int number) {
		ArrayList<PrimeFactor> pfs = new ArrayList<PrimeFactor>();
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i) && number % i == 0) {
				int count = 0;
				while (number % i == 0) {
					count++;
					number /= i;
				}
				pfs.add(new PrimeFactor(i, count));
			}
		}
		if (number > 1) {
			pfs.add(new PrimeFactor(number, 1));
		}
		return pfs;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean containPrimeSquare(HashMap<Integer, Integer> primeFactors) {
		Iterator<Entry<Integer, Integer>> iter = primeFactors.entrySet()
				.iterator();
		while (iter.hasNext()) {
			if (iter.next().getValue() >= 2) {
				return true;
			}
		}
		return false;
	}
}

class PrimeFactor {
	int base;
	int exponent;

	PrimeFactor(int theBase, int theExponent) {
		this.base = theBase;
		this.exponent = theExponent;
	}
}