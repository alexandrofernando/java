public class P301 {
	public static void main(String args[]) {
		int count = 0;
		for (int n = 1; n <= 1 << 30; n++) {
			long a = n;
			long b = (long) n * 2;
			long c = (long) n * 3;
			boolean win = false;
			while (c != 0) {
				if (((a + b + c) & 1) == 1) {
					win = true;
					break;
				}
				a >>= 1;
				b >>= 1;
				c >>= 1;
			}
			if (!win) {
				count++;
			}
		}
		System.out.println(count);
	}
}
