public class P072 {
	public static void main(String args[]) {
		long answer = 0;
		for (int d = 2; d <= 1000000; d++) {
			int phi = 1;
			int temp = d;
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
			answer += phi;
		}
		System.out.println(answer);
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
