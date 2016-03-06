
import java.util.ArrayList;

public class P192 {

    public static void main(String args[]) {
        final long BOUND = 1000000000000L;
        long sum = 0;
        for (int n = 2; n <= 100000; n++) {
            if (!isPerfectSquare(n)) {
                ContinuedFraction cf = calcContinuedFractionForSqrt(n);
                long bestDenominator = -1;
                int index = 0;
                ArrayList<Integer> terms = new ArrayList<Integer>();
                while (true) {
                    terms.add(cf.get(index));
                    Rational r = convert(terms, 0);
                    if (r.denominator > BOUND) {
                        int lastTerm = terms.get(terms.size() - 1);
                        int maxDecrementLastTerm;
                        if (lastTerm % 2 == 0) {
                            if (isHalfAdmissible(terms, cf, index)) {
                                maxDecrementLastTerm = lastTerm / 2;
                            } else {
                                maxDecrementLastTerm = lastTerm / 2 - 1;
                            }
                        } else {
                            maxDecrementLastTerm = lastTerm / 2;
                        }
                        for (int i = 1; i <= maxDecrementLastTerm; i++) {
                            r = convert(terms, i);
                            if (r.denominator <= BOUND) {
                                bestDenominator = r.denominator;
                                break;
                            }
                        }
                        break;
                    }
                    bestDenominator = r.denominator;
                    index++;
                }
                sum += bestDenominator;
            }
        }
        System.out.println(sum);
    }

    static boolean isHalfAdmissible(ArrayList<Integer> terms,
            ContinuedFraction cf, int index) {
        boolean flag = false;
        for (int i = 1; i < terms.size() - 1; i++) {
            flag = !flag;
            int left = terms.get(index - i);
            int right = cf.get(index + i);
            if (left > right) {
                return true ^ flag;
            } else if (left < right) {
                return false ^ flag;
            }
        }
        return false ^ flag;
    }

    static Rational convert(ArrayList<Integer> terms, int decrementLastTerm) {
        Rational r = new Rational(
                terms.get(terms.size() - 1) - decrementLastTerm, 1);
        for (int i = terms.size() - 2; i >= 0; i--) {
            r = Rational.add(terms.get(i), Rational.reciprocal(r));
        }
        return r;
    }

    static boolean isPerfectSquare(int n) {
        int root = (int) Math.round(Math.sqrt(n));
        return root * root == n;
    }

    static ContinuedFraction calcContinuedFractionForSqrt(int s) {
        ContinuedFraction cf = new ContinuedFraction();
        int m = 0;
        int d = 1;
        int a = (int) Math.sqrt(s);
        cf.a0 = a;
        boolean first = true;
        int m1 = -1;
        int d1 = -1;
        while (true) {
            int nextM = d * a - m;
            int nextD = (s - nextM * nextM) / d;
            if (first) {
                m1 = nextM;
                d1 = nextD;
                first = false;
            } else if (nextM == m1 && nextD == d1) {
                break;
            }
            int nextA = (int) ((cf.a0 + nextM) / nextD);
            cf.period.add(nextA);
            m = nextM;
            d = nextD;
            a = nextA;
        }
        return cf;
    }
}

class Rational {

    long numerator;
    long denominator;

    Rational(long theNumerator, long theDenominator) {
        this.numerator = theNumerator;
        this.denominator = theDenominator;
    }

    static Rational reciprocal(Rational r) {
        return new Rational(r.denominator, r.numerator);
    }

    static Rational add(long integer, Rational r) {
        return new Rational(r.denominator * integer + r.numerator,
                r.denominator);
    }
}

class ContinuedFraction {

    int a0;
    ArrayList<Integer> period = new ArrayList<Integer>();

    int get(int index) {
        if (index == 0) {
            return a0;
        } else {
            return period.get((index - 1) % period.size());
        }
    }
}