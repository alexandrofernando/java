package P1961__Period;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = 1;
		while (true) {
			int N = in.nextInt();
			if (N == 0) {
				break;
			}
			String S = in.next();
			if (test > 1) {
				System.out.println();
			}
			System.out.println("Test case #" + test);
			test++;
			int next[] = new int[S.length()];
			next[0] = -1;
			int pos = -1;
			for (int i = 1; i < S.length(); i++) {
				while (pos >= 0 && S.charAt(pos + 1) != S.charAt(i)) {
					pos = next[pos];
				}
				if (S.charAt(pos + 1) == S.charAt(i)) {
					pos++;
				}
				next[i] = pos;
			}
			for (int i = 1; i < S.length(); i++) {
				if ((i + 1) % (i - next[i]) == 0 && next[i] != -1) {
					int times = (i + 1) / (i - next[i]);
					System.out.println((i + 1) + " " + times);
				}
			}
		}
	}
}
