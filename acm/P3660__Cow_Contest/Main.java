package P3660__Cow_Contest;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int cowNum = in.nextInt();
		int roundNum = in.nextInt();
		boolean less[][] = new boolean[cowNum][cowNum];
		for (int round = 0; round < roundNum; round++) {
			int winner = in.nextInt() - 1;
			int loser = in.nextInt() - 1;
			less[loser][winner] = true;
		}
		for (int j = 0; j < cowNum; j++) {
			for (int i = 0; i < cowNum; i++) {
				if (less[i][j]) {
					for (int k = 0; k < cowNum; k++) {
						less[i][k] = less[i][k] || less[j][k];
					}
				}
			}
		}
		int determined = 0;
		for (int i = 0; i < cowNum; i++) {
			int count = 0;
			for (int j = 0; j < cowNum; j++) {
				if (less[i][j]) {
					count++;
				}
				if (less[j][i]) {
					count++;
				}
			}
			if (count + 1 == cowNum) {
				determined++;
			}
		}
		System.out.println(determined);
	}
}
