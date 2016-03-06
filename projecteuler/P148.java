public class P148 {
	public static void main(String args[]) {
		long sum = 0;
		int digits[] = new int[11];
		for (int i = 0; i < 1000000000; i++) {
			int product = 1;
			for (int j = 0; j < digits.length; j++) {
				product *= (digits[j] + 1);
			}
			sum += product;
			digits[0]++;
			for (int j = 0; j < digits.length - 1; j++) {
				if (digits[j] == 7) {
					digits[j] = 0;
					digits[j + 1]++;
				} else {
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
