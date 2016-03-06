package P3979__Fraction_addition_and_subtraction;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String str = in.nextLine();
			int a = str.charAt(0) - '0';
			int b = str.charAt(2) - '0';
			int c = str.charAt(4) - '0';
			int d = str.charAt(6) - '0';
			int e = 0;
			int f = 0;
			if (str.charAt(3) == '+') {
				e = a * d + c * b;
			} else {
				e = a * d - c * b;
			}
			f = b * d;
			if (e == 0) {
				System.out.println(0);
			} else {
				int common = gcd(Math.abs(e), f);
				e /= common;
				f /= common;
				if (f == 1) {
					System.out.println(e);
				} else {
					System.out.println(e + "/" + f);
				}
			}
		}
	}

	static int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}
}
