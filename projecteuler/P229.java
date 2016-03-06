//-Xms64m -Xmx1100m
import java.util.BitSet;

public class P229 {
	public static void main(String args[]) {
		final int LIMIT = 2000000000;
		BitSet represent1 = new BitSet(LIMIT + 1);
		BitSet represent2 = new BitSet(LIMIT + 1);
		BitSet represent3 = new BitSet(LIMIT + 1);
		BitSet represent7 = new BitSet(LIMIT + 1);
		int a2;
		for (int a = 1; (a2 = a * a) + 1 <= LIMIT; a++) {
			int b2;
			for (int b = 1; a2 + (b2 = b * b) <= LIMIT; b++) {
				long n = a2 + b2;
				if (n <= LIMIT) {
					represent1.set((int) n);
				}

				n = a2 + 2L * b2;
				if (n <= LIMIT) {
					represent2.set((int) n);
				}

				n = a2 + 3L * b2;
				if (n <= LIMIT) {
					represent3.set((int) n);
				}

				n = a2 + 7L * b2;
				if (n <= LIMIT) {
					represent7.set((int) n);
				}
			}
		}

		int count = 0;
		for (int i = represent7.nextSetBit(0); i >= 0; i = represent7
				.nextSetBit(i + 1)) {
			if (represent1.get(i) && represent2.get(i) && represent3.get(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
