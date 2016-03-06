package P1276__Cash_Machine;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt() == true) {
			int cash = in.nextInt();
			boolean visited[] = new boolean[cash + 1];
			int N = in.nextInt();
			int numbers[] = new int[N];
			int denominations[] = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = in.nextInt();
				denominations[i] = in.nextInt();
			}
			ArrayList<Integer> amounts = new ArrayList<Integer>();
			visited[0] = true;
			amounts.add(0);
			boolean exact = false;
			for (int i = 0; i < N; i++) {
				int size = amounts.size();
				for (int j = 0; j < size; j++) {
					int temp = amounts.get(j);
					for (int k = 0; k <= numbers[i]; k++) {
						int total = temp + k * denominations[i];
						if (total > cash) {
							break;
						}
						if (visited[total] == false) {
							visited[total] = true;
							amounts.add(total);
							if (total == cash) {
								exact = true;
								break;
							}
						}
					}
					if (exact == true) {
						break;
					}
				}
				if (exact == true) {
					break;
				}
			}
			int result = cash;
			while (visited[result] == false) {
				result--;
			}
			System.out.println(result);
		}
	}
}
