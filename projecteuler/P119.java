import java.util.PriorityQueue;

public class P119 {
	public static void main(String args[]) {
		PriorityQueue<Power> pq = new PriorityQueue<Power>();
		pq.add(new Power(3, 3, 27));
		int nextBase = 4;
		long nextBasePower = 16;
		int index = 1;
		while (true) {
			Power head = pq.peek();
			if (nextBasePower < head.value) {
				pq.add(new Power(nextBase, 2, nextBasePower));
				nextBase++;
				nextBasePower = (long) Math.pow(nextBase, findPower(nextBase));
				continue;
			}
			head = pq.poll();
			if (new String(head.value + "").length() <= head.base) {
				if (isValid(head.value, head.base)) {
					if (index == 30) {
						System.out.println(head.value);
						break;
					}
					index++;
				}
				pq.add(new Power(head.base, head.exponent + 1, head.value
						* head.base));
			}
		}
	}

	static int findPower(int base) {
		int digitNum = base / 9;
		return Math.max(
				(int) Math.ceil(Math.log(Math.pow(10, digitNum - 1))
						/ Math.log(base)), 2);
	}

	static boolean isValid(long number, int target) {
		int digitSum = 0;
		while (number > 0) {
			digitSum += number % 10;
			number /= 10;
		}
		return digitSum == target;
	}
}

class Power implements Comparable<Power> {
	int base;
	int exponent;
	long value;

	Power(int theBase, int theExponent, long theValue) {
		this.base = theBase;
		this.exponent = theExponent;
		this.value = theValue;
	}

	public int compareTo(Power another) {
		return (int) Math.signum(this.value - another.value);
	}
}