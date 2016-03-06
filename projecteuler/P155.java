// VM arguments: -Xms32m -Xmx800m

import java.util.HashSet;
import java.util.Iterator;

public class P155 {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		HashSet<Fraction> capacitors[] = new HashSet[19];
		HashSet<Fraction> total = new HashSet<Fraction>();
		for (int i = 1; i < capacitors.length; i++) {
			capacitors[i] = new HashSet<Fraction>();
		}
		Fraction c = new Fraction(1, 1);
		capacitors[1].add(c);
		total.add(c);
		for (int n = 2; n < capacitors.length; n++) {
			for (int n1 = 1; n1 + n1 <= n; n1++) {
				int n2 = n - n1;
				Iterator<Fraction> iter1 = capacitors[n1].iterator();
				while (iter1.hasNext()) {
					Fraction c1 = iter1.next();
					Iterator<Fraction> iter2 = capacitors[n2].iterator();
					while (iter2.hasNext()) {
						Fraction c2 = iter2.next();
						Fraction nextC1 = Fraction.add(c1, c2);
						Fraction nextC2 = Fraction.inverse(Fraction.add(
								Fraction.inverse(c1), Fraction.inverse(c2)));
						capacitors[n].add(nextC1);
						capacitors[n].add(nextC2);
						total.add(nextC1);
						total.add(nextC2);
					}
				}
			}
		}
		System.out.println(total.size());
	}
}

class Fraction {
	int numerator;
	int denominator;

	Fraction(int theNumerator, int theDenominator) {
		this.numerator = theNumerator;
		this.denominator = theDenominator;
	}

	public boolean equals(Object obj) {
		Fraction another = (Fraction) obj;
		return this.numerator == another.numerator
				&& this.denominator == another.denominator;
	}

	public int hashCode() {
		return this.numerator * this.denominator;
	}

	static Fraction inverse(Fraction a) {
		return new Fraction(a.denominator, a.numerator);
	}

	static Fraction add(Fraction a, Fraction b) {
		long n = (long) a.numerator * b.denominator + (long) b.numerator
				* a.denominator;
		long d = (long) a.denominator * b.denominator;
		long gcd = GCD(n, d);
		n /= gcd;
		d /= gcd;
		return new Fraction((int) n, (int) d);
	}

	static long GCD(long a, long b) {
		if (a < b) {
			return GCD(b, a);
		}
		while (true) {
			long c = a % b;
			if (c == 0) {
				break;
			}
			a = b;
			b = c;
		}
		return b;
	}
}