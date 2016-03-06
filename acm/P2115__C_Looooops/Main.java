package P2115__C_Looooops;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (true) {
			long A = in.nextLong();
			long B = in.nextLong();
			long C = in.nextLong();
			int k = in.nextInt();
			if (A == 0 && B == 0 && C == 0 && k == 0) {
				break;
			}

			long modulo = 1L << k;
			long common = gcd(C, modulo);
			long diff = (B - A + modulo) % modulo;
			if (diff % common == 0) {
				modulo /= common;
				C /= common;
				diff /= common;
				X_Y solution = extendedGCD(C, modulo);
				long result = (solution.x % modulo + modulo) % modulo * diff
						% modulo;
				System.out.println(result);
			} else {
				System.out.println("FOREVER");
			}
		}

		in.close();
	}

	static long gcd(long a, long b) {
		if (a < b) {
			return gcd(b, a);
		}
		while (b != 0) {
			long c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	static X_Y extendedGCD(long a, long b) {
		if (b == 0) {
			return new X_Y(1, 0);
		} else {
			X_Y solution = extendedGCD(b, a % b);
			return new X_Y(solution.y, solution.x - a / b * solution.y);
		}
	}
}

class X_Y {
	long x;
	long y;

	public X_Y(long x, long y) {
		this.x = x;
		this.y = y;
	}
}