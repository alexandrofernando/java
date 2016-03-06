public class P030 {
	public static void main(String args[]) {
		int sum = 0;
		for (int i = 10; i <= 354294; i++) {
			if (isValid(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static boolean isValid(int number) {
		int sum = 0;
		int n = number;
		while (n != 0) {
			int digit = n % 10;
			sum += digit * digit * digit * digit * digit;
			n /= 10;
		}
		return sum == number;
	}
}
