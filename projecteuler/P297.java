import java.math.BigInteger;
import java.util.ArrayList;

public class P297 {
	static ArrayList<BigInteger> fibonacci = new ArrayList<BigInteger>();
	static ArrayList<BigInteger> sums = new ArrayList<BigInteger>();

	public static void main(String args[]) {
		final BigInteger LIMIT = new BigInteger("99999999999999999");
		fibonacci.add(BigInteger.ONE);
		fibonacci.add(new BigInteger("2"));
		while (true) {
			BigInteger next = fibonacci.get(fibonacci.size() - 2).add(
					fibonacci.get(fibonacci.size() - 1));
			if (next.compareTo(LIMIT) > 0) {
				break;
			}
			fibonacci.add(next);
		}
		sums.add(BigInteger.ONE);
		sums.add(new BigInteger("2"));
		for (int i = 2; i < fibonacci.size(); i++) {
			BigInteger sum = sums.get(i - 1).add(sums.get(i - 2))
					.add(fibonacci.get(i - 2)).subtract(BigInteger.ONE);
			sums.add(sum);
		}
		System.out.println(sumZ(LIMIT));
	}

	static BigInteger sumZ(BigInteger n) {
		int pos = -1;
		for (int i = fibonacci.size() - 1; i >= 0; i--) {
			if (fibonacci.get(i).compareTo(n) == 0) {
				return sums.get(i);
			}
			if (fibonacci.get(i).compareTo(n) < 0) {
				pos = i;
				break;
			}
		}
		BigInteger diff = n.subtract(fibonacci.get(pos));
		return sums.get(pos).add(sumZ(diff)).add(diff);
	}
}
