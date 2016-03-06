import java.util.ArrayList;

public class P078 {
	public static void main(String args[]) {
		final int MAX_LIMIT = 1000000;
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(1);
		p.add(1);
		for (int i = 2;; i++) {
			int pi = 0;
			int sign = 1;
			for (int j = 1;; j++) {
				int temp = j * (3 * j - 1) / 2;
				if (i - temp < 0) {
					break;
				}
				pi = (pi + sign * p.get(i - temp) + MAX_LIMIT) % MAX_LIMIT;
				temp = j * (3 * j + 1) / 2;
				if (i - temp < 0) {
					break;
				}
				pi = (pi + sign * p.get(i - temp) + MAX_LIMIT) % MAX_LIMIT;
				sign = -sign;
			}
			if (pi == 0) {
				System.out.println(i);
				break;
			}
			p.add(pi);
		}
	}
}
