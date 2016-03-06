// VM arguments: -Xms32m -Xmx800m

import java.util.ArrayList;
import java.util.HashSet;

public class P259 {

    static HashSet<Long> reachables = new HashSet<Long>();
    static HashSet<State> history;

    public static void main(String args[]) {
        searchOperands(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, new ArrayList<Long>());
        long sum = 0;
        for (long reachable : reachables) {
            sum += reachable;
        }
        System.out.println(sum);
    }

    static void searchOperands(int digits[], int index, ArrayList<Long> operands) {
        if (index == digits.length) {
            ArrayList<Rational> rationals = new ArrayList<Rational>();
            for (long operand : operands) {
                rationals.add(new Rational(operand, 1));
            }
            history = new HashSet<State>();
            searchReachable(rationals);
            return;
        }
        long operand = 0;
        for (int i = index; i < digits.length; i++) {
            operand = operand * 10 + digits[i];
            operands.add(operand);
            searchOperands(digits, i + 1, operands);
            operands.remove(operands.size() - 1);
        }
    }

    static void searchReachable(ArrayList<Rational> operands) {
        State state = new State(operands);
        if (!history.add(state)) {
            return;
        }
        if (operands.size() == 1) {
            Rational operand = operands.get(0);
            if (operand.numerator > 0 && operand.denominator == 1) {
                reachables.add(operand.numerator);
            }
            return;
        }
        for (int i = 0; i < operands.size() - 1; i++) {
            Rational op1 = operands.get(i);
            Rational op2 = operands.get(i + 1);
            for (int j = 0; j < 4; j++) {
                Rational result = operate(op1, op2, j);
                if (result == null) {
                    continue;
                }
                operands.remove(i);
                operands.remove(i);
                operands.add(i, result);
                searchReachable(operands);
                operands.remove(i);
                operands.add(i, op2);
                operands.add(i, op1);
            }
        }
    }

    static Rational operate(Rational op1, Rational op2, int operation) {
        if (operation == 0) {
            return Rational.add(op1, op2);
        } else if (operation == 1) {
            return Rational.subtract(op1, op2);
        } else if (operation == 2) {
            return Rational.multiply(op1, op2);
        } else {
            return Rational.divide(op1, op2);
        }
    }
}

class State {

    ArrayList<Rational> operands;

    State(ArrayList<Rational> theOperands) {
        this.operands = new ArrayList<Rational>();
        for (Rational op : theOperands) {
            operands.add(op);
        }
    }

    @Override
    public boolean equals(Object obj) {
        State another = (State) obj;
        if (operands.size() != another.operands.size()) {
            return false;
        }
        for (int i = 0; i < operands.size(); i++) {
            if (!operands.get(i).equals(another.operands.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (Rational operand : operands) {
            hash *= operand.numerator * operand.denominator;
        }
        return hash;
    }
}

class Rational {

    long numerator;
    long denominator;

    Rational(long theNumerator, long theDenominator) {
        long common = gcd(theNumerator, theDenominator);
        this.numerator = theNumerator / common;
        this.denominator = theDenominator / common;
        if (this.numerator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Rational another = (Rational) obj;
        return this.numerator == another.numerator
                && this.denominator == another.denominator;
    }

    private long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        while (b != 0) {
            long c = a % b;
            a = b;
            b = c;
        }
        return (a == 0) ? 1 : a;
    }

    static Rational add(Rational a, Rational b) {
        return new Rational(
                a.numerator * b.denominator + a.denominator * b.numerator,
                a.denominator * b.denominator);
    }

    static Rational subtract(Rational a, Rational b) {
        return new Rational(
                a.numerator * b.denominator - a.denominator * b.numerator,
                a.denominator * b.denominator);
    }

    static Rational multiply(Rational a, Rational b) {
        return new Rational(a.numerator * b.numerator, a.denominator * b.denominator);
    }

    static Rational divide(Rational a, Rational b) {
        if (b.numerator == 0) {
            return null;
        }
        return new Rational(a.numerator * b.denominator, a.denominator * b.numerator);
    }
}
