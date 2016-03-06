public class P291 {
	public static void main(String args[]) {
		final int LIMIT = 50000000;
		long f[] = new long[LIMIT];
		for (int i = 1; i < f.length; i++) {
			f[i] = 2L * i * i + 2 * i + 1;
		}
		int count = 0;
		for (int i = 1; i < f.length; i++) {
			if (f[i] == 2L * i * i + 2 * i + 1) {
				count++;
			}
			if (f[i] > 1) {
				long p = f[i];
				for (long j = i; j < f.length; j += p) {
					int j1 = (int) j;
					while (f[j1] % p == 0) {
						f[j1] /= p;
					}
				}
				for (long j = p - 1 - i; j < f.length; j += p) {
					int j1 = (int) j;
					while (f[j1] % p == 0) {
						f[j1] /= p;
					}
				}
			}
		}
		System.out.println(count);
	}
}
