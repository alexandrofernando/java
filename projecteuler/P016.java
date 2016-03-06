import java.math.BigInteger;

public class P016 {
	public static void main(String args[]) {
		BigInteger number = BigInteger.ONE;
		for (int i = 0; i < 1000; i++) {
			number = number.multiply(new BigInteger("2"));
		}
		String str = number.toString();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
