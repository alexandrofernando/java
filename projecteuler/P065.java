import java.math.BigInteger;

public class P065 {
	public static void main(String args[]) {
		int constants[] = new int[100];
		constants[0] = 2;
		for (int i = 1, temp = 2; i < constants.length; i += 3, temp += 2) {
			constants[i] = 1;
			constants[i + 1] = temp;
			constants[i + 2] = 1;
		}
		Fraction fn = new Fraction(new BigInteger(
				constants[constants.length - 1] + ""), BigInteger.ONE);
		for (int i = constants.length - 2; i >= 0; i--) {
			fn.inverse();
			fn = Fraction.add(fn, new Fraction(
					new BigInteger(constants[i] + ""), BigInteger.ONE));
		}
		int sum = 0;
		String str = fn.numerator.toString();
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}

class Fraction {
	BigInteger numerator;
	BigInteger denominator;

	Fraction(BigInteger theNumerator, BigInteger theDenominator) {
		this.numerator = theNumerator;
		this.denominator = theDenominator;
	}

	void inverse() {
		BigInteger temp = this.numerator;
		this.numerator = this.denominator;
		this.denominator = temp;
	}

	static Fraction add(Fraction a, Fraction b) {
		BigInteger n = a.numerator.multiply(b.denominator).add(
				a.denominator.multiply(b.numerator));
		BigInteger d = a.denominator.multiply(b.denominator);
		BigInteger common = n.gcd(d);
		n = n.divide(common);
		d = d.divide(common);
		return new Fraction(n, d);
	}
}