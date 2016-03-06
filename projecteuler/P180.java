import java.util.HashSet;

public class P180 {
	static final int ORDER = 35;
	static HashSet<Rational> setS = new HashSet<Rational>();

	public static void main(String args[]) {
		for (int a = 1; a <= ORDER; a++) {
			for (int b = 1; b <= ORDER; b++) {
				Rational x = new Rational(a, b);
				Rational x2 = new Rational(a * a, b * b);
				for (int c = 1; c <= ORDER; c++) {
					for (int d = 1; d <= ORDER; d++) {
						Rational y = new Rational(c, d);
						Rational z = Rational.add(x, y);
						addIfValid(x, y, z);
						addIfValid(Rational.reciprocal(x),
								Rational.reciprocal(y), Rational.reciprocal(z));

						Rational y2 = new Rational(c * c, d * d);
						Rational z2 = Rational.add(x2, y2);
						if (z2.isSquare()) {
							z = Rational.sqrt(z2);
						}
						addIfValid(x, y, z);
						addIfValid(Rational.reciprocal(x),
								Rational.reciprocal(y), Rational.reciprocal(z));
					}
				}
			}
		}

		Rational t = new Rational(0, 1);
		for (Rational s : setS) {
			t = Rational.add(t, s);
		}
		System.out.println(t.numerator + t.denominator);
	}

	static void addIfValid(Rational x, Rational y, Rational z) {
		if (x.numerator < x.denominator && y.numerator < y.denominator
				&& z.numerator < z.denominator && z.denominator <= ORDER) {
			setS.add(Rational.add(Rational.add(x, y), z));
		}
	}
}

class Rational {
	long numerator;
	long denominator;

	Rational(long theNumerator, long theDenominator) {
		long common = gcd(theNumerator, theDenominator);
		this.numerator = theNumerator / common;
		this.denominator = theDenominator / common;
	}

	static Rational reciprocal(Rational r) {
		return new Rational(r.denominator, r.numerator);
	}

	static Rational add(Rational x, Rational y) {
		long common = gcd(x.denominator, y.denominator);
		return new Rational(y.denominator / common * x.numerator
				+ x.denominator / common * y.numerator, x.denominator / common
				* y.denominator);
	}

	static Rational sqrt(Rational r) {
		return new Rational(sqrt(r.numerator), sqrt(r.denominator));
	}

	private static long gcd(long a, long b) {
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

	@Override
	public boolean equals(Object obj) {
		Rational another = (Rational) obj;
		return this.numerator == another.numerator
				&& this.denominator == another.denominator;
	}

	@Override
	public int hashCode() {
		return (int) (this.numerator * this.denominator);
	}

	boolean isSquare() {
		return sqrt(this.numerator) > 0 && sqrt(this.denominator) > 0;
	}

	private static long sqrt(long number) {
		long root = (long) Math.round(Math.sqrt(number));
		if (root * root == number) {
			return root;
		} else {
			return -1;
		}
	}
}