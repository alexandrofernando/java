import java.math.BigInteger;

public class P048 {
	public static void main(String args[]) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			BigInteger p = BigInteger.ONE;
			BigInteger bi = new BigInteger(i + "");
			for (int j = 0; j < i; j++) {
				p = p.multiply(bi);
			}
			sum = sum.add(p);
		}
		String str = sum.toString();
		System.out.println(str.substring(str.length() - 10));
	}
}
