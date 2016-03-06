package GasStations;

// Theta 2011
// http://codility.com/demo/results/demoVNRS7K-YRT/

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	static final int LIMIT = 1000000000;

	public int solution(int[] D, int[] P, int T) {
		for (int distance : D) {
			if (distance > T) {
				return -1;
			}
		}

		LinkedList<Station> stations = new LinkedList<Station>();
		int[] prices = Arrays.copyOf(P, P.length + 1);
		stations.offer(new Station(0));
		long cost = 0;
		for (int i = 0; i < D.length; i++) {
			int distance = D[i];
			while (distance > 0) {
				Station head = stations.peek();
				int delta = Math.min(distance, T - head.getFuel());
				distance -= delta;
				head.refill += delta;
				if (head.getFuel() == T) {
					cost += getCost(prices, head);
					if (cost > LIMIT) {
						return -2;
					}
					stations.poll();
					if (!stations.isEmpty()) {
						stations.peek().base += getEarn(D, head);
					}
				}
			}
			Station added = new Station(i + 1);
			while (!stations.isEmpty()
					&& prices[stations.getLast().index] >= prices[i + 1]) {
				Station tail = stations.removeLast();
				cost += getCost(prices, tail);
				if (cost > LIMIT) {
					return -2;
				}
				added.base += getEarn(D, tail);
			}
			stations.offer(added);
		}
		return (int) cost;
	}

	long getCost(int[] prices, Station station) {
		return (long) prices[station.index] * station.refill;
	}

	int getEarn(int[] distances, Station station) {
		return station.getFuel() - distances[station.index];
	}
}

class Station {
	int index;
	int base;
	int refill;

	public Station(int index) {
		this.index = index;
	}

	int getFuel() {
		return base + refill;
	}
}