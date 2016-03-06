import java.math.BigInteger;

public class P020 {
	public static void main(String args[]) {
		BigInteger product = BigInteger.ONE;
		for (int i = 2; i <= 100; i++) {
			product = product.multiply(new BigInteger(i + ""));
		}
		String str = product.toString();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
