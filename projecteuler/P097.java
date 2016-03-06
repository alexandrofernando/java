import java.math.BigInteger;

public class P097 {
	public static void main(String args[]) {
		BigInteger number = BigInteger.ONE;
		for (int i = 0; i < 7830457; i++) {
			number = number.multiply(new BigInteger("2")).mod(
					new BigInteger("10000000000"));
		}
		number = number.multiply(new BigInteger("28433"));
		number = number.add(BigInteger.ONE);
		String str = number.toString();
		System.out.println(str.substring(str.length() - 10));
	}
}
