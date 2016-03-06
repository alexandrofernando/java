package P3468__A_Simple_Problem_with_Integers;

import java.util.Scanner;

public class Main {
	static long numbers[];
	static Interval intervals[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		numbers = new long[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = in.nextLong();
		}
		intervals = new Interval[(int) Math.pow(2,
				(int) (Math.log(N * 2 - 1) / Math.log(2)) + 1) - 1];
		intervals[0] = new Interval(0, N - 1);
		buildIntervals(0);

		for (int q = 0; q < Q; q++) {
			String command = in.next();
			int left = in.nextInt() - 1;
			int right = in.nextInt() - 1;
			if (command.equals("Q")) {
				System.out.println(query(left, right, 0, 0));
			} else if (command.equals("C")) {
				int C = in.nextInt();
				complement(left, right, 0, C);
			}
		}
	}

	static void buildIntervals(int index) {
		int middle = (intervals[index].begin + intervals[index].end) / 2;

		intervals[index * 2 + 1] = new Interval(intervals[index].begin, middle);
		if (intervals[index * 2 + 1].begin == intervals[index * 2 + 1].end) {
			intervals[index * 2 + 1].sum = numbers[intervals[index * 2 + 1].begin];
			intervals[index].sum += intervals[index * 2 + 1].sum;
		} else {
			buildIntervals(index * 2 + 1);
			intervals[index].sum += intervals[index * 2 + 1].sum;
		}

		intervals[index * 2 + 2] = new Interval(middle + 1,
				intervals[index].end);
		if (intervals[index * 2 + 2].begin == intervals[index * 2 + 2].end) {
			intervals[index * 2 + 2].sum = numbers[intervals[index * 2 + 2].begin];
			intervals[index].sum += intervals[index * 2 + 2].sum;
		} else {
			buildIntervals(index * 2 + 2);
			intervals[index].sum += intervals[index * 2 + 2].sum;
		}
	}

	static long query(int left, int right, int index, long add) {
		if (left == intervals[index].begin && right == intervals[index].end) {
			return intervals[index].sum + (intervals[index].addition + add)
					* (intervals[index].end - intervals[index].begin + 1);
		}
		long retVal = 0;
		if (intervals[index * 2 + 1].end >= left) {
			retVal += query(left,
					Math.min(intervals[index * 2 + 1].end, right),
					index * 2 + 1, add + intervals[index].addition);
		}
		if (intervals[index * 2 + 2].begin <= right) {
			retVal += query(Math.max(intervals[index * 2 + 2].begin, left),
					right, index * 2 + 2, add + intervals[index].addition);
		}
		return retVal;
	}

	static void complement(int left, int right, int index, long add) {
		if (left == intervals[index].begin && right == intervals[index].end) {
			intervals[index].addition += add;
			return;
		}
		if (intervals[index * 2 + 1].end >= left) {
			int nextRight = Math.min(intervals[index * 2 + 1].end, right);
			intervals[index].sum += (nextRight - left + 1) * add;
			complement(left, nextRight, index * 2 + 1, add);
		}
		if (intervals[index * 2 + 2].begin <= right) {
			int nextLeft = Math.max(intervals[index * 2 + 2].begin, left);
			intervals[index].sum += (right - nextLeft + 1) * add;
			complement(nextLeft, right, index * 2 + 2, add);
		}
	}
}

class Interval {
	int begin;
	int end;
	long sum;
	long addition;

	Interval(int theBegin, int theEnd) {
		this.begin = theBegin;
		this.end = theEnd;
	}
}
