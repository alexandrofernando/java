public class P158 {
	public static void main(String args[]) {
		int power2[] = new int[25];
		power2[0] = 1;
		for (int i = 1; i < power2.length; i++) {
			power2[i] = power2[i - 1] << 1;
		}
		long max = -1;
		for (int n = 2; n <= 26; n++) {
			long p = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					p += power2[j - i - 1];
				}
			}
			p *= C(26, n);
			max = Math.max(max, p);
		}
		System.out.println(max);
	}

	static long C(int m, int n) {
		if (n + n > m) {
			return C(m, m - n);
		}
		long result = 1;
		for (int i = m; i > m - n; i--) {
			result *= i;
		}
		for (int i = 1; i <= n; i++) {
			result /= i;
		}
		return result;
	}
}
