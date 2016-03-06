// VM arguments: -Xms32m -Xmx1400m

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P336 {
	static int maxRotation = -1;
	static ArrayList<String> maximixs = null;
	static final int CARRIAGE = 11;
	static HashMap<String, Integer> history = new HashMap<String, Integer>();

	public static void main(String args[]) {
		final int SEQUENCE = 2011;
		StringBuffer order = new StringBuffer();
		for (int i = 0; i < CARRIAGE; i++) {
			order.append((char) ('A' + i));
		}
		permutate(order, 0);
		Collections.sort(maximixs);
		System.out.println(maximixs.get(SEQUENCE - 1));
	}

	static void permutate(StringBuffer order, int index) {
		if (index == order.length()) {
			int rotation = calcRotation(order.toString());
			if (rotation > maxRotation) {
				maxRotation = rotation;
				maximixs = new ArrayList<String>();
				maximixs.add(order.toString());
			} else if (rotation == maxRotation) {
				maximixs.add(order.toString());
			}
			return;
		}
		for (int i = index; i < order.length(); i++) {
			char temp = order.charAt(index);
			order.setCharAt(index, order.charAt(i));
			order.setCharAt(i, temp);

			permutate(order, index + 1);

			temp = order.charAt(index);
			order.setCharAt(index, order.charAt(i));
			order.setCharAt(i, temp);
		}
	}

	static int calcRotation(String order) {
		if (order.length() <= 1) {
			return 0;
		}
		Integer result = history.get(order);
		if (result != null) {
			return result;
		}
		int rotation = 0;
		int minPos = 0;
		for (int i = 1; i < order.length(); i++) {
			if (order.charAt(i) < order.charAt(minPos)) {
				minPos = i;
			}
		}
		if (minPos == 0) {
			rotation = calcRotation(order.substring(1));
		} else {
			if (minPos == order.length() - 1) {
				rotation++;
			} else {
				rotation += 2;
			}
			String nextOrder = order.substring(minPos + 1)
					+ new StringBuffer(order.subSequence(0, minPos)).reverse()
							.toString();
			rotation += calcRotation(nextOrder);
		}
		if (order.length() < CARRIAGE) {
			history.put(order, rotation);
		}
		return rotation;
	}
}
