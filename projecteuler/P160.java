import java.util.HashMap;

public class P160 {
	static int MASK = 100000;
	static long exponents[] = new long[MASK];

	public static void main(String args[]) {
		final long N = 1000000000000L;
		for (long power2 = 1; power2 <= N; power2 *= 2) {
			for (long power5 = 1; power5 <= N; power5 *= 5) {
				long power2_5 = power2 * power5;
				if (power2_5 > N) {
					break;
				}
				handle(N / power2_5);
			}
		}
		long exponent2 = 0;
		for (long power2 = 2; power2 <= N; power2 *= 2) {
			exponent2 += N / power2;
		}
		long exponent5 = 0;
		for (long power5 = 5; power5 <= N; power5 *= 5) {
			exponent5 += N / power5;
		}
		exponents[2] = exponent2 - exponent5;
		int lastFives[] = new int[MASK];
		for (int i = 0; i < exponents.length; i++) {
			lastFives[i] = calc(i, exponents[i]);
		}
		long answer = 1;
		for (int i = 0; i < exponents.length; i++) {
			answer = answer * lastFives[i] % MASK;
		}
		System.out.println(answer);
	}

	static void handle(long limit) {
		long cycle = limit / MASK;
		long reminder = limit % MASK;
		for (int i = 0; i < exponents.length; i++) {
			int lastDigit = i % 10;
			if (lastDigit == 1 || lastDigit == 3 || lastDigit == 7
					|| lastDigit == 9) {
				exponents[i] += cycle;
			}
		}
		for (int i = 0; i <= reminder; i++) {
			int lastDigit = i % 10;
			if (lastDigit == 1 || lastDigit == 3 || lastDigit == 7
					|| lastDigit == 9) {
				exponents[i]++;
			}
		}
	}

	static int calc(int base, long power) {
		if (power == 0) {
			return 1;
		}
		int current = 1;
		HashMap<Integer, Integer> key2value = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> value2key = new HashMap<Integer, Integer>();
		for (int i = 0; i < power; i++) {
			current = (int) ((long) current * base % MASK);
			Integer pos = value2key.get(current);
			if (pos != null) {
				int prefix = pos;
				int cycle = value2key.size() - pos;
				int simplifiedPos = (int) (prefix + (power - 1 - prefix)
						% cycle);
				return key2value.get(simplifiedPos);
			}
			key2value.put(i, current);
			value2key.put(current, i);
		}
		return current;
	}
}
