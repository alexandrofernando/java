import java.util.ArrayList;

public class P271 {
	static final long M = 13082761331670030L;
	static int primes[] = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
			37, 41, 43 };
	@SuppressWarnings("unchecked")
	static ArrayList<Integer> roots[] = new ArrayList[primes.length];
	static int indices[] = new int[primes.length];
	static long sum = 0;

	public static void main(String args[]) {
		for (int i = 0; i < primes.length; i++) {
			roots[i] = new ArrayList<Integer>();
			for (int r = 1; r <= primes[i]; r++) {
				if (r * r * r % primes[i] == 1) {
					roots[i].add(r);
				}
			}
		}
		search(0);
		System.out.println(sum - 1);
	}

	static void search(int depth) {
		if (depth == primes.length) {
			long x = 0;
			for (int i = 0; i < primes.length; i++) {
				long mi = M / primes[i];
				x += roots[i].get(indices[i]) * mi * extendGCD(mi, primes[i]);
			}
			while (x < 0) {
				x += M;
			}
			while (x >= M) {
				x -= M;
			}
			sum += x;
			return;
		}
		for (int i = 0; i < roots[depth].size(); i++) {
			indices[depth] = i;
			search(depth + 1);
		}
	}

	static long extendGCD(long a, long b) {
		long x = 0;
		long y = 1;
		long lastX = 1;
		long lastY = 0;
		while (b != 0) {
			long c = a / b;
			long temp = a;
			a = b;
			b = temp % b;

			temp = x;
			x = lastX - c * x;
			lastX = temp;

			temp = y;
			y = lastY - c * y;
			lastY = temp;
		}
		return lastX;
	}
}
