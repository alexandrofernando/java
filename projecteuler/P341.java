// VM arguments: -Xms32m -Xmx1000m

import java.util.LinkedList;
import java.util.Queue;

public class P341 {
	public static void main(String args[]) {
		final int LIMIT = 1000000;
		final long EXPAND_LIMIT = 200000000000L;
		long sum = 1;
		long n = 2;
		long nnn = n * n * n;
		Queue<Seed> queue = new LinkedList<Seed>();
		queue.offer(new Seed(3, 3, 2));
		long frontN = 4;
		while (n < LIMIT) {
			Seed head = queue.peek();
			boolean changed = false;
			if (frontN < EXPAND_LIMIT) {
				queue.offer(new Seed(frontN, frontN + head.g - 1, head.beginN));

			} else {
				long maxFrontN = frontN + (head.endN - head.beginN + 1)
						* head.g;
				if (nnn >= maxFrontN) {
					frontN = maxFrontN;
					queue.poll();
					changed = true;
				}
			}
			if (!changed) {
				long oldBeginN = head.beginN;
				frontN += head.g;
				if (head.beginN < head.endN) {
					head.beginN++;
				} else {
					queue.poll();
				}
				while (nnn < frontN) {
					sum += oldBeginN;
					n++;
					nnn = n * n * n;
				}
			}
		}
		System.out.println(sum);
	}
}

class Seed {
	long beginN;
	long endN;
	long g;

	Seed(long beginN, long endN, long g) {
		this.beginN = beginN;
		this.endN = endN;
		this.g = g;
	}
}