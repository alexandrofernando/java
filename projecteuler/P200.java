import java.util.ArrayList;
import java.util.PriorityQueue;

public class P200 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String args[]) {
		final int LIMIT = 200;
		primes.add(2);
		primes.add(3);
		int rest = LIMIT;
		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		pq.add(new Element(2, 3));
		pq.add(new Element(3, 2));
		while (rest > 0) {
			Element e = pq.poll();
			if ((e.number + "").contains("200") && isPrimeProof(e.number + "")) {
				rest--;
				if (rest == 0) {
					System.out.println(e.number);
				}
			}
			int r = nextPrime(e.q);
			if (r == e.p) {
				pq.add(new Element(e.p, nextPrime(e.p)));
			} else {
				pq.add(new Element(e.p, r));
			}
			if (e.q == 2) {
				pq.add(new Element(nextPrime(e.p), 2));
			}
		}
	}

	static boolean isPrimeProof(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int digit = 0; digit <= 9; digit++) {
				String number = str.substring(0, i) + digit
						+ str.substring(i + 1);
				if (isPrime(Long.valueOf(number))) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int nextPrime(int p) {
		int index = primes.indexOf(p);
		if (index + 1 < primes.size()) {
			return primes.get(index + 1);
		}
		for (int n = primes.get(primes.size() - 1) + 2;; n += 2) {
			boolean isPrime = true;
			for (int i = 0; i < primes.size(); i++) {
				int prime = primes.get(i);
				if (prime * prime > n) {
					break;
				}
				if (n % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(n);
				return n;
			}
		}
	}
}

class Element implements Comparable<Element> {
	int p;
	int q;
	long number;

	Element(int P, int Q) {
		this.p = P;
		this.q = Q;
		this.number = (long) P * P * Q * Q * Q;
	}

	public int compareTo(Element another) {
		if (this.number < another.number) {
			return -1;
		} else if (this.number > another.number) {
			return 1;
		} else {
			return 0;
		}
	}
}