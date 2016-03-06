package P3983__Fast_Calculation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static final int TARGET = 24;
	static final double EPSILON = 1E-9;
	static final Operation OPERRATIONS[] = { new Addition(), new Subtraction(),
			new Multiplication(), new Division() };

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ArrayList<Double> numbers = new ArrayList<Double>();
		ArrayList<String> expressions = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			int number = in.nextInt();
			numbers.add((double) number);
			expressions.add(number + "");
		}

		String result = findExpression(numbers, expressions);
		result = result.substring(1, result.length() - 1);
		System.out.println(result);

		in.close();
	}

	static String findExpression(ArrayList<Double> numbers,
			ArrayList<String> expressions) {
		if (numbers.size() == 1) {
			if (Math.abs(numbers.get(0) - TARGET) < EPSILON) {
				return expressions.get(0);
			} else {
				return null;
			}
		}
		for (Operation operation : OPERRATIONS) {
			for (int i = 0; i < numbers.size() - 1; i++) {
				double a = numbers.get(i);
				double b = numbers.get(i + 1);
				String expr1 = expressions.get(i);
				String expr2 = expressions.get(i + 1);
				double nextNumber = operation.operate(a, b);
				String nextExpr = operation.combine(expr1, expr2);
				if (Double.isNaN(nextNumber)) {
					continue;
				}
				numbers.remove(i + 1);
				numbers.remove(i);
				expressions.remove(i + 1);
				expressions.remove(i);
				numbers.add(i, nextNumber);
				expressions.add(i, nextExpr);

				String result = findExpression(numbers, expressions);
				if (result != null) {
					return result;
				}

				numbers.remove(i);
				expressions.remove(i);
				numbers.add(i, a);
				numbers.add(i + 1, b);
				expressions.add(i, expr1);
				expressions.add(i + 1, expr2);
			}
		}
		return null;
	}
}

abstract class Operation {
	abstract double operate(double a, double b);

	String combine(String expr1, String expr2) {
		return "(" + expr1 + getOperator() + expr2 + ")";
	}

	abstract String getOperator();
}

class Addition extends Operation {
	@Override
	double operate(double a, double b) {
		return a + b;
	}

	@Override
	String getOperator() {
		return "+";
	}
}

class Subtraction extends Operation {
	@Override
	double operate(double a, double b) {
		return a - b;
	}

	@Override
	String getOperator() {
		return "-";
	}
}

class Multiplication extends Operation {
	@Override
	double operate(double a, double b) {
		return a * b;
	}

	@Override
	String getOperator() {
		return "*";
	}
}

class Division extends Operation {
	@Override
	double operate(double a, double b) {
		if (Math.abs(b) < Main.EPSILON) {
			return Double.NaN;
		}
		return a / b;
	}

	@Override
	String getOperator() {
		return "/";
	}
}