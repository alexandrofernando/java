import java.util.Iterator;
import java.util.TreeSet;

public class P137 {
	static TreeSet<Long> set = new TreeSet<Long>();
	static final int SEQ = 15;

	public static void main(String args[]) {
		calc(0, -1);
		calc(0, 1);
		calc(-1, -2);
		calc(-1, 2);
		calc(2, -5);
		Iterator<Long> iter = set.iterator();
		for (int i = 0; i < SEQ - 1; i++) {
			iter.next();
		}
		System.out.println(iter.next());
	}

	static void calc(long A_F, long M) {
		for (int i = 0; i < SEQ; i++) {
			long nextA_F = -9 * A_F - 4 * M - 2;
			long nextM = -20 * A_F - 9 * M - 4;
			A_F = nextA_F;
			M = nextM;
			if (A_F > 0) {
				set.add(A_F);
			}
		}
	}
}
