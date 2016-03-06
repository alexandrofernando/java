import java.math.BigInteger;
import java.util.LinkedList;

public class P284 {
	public static void main(String args[]) {
		final int RADIX = 14;
		final int LIMIT_DIGIT = 10000;
		long sum = 0;
		BigInteger radixPowers[] = new BigInteger[LIMIT_DIGIT];
		radixPowers[0] = BigInteger.ONE;
		for (int i = 1; i < radixPowers.length; i++) {
			radixPowers[i] = radixPowers[i - 1].multiply(new BigInteger(RADIX
					+ ""));
		}
		String oneDigitSolutions[] = new String[] { "1", "7", "8" };
		LinkedList<Number_Square> queue = new LinkedList<Number_Square>();
		for (String s : oneDigitSolutions) {
			int d = Integer.parseInt(s);
			queue.offer(new Number_Square(s, Integer.toString(d * d, RADIX)));
		}
		while (!queue.isEmpty()) {
			Number_Square head = queue.poll();
			int length = head.number.length();
			if (head.number.charAt(0) != '0') {
				if (length % 100 == 0) {
					System.out.println("length: " + length);
				}
				for (int i = 0; i < length; i++) {
					sum += Long.parseLong(head.number.charAt(i) + "", RADIX);
				}
			}
			if (length == LIMIT_DIGIT) {
				continue;
			}
			String nextNumber = head.number;
			String nextSquare = head.square;
			int checkIndex = nextSquare.length() - length - 1;
			if (checkIndex < 0 || nextSquare.charAt(checkIndex) == '0') {
				queue.offer(new Number_Square("0" + head.number, head.square));
			}
			for (int i = 1; i < RADIX; i++) {
				nextSquare = new BigInteger(nextSquare, RADIX)
						.add(new BigInteger("2").multiply(radixPowers[length])
								.multiply(new BigInteger(nextNumber, RADIX)))
						.add(radixPowers[length].multiply(radixPowers[length]))
						.toString(RADIX);
				char added = Character.forDigit(i, RADIX);
				nextNumber = added + head.number;
				checkIndex = nextSquare.length() - length - 1;
				if (checkIndex >= 0 && nextSquare.charAt(checkIndex) == added) {
					queue.offer(new Number_Square(nextNumber, nextSquare));
				}
			}
		}
		System.out.println(Long.toString(sum, RADIX));
	}
}

class Number_Square {
	String number;
	String square;

	Number_Square(String theNumber, String theSquare) {
		this.number = theNumber;
		this.square = theSquare;
	}
}