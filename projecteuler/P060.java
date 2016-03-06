import java.util.ArrayList;

public class P060 {
	public static void main(String args[]) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Primes2> primes2 = new ArrayList<Primes2>();
		ArrayList<Primes3> primes3 = new ArrayList<Primes3>();
		ArrayList<Primes4> primes4 = new ArrayList<Primes4>();
		primes.add(2);
		int min1 = 2;
		int min2 = Integer.MAX_VALUE;
		int min3 = Integer.MAX_VALUE;
		int min4 = Integer.MAX_VALUE;
		int min5 = Integer.MAX_VALUE;
		int sum;
		int prime1 = -1, prime2 = -1, prime3 = -1, prime4 = -1, prime5 = -1;
		for (int i = 3;; i += 2) {
			if (i * 5 >= min5 && i * 4 + min1 >= min5 && i * 3 + min2 >= min5
					&& i * 2 + min3 >= min5 && i + min4 >= min5) {
				System.out.println("i: " + i);
				break;
			}
			boolean prime = true;
			for (int j = 0; primes.get(j) * primes.get(j) <= i; j++) {
				if (i % primes.get(j) == 0) {
					prime = false;
					break;
				}
			}
			if (!prime) {
				continue;
			}
			min4 = Integer.MAX_VALUE;
			for (int j = 0; j < primes4.size(); j++) {
				Primes4 p4 = primes4.get(j);
				sum = p4.prime1 + p4.prime2 + p4.prime3 + p4.prime4;
				if (sum >= min5) {
					primes4.remove(j);
					j--;
					continue;
				}
				min4 = Math.min(min4, sum);
				if (isValid(i, p4.prime1) && isValid(i, p4.prime2)
						&& isValid(i, p4.prime3) && isValid(i, p4.prime4)) {
					sum = p4.prime1 + p4.prime2 + p4.prime3 + p4.prime4 + i;
					if (sum < min5) {
						min5 = sum;
						prime1 = p4.prime1;
						prime2 = p4.prime2;
						prime3 = p4.prime3;
						prime4 = p4.prime4;
						prime5 = i;
						System.out.println("FOUND!!!!!! " + prime1 + ", "
								+ prime2 + ", " + prime3 + ", " + prime4 + ", "
								+ prime5);
					}
					primes4.remove(j);
					j--;
				}
			}
			min3 = Integer.MAX_VALUE;
			for (int j = 0; j < primes3.size(); j++) {
				Primes3 p3 = primes3.get(j);
				sum = p3.prime1 + p3.prime2 + p3.prime3;
				if (sum >= min5) {
					primes3.remove(j);
					j--;
					continue;
				}
				if (isValid(i, p3.prime1) && isValid(i, p3.prime2)
						&& isValid(i, p3.prime3)) {
					primes4.add(new Primes4(p3.prime1, p3.prime2, p3.prime3, i));
					min4 = Math
							.min(min4, p3.prime1 + p3.prime2 + p3.prime3 + i);
					System.out.println("Primes4: " + p3.prime1 + " "
							+ p3.prime2 + " " + p3.prime3 + " " + i + ", min4="
							+ min4);
				}
			}
			min2 = Integer.MAX_VALUE;
			for (int j = 0; j < primes2.size(); j++) {
				Primes2 p2 = primes2.get(j);
				sum = p2.prime1 + p2.prime2;
				if (sum >= min5) {
					primes2.remove(j);
					j--;
					continue;
				}
				if (isValid(i, p2.prime1) && isValid(i, p2.prime2)) {
					primes3.add(new Primes3(p2.prime1, p2.prime2, i));
					min3 = Math.min(min3, p2.prime1 + p2.prime2 + i);
				}
			}
			for (int j = 0; j < primes.size(); j++) {
				int p = primes.get(j);
				if (isValid(i, p)) {
					primes2.add(new Primes2(p, i));
					min2 = Math.min(min2, p + i);
				}
			}
			primes.add(i);
		}
		System.out.println("Answer: " + min5 + ", p1-p5: (" + prime1 + ", "
				+ prime2 + ", " + prime3 + ", " + prime4 + ", " + prime5 + ")");
	}

	static boolean isValid(int a, int b) {
		return isPrime(new Long(a + "" + b)) && isPrime(new Long(b + "" + a));
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

class Primes2 {
	int prime1;
	int prime2;

	Primes2(int thePrime1, int thePrime2) {
		this.prime1 = thePrime1;
		this.prime2 = thePrime2;
	}
}

class Primes3 {
	int prime1;
	int prime2;
	int prime3;

	Primes3(int thePrime1, int thePrime2, int thePrime3) {
		this.prime1 = thePrime1;
		this.prime2 = thePrime2;
		this.prime3 = thePrime3;
	}
}

class Primes4 {
	int prime1;
	int prime2;
	int prime3;
	int prime4;

	Primes4(int thePrime1, int thePrime2, int thePrime3, int thePrime4) {
		this.prime1 = thePrime1;
		this.prime2 = thePrime2;
		this.prime3 = thePrime3;
		this.prime4 = thePrime4;
	}
}
