import java.util.HashSet;

public class P165 {
	public static void main(String args[]) {
		int t[] = new int[20000];
		long s = 290797;
		for (int i = 0; i < t.length; i++) {
			s = s * s % 50515093;
			t[i] = (int) (s % 500);
		}
		Segment segments[] = new Segment[t.length / 4];
		for (int i = 0; i < segments.length; i++) {
			segments[i] = new Segment(t[i * 4], t[i * 4 + 1], t[i * 4 + 2],
					t[i * 4 + 3]);
		}
		HashSet<Point> intersections = new HashSet<Point>();
		for (int i = 0; i < segments.length; i++) {
			for (int j = i + 1; j < segments.length; j++) {
				Segment s1 = segments[i];
				Segment s2 = segments[j];
				int d = (s2.x2 - s2.x1) * (s1.y2 - s1.y1) - (s1.x2 - s1.x1)
						* (s2.y2 - s2.y1);
				if (d == 0) {
					continue;
				}
				Rational p = new Rational((s1.x2 - s1.x1)
						* (s2.x2 * s2.y1 - s2.y2 * s2.x1) + (s2.x2 - s2.x1)
						* (s1.y2 * s1.x1 - s1.x2 * s1.y1), d);
				Rational q = new Rational((s1.y2 - s1.y1)
						* (s2.y2 * s2.x1 - s2.x2 * s2.y1) + (s2.y2 - s2.y1)
						* (s1.x2 * s1.y1 - s1.y2 * s1.x1), -d);
				Point intersection = new Point(p, q);
				if (!interior(intersection, s1) || !interior(intersection, s2)) {
					continue;
				}
				intersections.add(intersection);
			}
		}
		System.out.println(intersections.size());
	}

	static boolean interior(Point p, Segment s) {
		if ((s.x1 * p.x.denominator == p.x.numerator && s.y1 * p.y.denominator == p.y.numerator)
				|| (s.x2 * p.x.denominator == p.x.numerator && s.y2
						* p.y.denominator == p.y.numerator)) {
			return false;
		}
		return Math.signum(s.x1 * p.x.denominator - p.x.numerator)
				* Math.signum(s.x2 * p.x.denominator - p.x.numerator) <= 0
				&& Math.signum(s.y1 * p.y.denominator - p.y.numerator)
						* Math.signum(s.y2 * p.y.denominator - p.y.numerator) <= 0;
	}
}

class Segment {
	int x1;
	int y1;
	int x2;
	int y2;

	Segment(int X1, int Y1, int X2, int Y2) {
		this.x1 = X1;
		this.y1 = Y1;
		this.x2 = X2;
		this.y2 = Y2;
	}
}

class Rational {
	int numerator;
	int denominator;

	Rational(int theNumerator, int theDenominator) {
		if (theNumerator == 0) {
			this.numerator = 0;
			this.denominator = 1;
		} else {
			int common = gcd(Math.abs(theNumerator), Math.abs(theDenominator));
			this.numerator = theNumerator / common;
			this.denominator = theDenominator / common;
			if (this.numerator < 0) {
				this.numerator = -this.numerator;
				this.denominator = -this.denominator;
			}
		}
	}

	int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
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

	public boolean equals(Object obj) {
		Rational another = (Rational) obj;
		return this.numerator == another.numerator
				&& this.denominator == another.denominator;
	}
}

class Point {
	Rational x;
	Rational y;

	Point(Rational X, Rational Y) {
		this.x = X;
		this.y = Y;
	}

	public boolean equals(Object obj) {
		Point another = (Point) obj;
		return this.x.equals(another.x) && this.y.equals(another.y);
	}

	public int hashCode() {
		return this.x.numerator * this.x.denominator * this.y.numerator
				* this.y.denominator;
	}
}