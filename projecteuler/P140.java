import java.util.Iterator;
import java.util.TreeSet;

public class P140 {
	static TreeSet<Long> set = new TreeSet<Long>();
	static final int SEQ = 30;

	public static void main(String args[]) {
		calc(0, -1);
		calc(0, 1);
		calc(-3, -2);
		calc(-3, 2);
		calc(-4, -5);
		calc(-4, 5);
		calc(2, -7);
		calc(2, 7);
		long sum = 0;
		Iterator<Long> iter = set.iterator();
		for (int i = 0; i < SEQ; i++) {
			long nugget = iter.next();
			sum += nugget;
		}
		System.out.println(sum);
	}

	static void calc(long A_F, long M) {
		for (int i = 0; i < SEQ; i++) {
			long nextA_F = -9 * A_F - 4 * M - 14;
			long nextM = -20 * A_F - 9 * M - 28;
			A_F = nextA_F;
			M = nextM;
			if (A_F > 0) {
				set.add(A_F);
			} else {
				i--;
			}
		}
	}
}
