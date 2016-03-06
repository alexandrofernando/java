public class P174 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i <= 250000; i++) {
			int L = 0;
			for (int j = 1; j * j < i; j++) {
				if (i % j == 0) {
					L++;
				}
			}
			if (L >= 1 && L <= 10) {
				count++;
			}
		}
		System.out.println(count);
	}
}
