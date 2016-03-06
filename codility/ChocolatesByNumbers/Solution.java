package ChocolatesByNumbers;

// https://codility.com/demo/results/demoN4FU5P-VU4/

public class Solution {
	public int solution(int N, int M) {
		return (int) (lcm(N, M) / M);
	}

	long lcm(int a, int b) {
		return (long) a * b / gcd(a, b);
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
