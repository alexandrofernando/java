import java.math.BigInteger;

public class P015 {
	public static void main(String args[]) {
		BigInteger number = BigInteger.ONE;
		for (int i = 40; i > 20; i--) {
			number = number.multiply(new BigInteger(i + ""));
		}
		for (int i = 20; i > 1; i--) {
			number = number.divide(new BigInteger(i + ""));
		}
		System.out.println(number);
	}
}
