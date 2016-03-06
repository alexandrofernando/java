package P3981__String_replacement;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println(line.replaceAll("you", "we"));
		}
	}
}
