public class P049 {
	public static void main(String args[]) {
		for (int i = 1000; i <= 9999; i++) {
			if (i == 1487 || !isPrime(i)) {
				continue;
			}
			for (int j = i + 1; j * 2 - i <= 9999; j++) {
				int k = j * 2 - i;
				if (isPrime(j) && isPrime(k) && samePermutation(i, j, k)) {
					System.out.println(i + "" + j + "" + k);
				}
			}
		}
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean samePermutation(int a, int b, int c) {
		int countA[] = count(a);
		int countB[] = count(b);
		int countC[] = count(c);
		for (int i = 0; i < 10; i++) {
			if (countA[i] != countB[i] || countA[i] != countC[i]) {
				return false;
			}
		}
		return true;
	}

	static int[] count(int number) {
		int counts[] = new int[10];
		while (number != 0) {
			counts[number % 10]++;
			number /= 10;
		}
		return counts;
	}
}
