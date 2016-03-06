import java.util.ArrayList;

public class P077 {
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> zero = new ArrayList<Integer>();
		zero.add(0);
		ways.add(zero);
		for (int i = 1;; i++) {
			ArrayList<Integer> w = new ArrayList<Integer>();
			w.add(0);
			for (int j = 1; j <= i; j++) {
				int w_j = w.get(j - 1);
				if (isPrime(j)) {
					for (int k = 1; k * j <= i; k++) {
						w_j += ways.get(i - k * j).get(
								Math.min(j - 1, i - k * j));
						if (k * j == i) {
							w_j++;
						}
					}
				}
				w.add(w_j);
			}
			int temp = w.get(i);
			if (isPrime(i)) {
				temp--;
			}
			if (temp > 5000) {
				System.out.println(i);
				break;
			}
			ways.add(w);
		}
	}

	static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
