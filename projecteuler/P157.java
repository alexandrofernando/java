public class P157 {
	public static void main(String args[]) {
		int count = 0;
		int power10 = 10;
		for (int n = 1; n <= 9; n++) {
			int power2 = 1;
			for (int i = 0; i <= n; i++) {
				int power5 = 1;
				for (int j = 0; j <= n; j++) {
					count += solutionNum(1, power2 * power5, power10);
					power5 *= 5;
				}
				power2 *= 2;
			}
			power2 = 2;
			for (int i = 1; i <= n; i++) {
				int power5 = 5;
				for (int j = 1; j <= n; j++) {
					count += solutionNum(power2, power5, power10);
					power5 *= 5;
				}
				power2 *= 2;
			}
			power10 *= 10;
		}
		System.out.println(count);
	}

	static int solutionNum(int a, int b, int power10) {
		int p = power10 / a / b * (a + b);
		int divisorNum = 1;
		for (int i = 2; i * i <= p; i++) {
			int count = 0;
			while (p % i == 0) {
				p /= i;
				count++;
			}
			divisorNum *= (count + 1);
		}
		if (p > 1) {
			divisorNum *= 2;
		}
		return divisorNum;
	}
}
