import java.util.TreeSet;

public class P236 {
	static int na[] = { 5248, 5760, 1312 + 2624 + 3936 };
	static int nb[] = { 640, 3776, 1888 + 3776 + 5664 };
	static int sa[] = new int[na.length];
	static int sb[] = new int[nb.length];
	static Rational m;
	static TreeSet<Rational> mSolutions = new TreeSet<Rational>();

	public static void main(String args[]) {
		for (sb[0] = 1; sb[0] <= nb[0]; sb[0]++) {
			int sa0Upper = sb[0] * na[0] / nb[0];
			for (sa[0] = 1; sa[0] <= sa0Upper; sa[0]++) {
				m = new Rational(sb[0] * na[0], sa[0] * nb[0]);
				if (m.numerator == m.denominator) {
					continue;
				}
				search(1);
			}
		}
		Rational max = mSolutions.last();
		System.out.println(max.numerator + "/" + max.denominator);
	}

	static void search(int index) {
		if (index == na.length) {
			int sumNA = 0;
			int sumNB = 0;
			int sumSA = 0;
			int sumSB = 0;
			for (int i = 0; i < na.length; i++) {
				sumNA += na[i];
				sumNB += nb[i];
				sumSA += sa[i];
				sumSB += sb[i];
			}
			if (Rational.multiply(new Rational(sumSB, sumNB), m).equals(
					new Rational(sumSA, sumNA))) {
				mSolutions.add(m);
			}
		} else {
			Rational sb2sa = Rational.multiply(new Rational(nb[index],
					na[index]), m);
			for (sb[index] = sb2sa.numerator, sa[index] = sb2sa.denominator; sb[index] <= nb[index]
					&& sa[index] <= na[index]; sb[index] += sb2sa.numerator, sa[index] += sb2sa.denominator) {
				search(index + 1);
			}
		}
	}
}

class Rational implements Comparable<Rational> {
	int numerator;
	int denominator;

	public Rational(int numerator, int denominator) {
		int common = gcd(numerator, denominator);
		this.numerator = numerator / common;
		this.denominator = denominator / common;
	}

	int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	static Rational multiply(Rational a, Rational b) {
		return new Rational(a.numerator * b.numerator, a.denominator
				* b.denominator);
	}

	@Override
	public int compareTo(Rational another) {
		return numerator * another.denominator - denominator
				* another.numerator;
	}

	@Override
	public int hashCode() {
		return numerator * denominator;
	}

	@Override
	public boolean equals(Object obj) {
		Rational another = (Rational) obj;
		return numerator == another.numerator
				&& denominator == another.denominator;
	}
}