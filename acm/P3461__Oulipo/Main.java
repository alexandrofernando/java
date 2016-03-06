package P3461__Oulipo;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			String word = in.next();
			String text = in.next();

			int p[] = new int[word.length()];
			p[0] = -1;
			int j = -1;
			for (int i = 1; i < word.length(); i++) {
				while (j >= 0 && word.charAt(j + 1) != word.charAt(i)) {
					j = p[j];
				}
				if (word.charAt(j + 1) == word.charAt(i)) {
					j++;
				}
				p[i] = j;
			}

			int occurrence = 0;
			j = -1;
			for (int i = 0; i < text.length(); i++) {
				while (j >= 0 && word.charAt(j + 1) != text.charAt(i)) {
					j = p[j];
				}
				if (word.charAt(j + 1) == text.charAt(i)) {
					j++;
				}
				if (j == word.length() - 1) {
					occurrence++;
					j = p[j];
				}
			}
			System.out.println(occurrence);
		}
	}
}
