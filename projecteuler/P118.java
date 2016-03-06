import java.util.HashSet;
import java.util.Iterator;

public class P118 {
	static HashSet<HashSet<Integer>> solutions = new HashSet<HashSet<Integer>>();

	public static void main(String args[]) {
		permute(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0);
		System.out.println(solutions.size());
	}

	static void permute(int permutation[], int index) {
		if (index == permutation.length) {
			split(permutation, 0, new HashSet<Integer>());
		} else {
			for (int i = index; i < permutation.length; i++) {
				if (i != index) {
					int temp = permutation[i];
					permutation[i] = permutation[index];
					permutation[index] = temp;
				}
				permute(permutation, index + 1);
				if (i != index) {
					int temp = permutation[i];
					permutation[i] = permutation[index];
					permutation[index] = temp;
				}
			}
		}
	}

	static void split(int permutation[], int index, HashSet<Integer> set) {
		if (index == permutation.length) {
			HashSet<Integer> solution = new HashSet<Integer>();
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				solution.add(iter.next());
			}
			solutions.add(solution);
			return;
		}
		int number = 0;
		for (int i = index; i < permutation.length; i++) {
			number = number * 10 + permutation[i];
			if (isPrime(number)) {
				set.add(number);
				split(permutation, i + 1, set);
				set.remove(number);
			}
		}
	}

	static boolean isPrime(int number) {
		if (number == 2) {
			return true;
		}
		if (number < 2 || number % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
