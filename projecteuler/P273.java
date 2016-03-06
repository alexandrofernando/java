// VM arguments: -Xms32m -Xmx1500m
import java.util.ArrayList;

public class P273 {
	public static void main(String args[]) {
		ArrayList<Integer> primes_4k1 = new ArrayList<Integer>();
		for (int i = 5; i < 150; i += 4) {
			if (isPrime(i)) {
				primes_4k1.add(i);
			}
		}
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		for (int i = 0; i < primes_4k1.size(); i++) {
			int prime = primes_4k1.get(i);
			ArrayList<Solution> newSolutions1 = new ArrayList<Solution>();
			for (int a = 1; a * a * 2 <= prime; a++) {
				int b = (int) Math.round(Math.sqrt(prime - a * a));
				if (a * a + b * b == prime) {
					newSolutions1.add(new Solution(a, b));
				}
			}
			ArrayList<Solution> newSolutions2 = new ArrayList<Solution>();
			for (Solution s1 : solutions) {
				for (Solution s2 : newSolutions1) {
					newSolutions2.add(new Solution(Math.abs(s1.a * s2.a + s1.b
							* s2.b), Math.abs(s1.a * s2.b - s1.b * s2.a)));
					newSolutions2.add(new Solution(Math.abs(s1.a * s2.a - s1.b
							* s2.b), Math.abs(s1.a * s2.b + s1.b * s2.a)));
				}
			}
			solutions.addAll(newSolutions1);
			solutions.addAll(newSolutions2);
		}
		long answer = 0;
		for (Solution s : solutions) {
			answer += s.a;
		}
		System.out.println(answer);
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class Solution {
	long a;
	long b;

	Solution(long A, long B) {
		a = Math.min(A, B);
		b = Math.max(A, B);
	}
}
