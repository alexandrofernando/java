public class P021 {
	public static void main(String args[]) {
		boolean isAmicable[] = new boolean[10000];
		int sum = 0;
		for (int i = 1; i < 10000; i++) {
			if (isAmicable[i]) {
				sum += i;
				continue;
			}
			int di = D(i);
			if (di <= i) {
				continue;
			}
			int ddi = D(di);
			if (ddi == i) {
				isAmicable[i] = true;
				isAmicable[di] = true;
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static int D(int number) {
		int sum = 1;
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				sum += i;
				if (i != number / i) {
					sum += number / i;
				}
			}
		}
		return sum;
	}
}
