import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P248 {
	static final long TARGET = factorial(13);
	static HashSet<Long> resultSet = new HashSet<Long>();
	static ArrayList<Long> primeArray;

	public static void main(String args[]) {
		HashSet<Long> primeSet = new HashSet<Long>();
		final int POSITION = 150000;
		primeSet.add(2L);
		primeSet.add(3L);
		primeSet.add(5L);
		primeSet.add(7L);
		primeSet.add(11L);
		primeSet.add(13L);
		for (long i = 1; i * i <= TARGET; i++) {
			if (TARGET % i == 0) {
				long numbers[] = new long[] { i + 1, TARGET / i + 1 };
				for (long number : numbers) {
					if (isPrime(number)) {
						primeSet.add(number);
					}
				}
			}
		}
		primeArray = new ArrayList<Long>(primeSet);
		Collections.sort(primeArray);
		search(1, 1, 0);
		ArrayList<Long> resultArray = new ArrayList<Long>(resultSet);
		Collections.sort(resultArray);
		System.out.println(resultArray.get(POSITION - 1));
	}

	static void search(long n, long phi, int index) {
		if (index == primeArray.size()) {
			return;
		}
		if (phi == TARGET) {
			resultSet.add(n);
			return;
		}
		long prime = primeArray.get(index);
		long nextPhi;
		if (n % prime == 0) {
			nextPhi = phi * prime;
		} else {
			nextPhi = phi * (prime - 1);
		}
		if (nextPhi > TARGET) {
			return;
		}
		if (TARGET % nextPhi == 0) {
			search(n * prime, nextPhi, index);
		}
		search(n, phi, index + 1);
	}

	static long factorial(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	static boolean isPrime(long number) {
		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
