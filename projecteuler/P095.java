import java.util.ArrayList;

public class P095 {
	public static void main(String args[]) {
		final int LIMIT = 1000000;
		int lengths[] = new int[LIMIT + 1];
		for (int i = 1; i <= LIMIT; i++) {
			if (lengths[i] != 0) {
				continue;
			}
			ArrayList<Integer> chain = new ArrayList<Integer>();
			chain.add(i);
			int number = i;
			while (true) {
				ArrayList<PrimeDivisor> pds = findPrimeDivisors(number);
				int sum = sumDivisor(pds, 0, 1) - number;
				if (sum > LIMIT || lengths[sum] != 0) {
					for (int j = 0; j < chain.size(); j++) {
						lengths[chain.get(j)] = -1;
					}
					break;
				}
				int head = chain.indexOf(sum);
				if (head != -1) {
					for (int j = 0; j < head; j++) {
						lengths[chain.get(j)] = -1;
					}
					for (int j = head; j < chain.size(); j++) {
						lengths[chain.get(j)] = chain.size() - head;
					}
					break;
				}
				chain.add(sum);
				number = sum;
			}
		}
		int maxLength = -1;
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i < lengths.length; i++) {
			if (lengths[i] > maxLength) {
				maxLength = lengths[i];
				answer = i;
			}
		}
		System.out.println(answer);
	}

	static ArrayList<PrimeDivisor> findPrimeDivisors(int number) {
		ArrayList<PrimeDivisor> pds = new ArrayList<PrimeDivisor>();
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i) && number % i == 0) {
				int count = 0;
				while (number % i == 0) {
					number /= i;
					count++;
				}
				pds.add(new PrimeDivisor(i, count));
			}
		}
		if (number > 1) {
			pds.add(new PrimeDivisor(number, 1));
		}
		return pds;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int sumDivisor(ArrayList<PrimeDivisor> pds, int index, int curDivisor) {
		if (index == pds.size()) {
			return curDivisor;
		}
		int sum = 0;
		int temp = 1;
		for (int i = 0; i <= pds.get(index).exponent; i++) {
			sum += sumDivisor(pds, index + 1, curDivisor * temp);
			temp *= pds.get(index).prime;
		}
		return sum;
	}
}

class PrimeDivisor {
	int prime;
	int exponent;

	PrimeDivisor(int thePrime, int theExponent) {
		this.prime = thePrime;
		this.exponent = theExponent;
	}
}