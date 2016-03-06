import java.util.LinkedList;

public class P348 {
	public static void main(String args[]) {
		final int TARGET_WAY = 4;
		final int NUM = 5;
		LinkedList<String> queue = new LinkedList<String>();
		for (int i = 1; i <= 9; i++) {
			queue.offer(i + "");
		}
		for (int i = 1; i <= 9; i++) {
			queue.offer(i + "" + i);
		}
		int sum = 0;
		int found = 0;
		while (found < NUM) {
			String head = queue.poll();
			int number = Integer.parseInt(head);
			if (search(number) == TARGET_WAY) {
				found++;
				sum += number;
			}
			int posIns;
			boolean even = (head.length() % 2 == 0);
			if (even) {
				posIns = head.length() / 2;
			} else {
				int posMid = head.length() / 2;
				char chMid = head.charAt(posMid);
				head = head.substring(0, posMid + 1) + chMid
						+ head.substring(posMid + 1);
				posIns = posMid + 1;
			}
			for (int i = 0; i <= 9; i++) {
				String strIns;
				if (even) {
					strIns = i + "" + i;
				} else {
					strIns = i + "";
				}
				queue.offer(head.substring(0, posIns) + strIns
						+ head.substring(posIns));
			}
		}
		System.out.println(sum);
	}

	static int search(int number) {
		int cube;
		int count = 0;
		for (int i = 2; (cube = i * i * i) + 2 * 2 <= number; i++) {
			int rest = number - cube;
			if (isSquare(rest)) {
				count++;
			}
		}
		return count;
	}

	static boolean isSquare(int number) {
		int root = (int) Math.round(Math.sqrt(number));
		return root * root == number;
	}
}
