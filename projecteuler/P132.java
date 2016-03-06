public class P132 {
	public static void main(String args[]) {
		int number = 7;
		int sum = 0;
		for (int i = 0; i < 40;) {
			if (isPrime(number)) {
				int p = period(number);
				if (1000000000 % p == 0) {
					sum += number;
					i++;
				}
			}
			number += 2;
		}
		System.out.println(sum);
	}

	static boolean isPrime(int number) {
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int period(int number) {
		boolean visited[] = new boolean[number];
		int p = 0;
		int reminder = 1;
		while (!visited[reminder]) {
			visited[reminder] = true;
			p++;
			reminder = reminder * 10 % number;
		}
		return p;
	}
}
