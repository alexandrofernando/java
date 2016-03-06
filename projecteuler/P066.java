import java.math.BigInteger;
import java.util.ArrayList;

public class P066 {
	public static void main(String args[]) {
		BigInteger maxX = BigInteger.ZERO;
		int answer = 0;
		for (int i = 1; i <= 1000; i++) {
			int numberInt = (int) Math.sqrt(i);
			if (numberInt * numberInt == i) {
				continue;
			}
			ArrayList<Fraction> fractions = new ArrayList<Fraction>();
			int up1 = 1;
			int up2 = -numberInt;
			int down = 1;
			fractions.add(new Fraction(numberInt, up1, up2, down));
			BigInteger p1 = new BigInteger(numberInt + "");
			BigInteger p2 = null;
			boolean first = true;
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
				if (first) {
					p2 = p1.multiply(new BigInteger(intPart + "")).add(
							BigInteger.ONE);
					first = false;
				} else {
					BigInteger p3 = p2.multiply(new BigInteger(intPart + ""))
							.add(p1);
					p1 = p2;
					p2 = p3;
				}
				Fraction f = new Fraction(intPart, up1, up2, down);
				int index = fractions.indexOf(f);
				if (index == -1) {
					fractions.add(f);
				} else {
					BigInteger x;
					if ((fractions.size() - index) % 2 == 1) {
						for (int j = index + 1; j < fractions.size(); j++) {
							BigInteger p3 = p2.multiply(
									new BigInteger(fractions.get(j).intPart
											+ "")).add(p1);
							p1 = p2;
							p2 = p3;
						}
						x = p2;
					} else {
						x = p1;
					}
					if (x.compareTo(maxX) > 0) {
						maxX = x;
						answer = i;
					}
					break;
				}
			}
		}
		System.out.println(answer);
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
	int intPart;
	int up1;
	int up2;
	int down;

	Fraction(int theIntPart, int theUp1, int theUp2, int theDown) {
		this.intPart = theIntPart;
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