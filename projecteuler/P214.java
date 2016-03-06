// VM arguments: -Xms32m -Xmx800m

public class P214 {
	public static void main(String args[]) {
		final int LIMIT = 40000000;
		int totients[] = new int[LIMIT];
		int chainLengths[] = new int[LIMIT];
		chainLengths[1] = 1;
		int factors[] = new int[LIMIT];
		int indices[] = new int[LIMIT];
		long sum = 0;
		for (int i = 2; i < LIMIT; i++) {
			if (factors[i] == 0) {
				totients[i] = i - 1;
				chainLengths[i] = chainLengths[totients[i]] + 1;
				if (chainLengths[i] == 25) {
					sum += i;
				}
				int number = i * 2;
				for (int j = 2; number < LIMIT; j++, number += i) {
					if (factors[number] > 0) {
						continue;
					}
					if (j % i == 0) {
						factors[number] = i;
					} else {
						factors[number] = i - 1;
					}
					indices[number] = j;
				}
			} else {
				totients[i] = totients[indices[i]] * factors[i];
				chainLengths[i] = chainLengths[totients[i]] + 1;
			}
		}
		System.out.println(sum);
	}
}
