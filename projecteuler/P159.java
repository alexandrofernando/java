import java.util.ArrayList;

public class P159 {
	public static void main(String args[]) {
		final int LIMIT = 1000000;
		int mdrs[] = new int[LIMIT];
		mdrs[1] = 1;
		int sum = 0;
		for (int i = 2; i < mdrs.length; i++) {
			mdrs[i] = digitRoot(i);
			ArrayList<Integer> factors = findFactors(i);
			for (int j = 0; j < factors.size(); j++) {
				int factor = factors.get(j);
				mdrs[i] = Math.max(mdrs[i], digitRoot(factor)
						+ mdrs[i / factor]);
			}
			sum += mdrs[i];
		}
		System.out.println(sum);
	}

	static int digitRoot(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return (sum >= 10) ? digitRoot(sum) : sum;
	}

	static ArrayList<Integer> findFactors(int number) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
}
