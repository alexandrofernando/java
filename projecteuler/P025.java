import java.math.BigInteger;

public class P025 {
	public static void main(String args[]) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		for (int i = 3;; i++) {
			BigInteger c = a.add(b);
			if (c.toString().length() >= 1000) {
				System.out.println(i);
				break;
			}
			a = b;
			b = c;
		}
	}
}
