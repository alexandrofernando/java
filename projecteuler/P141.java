import java.util.HashSet;
import java.util.Iterator;

public class P141 {
	public static void main(String args[]) {
		HashSet<Long> solutions = new HashSet<Long>();
		final long LIMIT = 1000000000000L;
		for (long v = 1; v * v * v * v + v * v < LIMIT; v++) {
			for (long u = v + 1; u * u * u * v + v * v < LIMIT; u++) {
				if (gcd(u, v) != 1) {
					continue;
				}
				for (long k = 1; u * u * u * v * k * k + v * v * k < LIMIT; k++) {
					long a = v * v * k;
					long b = u * v * k;
					long c = u * u * k;
					long n = b * c + a;
					if (isSquare(n)) {
						solutions.add(n);
					}
				}
			}
		}
		long sum = 0;
		Iterator<Long> iter = solutions.iterator();
		while (iter.hasNext()) {
			sum += iter.next();
		}
		System.out.println(sum);
	}

	static long gcd(long a, long b) {
		while (a % b != 0) {
			long c = a % b;
			a = b;
			b = c;
		}
		return b;
	}

	static boolean isSquare(long number) {
		long root = (long) Math.round(Math.sqrt(number));
		return root * root == number;
	}
}
