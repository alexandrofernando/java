public class P092 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i < 10000000; i++) {
			int number = i;
			while (number != 1 && number != 89) {
				number = calcNext(number);
			}
			if (number == 89) {
				count++;
			}
		}
		System.out.println(count);
	}

	static int calcNext(int number) {
		int next = 0;
		while (number != 0) {
			int digit = number % 10;
			next += digit * digit;
			number /= 10;
		}
		return next;
	}
}
