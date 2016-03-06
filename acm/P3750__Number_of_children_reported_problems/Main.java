package P3750__Number_of_children_reported_problems;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int childNum = in.nextInt();
		in.nextLine();

		LinkedList<String> circle = new LinkedList<String>();
		for (int i = 0; i < childNum; i++) {
			circle.add(in.nextLine());
		}
		String str[] = in.next().split(",");
		int W = Integer.parseInt(str[0]);
		int S = Integer.parseInt(str[1]);

		int current = W - 1;
		for (int i = 0; i < childNum; i++) {
			current = (current + S - 1) % circle.size();
			System.out.println(circle.remove(current));
		}
	}
}
