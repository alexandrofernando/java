package P1260__Pearls;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			int c = in.nextInt();
			int a[] = new int[c + 1];
			int p[] = new int[c + 1];
			int lowest[] = new int[c + 1];
			for (int i = 1; i <= c; i++) {
				a[i] = in.nextInt();
				p[i] = in.nextInt();
				int sum = 10;
				lowest[i] = Integer.MAX_VALUE;
				for (int j = i - 1; j >= 0; j--) {
					sum += a[j + 1];
					lowest[i] = Math.min(lowest[i], lowest[j] + sum * p[i]);
				}
			}
			System.out.println(lowest[c]);
		}

		in.close();
	}
}
