// VM arguments: -Xms32m -Xmx800m

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P266 {
	public static void main(String args[]) {
		final int LIMIT = 190;
		ArrayList<Integer> primes = sievePrimes(LIMIT);
		BigInteger product = BigInteger.ONE;
		for (int prime : primes) {
			product = product.multiply(new BigInteger(prime + ""));
		}
		BigInteger sqrt = sqrtInt(product);
		ArrayList<BigInteger> productSet1 = combine(primes, 0,
				primes.size() / 2);
		ArrayList<BigInteger> productSet2 = combine(primes, primes.size() / 2,
				primes.size());
		Collections.sort(productSet1);
		Collections.sort(productSet2);
		int index1 = 0;
		int index2 = productSet2.size() - 1;
		BigInteger psr = BigInteger.ONE;
		do {
			BigInteger current = productSet1.get(index1).multiply(
					productSet2.get(index2));
			if (current.compareTo(sqrt) > 0) {
				index2--;
			} else {
				if (current.compareTo(psr) > 0) {
					psr = current;
				}
				index1++;
			}
		} while (index1 < productSet1.size() && index2 >= 0);
		System.out.println(psr.mod(new BigInteger("10000000000000000")));
	}

	static ArrayList<BigInteger> combine(ArrayList<Integer> primes, int begin,
			int end) {
		ArrayList<BigInteger> productSet = new ArrayList<BigInteger>();
		productSet.add(BigInteger.ONE);
		for (int i = begin; i < end; i++) {
			BigInteger prime = new BigInteger(primes.get(i) + "");
			ArrayList<BigInteger> added = new ArrayList<BigInteger>();
			for (BigInteger product : productSet) {
				added.add(product.multiply(prime));
			}
			productSet.addAll(added);
		}
		return productSet;
	}

	static ArrayList<Integer> sievePrimes(int limit) {
		boolean primes[] = new boolean[limit];
		Arrays.fill(primes, true);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				result.add(i);
				for (int j = i + i; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}
		return result;
	}

	static BigInteger sqrtInt(BigInteger number) {
		BigInteger x = BigInteger.ONE;
		while (true) {
			BigInteger nextX = x.add(number.divide(x)).divide(
					new BigInteger("2"));
			if (nextX.compareTo(x) == 0) {
				break;
			}
			x = nextX;
		}
		while (x.multiply(x).compareTo(number) <= 0) {
			x = x.add(BigInteger.ONE);
		}
		while (x.multiply(x).compareTo(number) > 0) {
			x = x.subtract(BigInteger.ONE);
		}
		return x;
	}
}
