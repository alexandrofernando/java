package P2828__Buy_Tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Node segmentTree[];

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		while (true) {
			String line = stdin.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int pos[] = new int[N];
			int val[] = new int[N];
			for (int i = 0; i < N; i++) {
				line = stdin.readLine();
				st = new StringTokenizer(line);
				pos[i] = Integer.parseInt(st.nextToken());
				val[i] = Integer.parseInt(st.nextToken());
			}

			segmentTree = new Node[(int) Math.pow(2,
					Math.ceil(Math.log(N) / Math.log(2)) + 1)];
			buildSegmentTree(0, N - 1, 0);
			int queue[] = new int[N];
			for (int i = N - 1; i >= 0; i--) {
				queue[query(pos[i] + 1, 0)] = val[i];
			}
			for (int i = 0; i < N; i++) {
				System.out.print(queue[i]);
				if (i != N - 1) {
					System.out.print(" ");
				} else {
					System.out.println();
				}
			}
		}
	}

	static int query(int empty, int index) {
		segmentTree[index].emptyNum--;
		if (segmentTree[index].lower == segmentTree[index].upper) {
			return segmentTree[index].lower;
		}
		if (segmentTree[index * 2 + 1].emptyNum >= empty) {
			return query(empty, index * 2 + 1);
		} else {
			return query(empty - segmentTree[index * 2 + 1].emptyNum,
					index * 2 + 2);
		}
	}

	static void buildSegmentTree(int lower, int upper, int index) {
		segmentTree[index] = new Node(lower, upper, upper - lower + 1);
		if (lower == upper) {
			return;
		}
		int mid = (lower + upper) / 2;
		buildSegmentTree(lower, mid, index * 2 + 1);
		buildSegmentTree(mid + 1, upper, index * 2 + 2);
	}
}

class Node {
	int lower;
	int upper;
	int emptyNum;

	public Node(int lower, int upper, int emptyNum) {
		this.lower = lower;
		this.upper = upper;
		this.emptyNum = emptyNum;
	}
}