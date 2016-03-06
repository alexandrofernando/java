package FindThree;

// Helium 2013
// https://codility.com/demo/results/demoN2KANW-B2E/

public class Solution {
	public int solution(String S) {
		int n = S.length();
		if (n < 3) {
			return 0;
		}

		int[] p = new int[n];
		int left = -1;
		int right = -1;
		for (int i = 1; i < n; i++) {
			if (i > right) {
				int matchLen = 0;
				while (i + matchLen < n
						&& S.charAt(matchLen) == S.charAt(i + matchLen)) {
					matchLen++;
				}
				if (matchLen > 0) {
					p[i] = matchLen;
					left = i;
					right = i + matchLen - 1;
				}
			} else if (p[i - left] >= right - i + 1) {
				int nextRight = right + 1;
				while (nextRight < n
						&& S.charAt(nextRight - i) == S.charAt(nextRight)) {
					nextRight++;
				}
				nextRight--;
				p[i] = nextRight - i + 1;
				left = i;
				right = nextRight;
			} else {
				p[i] = p[i - left];
			}
		}

		int len = n / 3;
		int m = 0;
		int upper = n - len * 2;
		for (int i = len; i <= upper; i++) {
			m = Math.max(m, p[i]);
		}
		while (true) {
			if (m >= len && p[n - len] == len) {
				break;
			}
			len--;
			if (len == 0) {
				break;
			}
			m = Math.max(m, p[len]);
			m = Math.max(m, p[upper + 1]);
			m = Math.max(m, p[upper + 2]);
			upper += 2;
		}
		return len;
	}
}
