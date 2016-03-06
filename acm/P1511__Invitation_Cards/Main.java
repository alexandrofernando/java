package P1511__Invitation_Cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String line = stdin.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int test = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= test; t++) {
			line = stdin.readLine();
			st = new StringTokenizer(line);
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			ArrayList<Adjacent> goAdjacents[] = new ArrayList[P];
			ArrayList<Adjacent> backAdjacents[] = new ArrayList[P];
			for (int i = 0; i < P; i++) {
				goAdjacents[i] = new ArrayList<Adjacent>();
				backAdjacents[i] = new ArrayList<Adjacent>();
			}
			for (int i = 0; i < Q; i++) {
				line = stdin.readLine();
				st = new StringTokenizer(line);
				int origination = Integer.parseInt(st.nextToken()) - 1;
				int destination = Integer.parseInt(st.nextToken()) - 1;
				int price = Integer.parseInt(st.nextToken());
				goAdjacents[origination].add(new Adjacent(destination, price));
				backAdjacents[destination]
						.add(new Adjacent(origination, price));
			}

			long goCost = findAllShortestDists(goAdjacents, 0);
			long backCost = findAllShortestDists(backAdjacents, 0);
			System.out.println(goCost + backCost);
		}
	}

	static long findAllShortestDists(ArrayList<Adjacent> adjacents[], int start) {
		long totalDist = 0;
		int rest = adjacents.length;
		boolean used[] = new boolean[adjacents.length];
		PriorityQueue<Distance_Index> pq = new PriorityQueue<Distance_Index>();
		pq.offer(new Distance_Index(0, start));
		while (true) {
			Distance_Index head = pq.poll();
			if (used[head.index]) {
				continue;
			}
			used[head.index] = true;
			totalDist += head.distance;
			rest--;
			if (rest == 0) {
				break;
			}
			for (Adjacent adjacent : adjacents[head.index]) {
				if (!used[adjacent.to]) {
					pq.offer(new Distance_Index(head.distance + adjacent.price,
							adjacent.to));
				}
			}
		}
		return totalDist;
	}
}

class Distance_Index implements Comparable<Distance_Index> {
	long distance;
	int index;

	Distance_Index(long distance, int index) {
		this.distance = distance;
		this.index = index;
	}

	@Override
	public int compareTo(Distance_Index other) {
		return (int) Math.signum(distance - other.distance);
	}
}

class Adjacent {
	int to;
	int price;

	Adjacent(int to, int price) {
		this.to = to;
		this.price = price;
	}
}