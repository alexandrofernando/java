package TripPlanning;

// Fluorum 2014
// https://codility.com/cert/view/certFMSQW2-PFSGEP9US7D858JJ

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
	public int[] solution(int K, int[] T) {
		reRoot(K, T);
		int[] orders = buildOrders(T);
		Node[] nodes = buildNodes(T);

		ArrayList<Integer> toRearranges = new ArrayList<Integer>();
		rearrange(nodes, orders, toRearranges);
		for (int toArrange : toRearranges) {
			nodes[K].children.add(toArrange);
			nodes[toArrange].parent = K;
		}

		ArrayList<DepthNIndex> leaves = new ArrayList<DepthNIndex>();
		searchLeaves(leaves, nodes, orders);

		Collections.sort(leaves);

		ArrayList<Integer> sequence = new ArrayList<Integer>();
		sequence.add(K);
		for (DepthNIndex di : leaves) {
			sequence.add(di.index);
		}

		int[] result = new int[sequence.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = sequence.get(i);
		}
		return result;
	}

	int[] buildOrders(int[] T) {
		int n = T.length;
		int[] degrees = new int[n];
		for (int current = 0; current < n; current++) {
			int parent = T[current];
			if (parent != current) {
				degrees[parent]++;
			}
		}

		int[] orders = new int[n];
		int orderIndex = 0;
		for (int i = 0; i < n; i++) {
			if (degrees[i] == 0) {
				orders[orderIndex] = i;
				orderIndex++;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int current = orders[i];
			int parent = T[current];
			degrees[parent]--;
			if (degrees[parent] == 0) {
				orders[orderIndex] = parent;
				orderIndex++;
			}
		}
		return orders;
	}

	void reRoot(int K, int[] T) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		int index = K;
		while (true) {
			path.add(index);
			if (T[index] == index) {
				break;
			}
			index = T[index];
		}

		for (int i = path.size() - 1; i > 0; i--) {
			T[path.get(i)] = path.get(i - 1);
		}
		T[K] = K;
	}

	Node[] buildNodes(int[] T) {
		Node[] nodes = new Node[T.length];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < T.length; i++) {
			if (i != T[i]) {
				nodes[i].parent = T[i];
				nodes[T[i]].children.add(i);
			}
		}

		return nodes;
	}

	void rearrange(Node[] nodes, int[] orders, ArrayList<Integer> toRearranges) {
		DepthNIndex[] mins = new DepthNIndex[nodes.length];
		int[] childWithMins = new int[nodes.length];
		for (int i = 0; i < orders.length - 1; i++) {
			int current = orders[i];
			Node node = nodes[current];
			DepthNIndex di;
			if (node.children.isEmpty()) {
				di = new DepthNIndex(1, current);
			} else {
				di = new DepthNIndex(mins[current].depth + 1,
						mins[current].index);
			}

			int parent = node.parent;
			if (mins[parent] == null || di.compareTo(mins[parent]) < 0) {
				mins[parent] = di;
				childWithMins[parent] = current;
			}

			if (!node.children.isEmpty()) {
				for (int child : node.children) {
					if (child != childWithMins[current]) {
						toRearranges.add(child);
					}
				}

				node.children.clear();
				node.children.add(childWithMins[current]);
			}
		}
	}

	void searchLeaves(ArrayList<DepthNIndex> leaves, Node[] nodes, int[] orders) {
		int[] depths = new int[nodes.length];
		depths[orders[orders.length - 1]] = 1;
		for (int i = orders.length - 2; i >= 0; i--) {
			int current = orders[i];
			int parent = nodes[current].parent;
			depths[current] = depths[parent] + 1;

			if (nodes[current].children.isEmpty()) {
				leaves.add(new DepthNIndex(depths[current], current));
			}
		}
	}
}

class Node {
	int index;
	int parent;
	HashSet<Integer> children = new HashSet<Integer>();

	Node(int index) {
		this.index = index;
	}
}

class DepthNIndex implements Comparable<DepthNIndex> {
	int depth;
	int index;

	DepthNIndex(int depth, int index) {
		this.depth = depth;
		this.index = index;
	}

	public int compareTo(DepthNIndex other) {
		if (depth != other.depth) {
			return other.depth - depth;
		}
		return index - other.index;
	}
}