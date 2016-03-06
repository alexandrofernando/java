
import java.util.Arrays;

public class P329 {

    final static int RANGE = 500;
    final static String SEQUENCE = "PPPPNNPPPNPPNPN";
    static boolean primes[] = new boolean[RANGE + 1];
    static Fraction answer = Fraction.ZERO;
    static Fraction part;

    public static void main(String args[]) {
        sievePrimes();
        for (int i = 1; i <= RANGE; i++) {
            part = Fraction.ZERO;
            search(i, 0, Fraction.ONE);
            answer = Fraction.add(answer,
                    Fraction.multiply(new Fraction(1, RANGE), part));
        }
        System.out.println(answer.numerator + "/" + answer.denominator);
    }

    static void sievePrimes() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    static void search(int square, int index, Fraction possibility) {
        if (primes[square] ^ (SEQUENCE.charAt(index) == 'P')) {
            possibility = Fraction.multiply(new Fraction(1, 3), possibility);
        } else {
            possibility = Fraction.multiply(new Fraction(2, 3), possibility);
        }
        if (index == SEQUENCE.length() - 1) {
            part = Fraction.add(part, possibility);
            return;
        }
        if (square == 1) {
            search(square + 1, index + 1, possibility);
        } else if (square == RANGE) {
            search(square - 1, index + 1, possibility);
        } else {
            search(square - 1, index + 1,
                    Fraction.multiply(new Fraction(1, 2), possibility));
            search(square + 1, index + 1,
                    Fraction.multiply(new Fraction(1, 2), possibility));
        }
    }
}

class Fraction {

    static Fraction ZERO = new Fraction(0, 1);
    static Fraction ONE = new Fraction(1, 1);
    long numerator;
    long denominator;

    Fraction(long theNumerator, long theDenominator) {
        long common = gcd(theNumerator, theDenominator);
        this.numerator = theNumerator / common;
        this.denominator = theDenominator / common;
    }

    static Fraction add(Fraction a, Fraction b) {
        long common = gcd(a.denominator, b.denominator);
        long newDenominator = a.denominator / common * b.denominator;
        long newNumerator = newDenominator / a.denominator * a.numerator
                + newDenominator / b.denominator * b.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    static Fraction multiply(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.numerator,
                a.denominator * b.denominator);
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
}
