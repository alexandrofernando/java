import java.math.BigInteger;
import java.util.HashMap;

public class P169 {
	static HashMap<BigInteger, Long> history = new HashMap<BigInteger, Long>();

	public static void main(String args[]) {
		BigInteger number = BigInteger.ONE;
		for (int i = 0; i < 25; i++) {
			number = number.multiply(new BigInteger("10"));
		}
		long F = search(number);
		System.out.println(F);
	}

	static long search(BigInteger number) {
		if (number.compareTo(BigInteger.ZERO) == 0) {
			return 1;
		}
		Long way = history.get(number);
		if (way != null) {
			return way;
		}
		BigInteger bi2 = new BigInteger("2");
		long ret;
		if (number.mod(bi2).compareTo(BigInteger.ONE) == 0) {
			ret = search(number.divide(bi2));
		} else {
			ret = search(number.divide(bi2))
					+ search(number.divide(bi2).subtract(BigInteger.ONE));
		}
		history.put(number, ret);
		return ret;
	}
}
