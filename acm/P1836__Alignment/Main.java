package P1836__Alignment;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double heights[] = new double[n];
		for (int i = 0; i < n; i++) {
			heights[i] = in.nextDouble();
		}

		int leftNums[] = new int[n];
		for (int i = 0; i < n; i++) {
			leftNums[i] = 1;
			for (int j = 0; j < i; j++) {
				if (heights[i] > heights[j]) {
					leftNums[i] = Math.max(leftNums[i], leftNums[j] + 1);
				}
			}
		}
		int rightNums[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			rightNums[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (heights[i] > heights[j]) {
					rightNums[i] = Math.max(rightNums[i], rightNums[j] + 1);
				}
			}
		}
		int maxNum = 2;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				maxNum = Math.max(maxNum, leftNums[i] + rightNums[j]);
			}
		}
		System.out.println(n - maxNum);

		in.close();
	}
}
