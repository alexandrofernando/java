import java.math.BigInteger;
import java.util.ArrayList;

public class P240 {
	static BigInteger total = BigInteger.ZERO;
	static final int DICE_NUM = 20;
	static final int TOP = 10;

	public static void main(String args[]) {
		final int SIDE = 12;
		final int TARGET = 70;
		search(SIDE, TOP, TARGET, new ArrayList<Value_Count>());
		System.out.println(total);
	}

	static void search(int value, int restNum, int target,
			ArrayList<Value_Count> solution) {
		if (target == 0) {
			if (restNum == 0) {
				calc(solution);
			}
			return;
		}
		if (value * restNum < target) {
			return;
		}
		for (int i = 0; i * value <= target; i++) {
			if (i != 0) {
				solution.add(new Value_Count(value, i));
			}
			search(value - 1, restNum - i, target - i * value, solution);
			if (i != 0) {
				solution.remove(solution.size() - 1);
			}
		}
	}

	static void calc(ArrayList<Value_Count> solution) {
		int rest = DICE_NUM;
		BigInteger count = BigInteger.ONE;
		for (int i = 0; i < solution.size() - 1; i++) {
			count = count.multiply(C(rest, solution.get(i).count));
			rest -= solution.get(i).count;
		}
		BigInteger sum = BigInteger.ZERO;
		Value_Count last = solution.get(solution.size() - 1);
		for (int i = 0; TOP + i <= DICE_NUM; i++) {
			sum = sum.add(C(rest, last.count + i).multiply(
					power(last.value - 1, DICE_NUM - TOP - i)));
		}
		count = count.multiply(sum);
		total = total.add(count);
	}

	static BigInteger C(int a, int b) {
		BigInteger result = BigInteger.ONE;
		for (int i = a; i > a - b; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= b; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result;
	}

	static BigInteger power(int base, int exponent) {
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < exponent; i++) {
			result = result.multiply(new BigInteger(base + ""));
		}
		return result;
	}
}

class Value_Count {
	int value;
	int count;

	Value_Count(int theValue, int theCount) {
		this.value = theValue;
		this.count = theCount;
	}
}