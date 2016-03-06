// VM arguments: -Xms32m -Xmx800m

public class P238 {
	static final int MODULO = 20300713;
	static final int S0 = 14025256;
	static final int STRING_BUFFER_SIZE = 10000000;
	static final long LIMIT = 2000000000000000L;

	public static void main(String args[]) {
		int s = S0;
		boolean used[] = new boolean[MODULO];
		StringBuffer cycle = new StringBuffer(STRING_BUFFER_SIZE);
		while (true) {
			if (used[s]) {
				break;
			}
			cycle.append(s);
			used[s] = true;
			s = calcNextS(s);
		}
		int sum = 0;
		int sums[] = new int[cycle.length() + 1];
		for (int i = 1; i < sums.length; i++) {
			sum += cycle.charAt(i - 1) - '0';
			sums[i] = sum;
		}
		int cycleSum = sums[sums.length - 1];
		int pos[] = new int[cycleSum];
		int rest = pos.length;
		for (int i = 1; i < sums.length; i++) {
			for (int j = 1; j < sums.length; j++) {
				int partSum = (sums[j] - sums[i - 1] + cycleSum) % cycleSum;
				if (pos[partSum] == 0) {
					pos[partSum] = i;
					rest--;
					if (rest == 0) {
						break;
					}
				}
			}
			if (rest == 0) {
				break;
			}
		}
		long answer = 0;
		for (int i = 0; i < pos.length; i++) {
			long count = (LIMIT - i) / cycleSum + (i == 0 ? 0 : 1);
			answer += count * pos[i];
		}
		System.out.println(answer);
	}

	static int calcNextS(int s) {
		return (int) ((long) s * s % MODULO);
	}
}
