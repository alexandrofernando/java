import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class P231 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String args[]) {
		primes.add(2);
		for (int i = 3; i <= 20000000; i += 2) {
			boolean isPrime = true;
			for (int j = 0; j < primes.size(); j++) {
				int prime = primes.get(j);
				if (prime * prime > i) {
					break;
				}
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
		for (int upper = 20000000, lower = 1; lower <= 5000000; upper--, lower++) {
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
		}
		long sum = 0;
		Iterator<Entry<Integer, Integer>> iter = primeFactors.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			sum += entry.getKey() * entry.getValue();
		}
		System.out.println(sum);
	}

	static ArrayList<PrimeFactor> findPrimeFactor(int number) {
		ArrayList<PrimeFactor> pfs = new ArrayList<PrimeFactor>();
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (prime * prime > number) {
				break;
			}
			if (number % prime == 0) {
				int count = 0;
				while (number % prime == 0) {
					count++;
					number /= prime;
				}
				pfs.add(new PrimeFactor(prime, count));
			}
		}
		if (number > 1) {
			pfs.add(new PrimeFactor(number, 1));
		}
		return pfs;
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
