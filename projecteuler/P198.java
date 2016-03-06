// VM arguments: -Xms32m -Xmx2000m

import java.util.Stack;

public class P198 {
	public static void main(String args[]) {
		final int LIMIT_DENOMINATOR = 100000000;
		final int LIMIT_FRACTION = 100;
		int lowerNumerator = 0;
		int lowerDenominator = 1;
		Stack<Rational> stack = new Stack<Rational>();
		stack.push(new Rational(1, LIMIT_FRACTION / 2));
		int count = 0;
		while (!stack.empty()) {
			Rational top = stack.peek();
			int upperNumerator = top.numerator;
			int upperDenominator = top.denominator;
			long middleNumerator = (long) lowerNumerator * upperDenominator
					+ (long) upperNumerator * lowerDenominator;
			long middleDenominator = 2L * lowerDenominator * upperDenominator;
			if (middleDenominator <= LIMIT_DENOMINATOR) {
				int mediantNumerator = lowerNumerator + upperNumerator;
				int mediantDenominator = lowerDenominator + upperDenominator;
				stack.push(new Rational(mediantNumerator, mediantDenominator));
				if (LIMIT_FRACTION * middleNumerator < middleDenominator) {
					count++;
				}
			} else {
				lowerNumerator = upperNumerator;
				lowerDenominator = upperDenominator;
				stack.pop();
			}
		}
		System.out.println(count);
	}
}

class Rational {
	int numerator;
	int denominator;

	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
}