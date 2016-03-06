import java.math.BigInteger;

public class P056 {
	public static void main(String args[]) {
		int max = -1;
		for (int a = 1; a < 100; a++) {
			BigInteger number = BigInteger.ONE;
			BigInteger biA = new BigInteger(a + "");
			for (int b = 1; b < 100; b++) {
				number = number.multiply(biA);
				max = Math.max(max, getDigitSum(number.toString()));
			}
		}
		System.out.println(max);
	}

	static int getDigitSum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		return sum;
	}
}
