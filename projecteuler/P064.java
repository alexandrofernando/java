import java.util.ArrayList;

public class P064 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i <= 10000; i++) {
			int numberInt = (int) Math.sqrt(i);
			if (numberInt * numberInt == i) {
				continue;
			}
			ArrayList<Fraction> fractions = new ArrayList<Fraction>();
			int up1 = 1;
			int up2 = -numberInt;
			int down = 1;
			fractions.add(new Fraction(up1, up2, down));
			while (true) {
				int nextUp1 = up1 * down;
				int nextUp2 = -up2 * down;
				int nextDown = up1 * up1 * i - up2 * up2;
				int common = GCD(GCD(Math.abs(nextUp1), Math.abs(nextUp2)),
						Math.abs(nextDown));
				nextUp1 /= common;
				nextUp2 /= common;
				nextDown /= common;
				int intPart = 0;
				while (nextUp1 * nextUp1 * i >= (nextDown - nextUp2)
						* (nextDown - nextUp2)) {
					nextUp2 = nextUp2 - nextDown;
					intPart++;
				}
				up1 = nextUp1;
				up2 = nextUp2;
				down = nextDown;
				Fraction f = new Fraction(up1, up2, down);
				int index = fractions.indexOf(f);
				if (index == -1) {
					fractions.add(f);
				} else {
					if ((fractions.size() - index) % 2 == 1) {
						count++;
					}
					break;
				}
			}
		}
		System.out.println(count);
	}

	static int GCD(int a, int b) {
		if (a < b) {
			return GCD(b, a);
		}
		if (b == 0) {
			return 1;
		}
		while (a % b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return b;
	}
}

class Fraction {
	int up1;
	int up2;
	int down;

	Fraction(int theUp1, int theUp2, int theDown) {
		this.up1 = theUp1;
		this.up2 = theUp2;
		this.down = theDown;
	}

	public boolean equals(Object obj) {
		Fraction another = (Fraction) obj;
		return this.up1 == another.up1 && this.up2 == another.up2
				&& this.down == another.down;
	}
}