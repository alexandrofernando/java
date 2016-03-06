package CommonPrimeDivisors;

// https://codility.com/demo/results/demoF3KFQW-JW8/

public class Solution {
	public int solution(int[] A, int[] B) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			if (primeDivisorsIncluded(A[i], B[i])
					&& primeDivisorsIncluded(B[i], A[i])) {
				result++;
			}
		}
		return result;
	}

	boolean primeDivisorsIncluded(int a, int b) {
		while (true) {
			int common = gcd(a, b);
			if (common == 1) {
				return a == 1;
			}
			a /= common;
		}
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
