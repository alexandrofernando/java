package P2774__Long_Long_Message;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();

		int num[] = new int[str1.length() + str2.length() + 2];
		for (int i = 0; i < str1.length(); i++) {
			num[i] = str1.charAt(i) - 'a' + 2;
		}
		num[str1.length()] = 1;
		for (int i = str1.length() + 1; i < str1.length() + 1 + str2.length(); i++) {
			num[i] = str2.charAt(i - str1.length() - 1) - 'a' + 2;
		}
		num[str1.length() + str2.length() + 1] = 0;

		int sa[] = doublingAlgorithm(num, 'z' - 'a' + 3);
		int height[] = calcHeight(num, sa);

		int answer = 0;
		for (int i = 1; i < sa.length; i++) {
			if (Math.signum(sa[i] - str1.length())
					* Math.signum(sa[i - 1] - str1.length()) < 0) {
				answer = Math.max(answer, height[i]);
			}
		}
		System.out.println(answer);

		in.close();
	}

	static int[] doublingAlgorithm(int r[], int m) {
		int sa[] = new int[r.length];
		int wd[] = new int[m];
		int x[] = new int[r.length];
		int y[] = new int[r.length];
		for (int i = 0; i < r.length; i++) {
			x[i] = r[i];
			wd[x[i]]++;
		}
		for (int i = 1; i < m; i++) {
			wd[i] += wd[i - 1];
		}
		for (int i = r.length - 1; i >= 0; i--) {
			wd[x[i]]--;
			sa[wd[x[i]]] = i;
		}

		int j = 1;
		int p = 1;
		while (p < r.length) {
			p = 0;
			for (int i = r.length - j; i < r.length; i++) {
				y[p] = i;
				p++;
			}
			for (int i = 0; i < r.length; i++) {
				if (sa[i] >= j) {
					y[p] = sa[i] - j;
					p++;
				}
			}

			wd = new int[m];
			int wv[] = new int[r.length];
			for (int i = 0; i < r.length; i++) {
				wv[i] = x[y[i]];
				wd[wv[i]]++;
			}
			for (int i = 1; i < m; i++) {
				wd[i] += wd[i - 1];
			}
			for (int i = r.length - 1; i >= 0; i--) {
				wd[wv[i]]--;
				sa[wd[wv[i]]] = y[i];
			}
			int t[] = x;
			x = y;
			y = t;
			p = 1;
			x[sa[0]] = 0;
			for (int i = 1; i < r.length; i++) {
				if (isEqual(y, sa[i - 1], sa[i], j)) {
					x[sa[i]] = p - 1;
				} else {
					x[sa[i]] = p;
					p++;
				}
			}

			j *= 2;
			m = p;
		}
		return sa;
	}

	static boolean isEqual(int r[], int a, int b, int l) {
		return r[a] == r[b] && r[a + l] == r[b + l];
	}

	static int[] calcHeight(int r[], int sa[]) {
		int rank[] = new int[r.length];
		for (int i = 0; i < r.length; i++) {
			rank[sa[i]] = i;
		}
		int k = 0;
		int height[] = new int[r.length];
		for (int i = 0; i < r.length - 1; i++) {
			if (k > 0) {
				k--;
			}
			int j = sa[rank[i] - 1];
			while (r[i + k] == r[j + k]) {
				k++;
			}
			height[rank[i]] = k;
		}
		return height;
	}
}
