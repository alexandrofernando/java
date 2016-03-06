import java.util.Stack;

public class P188 {
	public static void main(String args[]) {
		final int BASE = 1777;
		final int TETRATION = 1855;
		final int MODULAR = 100000000;
		Stack<Integer> stack = new Stack<Integer>();
		int mod = MODULAR;
		for (int i = 0; i < TETRATION; i++) {
			stack.push(mod);
			mod = order(BASE, mod);
		}
		int exponent = 1;
		for (int i = 0; i < TETRATION; i++) {
			mod = stack.pop();
			exponent = power(BASE, exponent, mod);
		}
		System.out.println(exponent);
	}

	static int order(int base, int mod) {
		int count = 1;
		long number = base;
		while (number != 1) {
			number = number * base % mod;
			count++;
		}
		return count;
	}

	static int power(int base, int exponent, int mod) {
		long number = 1;
		for (int i = 0; i < exponent; i++) {
			number = number * base % mod;
		}
		return (int) number;
	}
}
