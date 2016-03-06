import java.math.BigInteger;
import java.util.LinkedList;

public class P303 {
	public static void main(String args[]) {
		int LIMIT = 10000;
		BigInteger sum = BigInteger.ZERO;
		for (int n = 1; n <= LIMIT; n++) {
			sum = sum.add(new BigInteger(f(n)).divide(new BigInteger(n + "")));
		}
		System.out.println(sum);
	}

	static String f(int n) {
		String str[] = new String[n];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		str[0] = "";
		while (!queue.isEmpty()) {
			int reminder = queue.poll();
			for (int digit = 0; digit <= 2; digit++) {
				int nextReminder = (reminder * 10 + digit) % n;
				String s = str[reminder] + digit;
				if (s.equals("0")) {
					continue;
				}
				if (nextReminder == 0) {
					return s;
				}
				if (str[nextReminder] == null) {
					str[nextReminder] = s;
					queue.offer(nextReminder);
				}
			}
		}
		return null;
	}
}
