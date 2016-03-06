public class P255 {
	static final long BEGIN = 10000000000000L;
	static final long END = 99999999999999L;
	static long iterTotal = 0;

	public static void main(String args[]) {
		search(BEGIN, END, 7000000);
		System.out.printf("%.10f\n", (double) iterTotal / (END - BEGIN + 1));
	}

	static void search(long begin, long end, long x) {
		iterTotal += end - begin + 1;
		if (begin % x == 0) {
			long nextX = (x + begin / x) / 2;
			if (nextX != x) {
				search(begin, begin, nextX);
			}
			begin++;
		}
		while (begin <= end) {
			long div = begin / x + 1;
			long high = div * x;
			high = Math.min(high, end);
			long nextX = (x + div) / 2;
			if (nextX != x) {
				search(begin, high, nextX);
			}
			begin = high + 1;
		}
	}
}
