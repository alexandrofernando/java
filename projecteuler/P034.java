public class P034 {
	public static void main(String args[]) {
		int sum = 0;
		for (int i = 3; i <= 2540160; i++) {
			if (isValid(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static boolean isValid(int number) {
		int factorials[] = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320,
				362880 };
		int sum = 0;
		int p = number;
		while (p != 0) {
			sum += factorials[p % 10];
			p /= 10;
		}
		return number == sum;
	}
}
