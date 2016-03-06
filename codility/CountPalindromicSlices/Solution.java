package CountPalindromicSlices;

// Gamma 2011
// http://codility.com/demo/results/demoXPED58-KJP/

public class Solution {
	public int solution(String S) {
		final char SEPARATOR = '#';
		final int LIMIT = 100000000;

		StringBuilder sb = new StringBuilder();
		sb.append(SEPARATOR);
		for (int i = 0; i < S.length(); i++) {
			sb.append(S.charAt(i));
			sb.append(SEPARATOR);
		}

		int[] p = new int[sb.length()];
		int maxStart = -1;
		int maxCenter = -1;
		for (int i = 0; i < p.length; i++) {
			if (maxStart > i) {
				p[i] = Math.min(p[maxCenter * 2 - i], maxStart - i);
			} else {
				p[i] = 1;
			}
			while (i - p[i] >= 0 && i + p[i] < sb.length()
					&& sb.charAt(i - p[i]) == sb.charAt(i + p[i])) {
				p[i]++;
			}
			if (i + p[i] > maxStart) {
				maxStart = i + p[i];
				maxCenter = i;
			}
		}

		int result = 0;
		for (int i = 0; i < p.length; i++) {
			result += (p[i] - 1) / 2;
			if (result > LIMIT) {
				return -1;
			}
		}
		return result;
	}
}
