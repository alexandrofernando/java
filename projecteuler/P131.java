public class P131 {
	public static void main(String args[]) {
		int count = 0;
		for (int a = 1, p = 7; p < 1000000; a++, p += 6 * a) {
			if (isPrime(p)) {
				count++;
			}
		}
		System.out.println(count);
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
