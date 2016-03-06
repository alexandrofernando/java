public class P070 {
	public static void main(String args[]) {
		int minN = Integer.MAX_VALUE;
		int minPhi = 1;
		for (int n = 2; n < 10000000; n++) {
			System.out.println(n);
			int phi = 1;
			int temp = n;
			for (int i = 2; i * i <= temp; i++) {
				if (isPrime(i) && temp % i == 0) {
					int count = 0;
					while (temp % i == 0) {
						count++;
						temp /= i;
					}
					phi *= i - 1;
					for (int j = 0; j < count - 1; j++) {
						phi *= i;
					}
				}
			}
			if (temp > 1) {
				phi *= temp - 1;
			}
			if (sameDigits(n, phi) && (long) n * minPhi < (long) minN * phi) {
				minN = n;
				minPhi = phi;
			}
		}
		System.out.println(minN);
	}

	static boolean sameDigits(int a, int b) {
		int digitsA[] = getDigits(a);
		int digitsB[] = getDigits(b);
		for (int i = 0; i < 10; i++) {
			if (digitsA[i] != digitsB[i]) {
				return false;
			}
		}
		return true;
	}

	static int[] getDigits(int number) {
		int digits[] = new int[10];
		while (number != 0) {
			digits[number % 10]++;
			number /= 10;
		}
		return digits;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
