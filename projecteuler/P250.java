import java.util.ArrayList;

public class P250 {
	public static void main(String args[]) {
		final int MODULO = 250;
		ArrayList<Integer> reminders = new ArrayList<Integer>();
		for (int i = 1; i <= 250250; i++) {
			int m = 1;
			int p = i % MODULO;
			for (int j = i; j > 0; j >>= 1) {
				if ((j & 1) == 1) {
					m = (m * p) % MODULO;
				}
				p = p * p % MODULO;
			}
			reminders.add(m);
		}
		long counts[] = new long[MODULO];
		counts[0] = 1;
		for (int i = 0; i < reminders.size(); i++) {
			long newCounts[] = new long[MODULO];
			for (int j = 0; j < counts.length; j++) {
				newCounts[j] = counts[j];
			}
			for (int j = 0; j < counts.length; j++) {
				newCounts[(j + reminders.get(i)) % MODULO] = (newCounts[(j + reminders
						.get(i)) % MODULO] + counts[j]) % 10000000000000000L;
			}
			counts = newCounts;
		}
		System.out.println(counts[0] - 1);
	}
}
