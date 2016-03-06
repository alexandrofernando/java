import java.util.ArrayList;

public class P023 {
	public static void main(String args[]) {
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		abundants.add(12);
		boolean canWrittens[] = new boolean[28124];
		canWrittens[24] = true;
		for (int i = 13; i <= 28111; i++) {
			if (isAbundant(i)) {
				abundants.add(i);
				for (int j = 0; j < abundants.size(); j++) {
					int index = i + abundants.get(j);
					if (index >= canWrittens.length) {
						break;
					}
					canWrittens[index] = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < canWrittens.length; i++) {
			if (!canWrittens[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	static boolean isAbundant(int number) {
		int sum = 1;
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				sum += i;
				if (i != number / i) {
					sum += number / i;
				}
			}
		}
		return sum > number;
	}
}
