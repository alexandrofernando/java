import java.math.BigInteger;

public class P121 {
	public static void main(String args[]) {
		final int TURN = 15;
		Fraction possibilities[][] = new Fraction[TURN + 1][TURN + 1];
		possibilities[0][0] = new Fraction(BigInteger.ONE, BigInteger.ONE);
		for (int i = 0; i < TURN; i++) {
			for (int j = 0; j <= i + 1; j++) {
				possibilities[i + 1][j] = new Fraction(BigInteger.ZERO,
						BigInteger.ONE);
			}
			for (int j = 0; j <= i; j++) {
				possibilities[i + 1][j] = Fraction.add(possibilities[i + 1][j],
						Fraction.muliply(possibilities[i][j], new Fraction(
								new BigInteger(i + 1 + ""), new BigInteger(i
										+ 2 + ""))));
				possibilities[i + 1][j + 1] = Fraction.add(
						possibilities[i + 1][j + 1], Fraction.muliply(
								possibilities[i][j], new Fraction(
										BigInteger.ONE, new BigInteger(i + 2
												+ ""))));
			}
		}
		Fraction win = new Fraction(BigInteger.ZERO, BigInteger.ONE);
		for (int i = TURN / 2 + 1; i <= TURN; i++) {
			win = Fraction.add(win, possibilities[TURN][i]);
		}
		System.out.println(win.denominator.divide(win.numerator));
	}
}

class Fraction {
	BigInteger numerator;
	BigInteger denominator;

	Fraction(BigInteger theNumerator, BigInteger theDenominator) {
		this.numerator = theNumerator;
		this.denominator = theDenominator;
	}

	static Fraction add(Fraction a, Fraction b) {
		BigInteger n = a.numerator.multiply(b.denominator).add(
				a.denominator.multiply(b.numerator));
		BigInteger d = a.denominator.multiply(b.denominator);
		BigInteger divisor = GCD(n, d);
		n = n.divide(divisor);
		d = d.divide(divisor);
		return new Fraction(n, d);
	}

	static Fraction muliply(Fraction a, Fraction b) {
		BigInteger n = a.numerator.multiply(b.numerator);
		BigInteger d = a.denominator.multiply(b.denominator);
		BigInteger divisor = GCD(n, d);
		n = n.divide(divisor);
		d = d.divide(divisor);
		return new Fraction(n, d);
	}

	static BigInteger GCD(BigInteger a, BigInteger b) {
		if (a.compareTo(b) < 0) {
			return GCD(b, a);
		}
		while (true) {
			BigInteger c = a.remainder(b);
			if (c.compareTo(BigInteger.ZERO) == 0) {
				break;
			}
			a = b;
			b = c;
		}
		return b;
	}
}