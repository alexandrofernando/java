import java.math.BigInteger;

public class P218 {
	public static void main(String args[]) {
		final int LIMIT = 100000000;
		int count = 0;
		for (int s = 1; s * s <= LIMIT; s++) {
			for (int t = 1; t < s && s * s + t * t <= LIMIT; t++) {
				int p = s * s - t * t;
				int q = 2 * s * t;
				if (p < 0 || q < 0) {
					System.out.println("error");
					System.exit(0);
				}
				long a = (long) p * p - (long) q * q;
				if (a < 0) {
					a = -a;
				}
				long b = 2L * p * q;
				BigInteger area = new BigInteger(a + "").multiply(
						new BigInteger(b + "")).divide(new BigInteger("2"));
				if (area.mod(new BigInteger("6")).compareTo(BigInteger.ZERO) != 0
						|| area.mod(new BigInteger("28")).compareTo(
								BigInteger.ZERO) != 0) {
					count++;
					System.out.println(count);
				}
			}
		}
		System.out.println(count);
	}
}
