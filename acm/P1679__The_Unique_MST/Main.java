package P1679__The_Unique_MST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			int num_node = in.nextInt();
			int num_edge = in.nextInt();
			if (num_edge == 0) {
				System.out.println(0);
				continue;
			}
			HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
			for (int i = 0; i < num_edge; i++) {
				int n1 = in.nextInt();
				int n2 = in.nextInt();
				Node node1 = nodes.get(n1);
				if (node1 == null) {
					node1 = new Node(n1);
					nodes.put(n1, node1);
				}
				Node node2 = nodes.get(n2);
				if (node2 == null) {
					node2 = new Node(n2);
					nodes.put(n2, node2);
				}
				int weight = in.nextInt();
				Edge edge = new Edge(n1, n2, weight);
				node1.edges.add(edge);
				node2.edges.add(edge);
			}
			int MST_cost = 0;
			boolean unique = true;
			PriorityQueue<Element> queue = new PriorityQueue<Element>();
			boolean firstHead = true;
			queue.add(new Element(-1, nodes.keySet().iterator().next(), -1));
			for (int i = 0; i < num_node; i++) {
				if (unique) {
					Iterator<Element> iter = queue.iterator();
					int firstWeight = -1;
					boolean firstNode = true;
					while (iter.hasNext()) {
						Element e = iter.next();
						if (firstNode) {
							firstWeight = e.weight;
							firstNode = false;
						} else if (e.weight != firstWeight) {
							break;
						}
						if (nodes.get(e.to).visited) {
							iter.remove();
							continue;
						}

						if (!nodes.get(e.to).hasFrom) {
							nodes.get(e.to).hasFrom = true;
							nodes.get(e.to).from = e.from;
						} else if (nodes.get(e.to).from != e.from) {
							unique = false;
						}
					}
				}

				Element head;
				do {
					head = queue.poll();
				} while (nodes.get(head.to).visited);
				nodes.get(head.to).visited = true;
				if (firstHead) {
					firstHead = false;
				} else {
					MST_cost += head.weight;
				}

				Iterator<Edge> iter = nodes.get(head.to).edges.iterator();
				while (iter.hasNext()) {
					Edge e = iter.next();
					int nextNode;
					if (e.node1 != head.to) {
						nextNode = e.node1;
					} else {
						nextNode = e.node2;
					}
					if (nodes.get(nextNode).visited) {
						continue;
					}
					queue.add(new Element(head.to, nextNode, e.weight));
				}
			}
			if (unique) {
				System.out.println(MST_cost);
			} else {
				System.out.println("Not Unique!");
			}
		}
	}
}

class Edge {
	int node1;
	int node2;
	int weight;

	Edge(int n1, int n2, int theWeight) {
		if (n1 < n2) {
			node1 = n1;
			node2 = n2;
		} else {
			node1 = n2;
			node2 = n1;
		}
		weight = theWeight;
	}
}

class Node {
	int index;
	HashSet<Edge> edges;
	boolean visited;
	boolean hasFrom;
	int from;

	Node(int theIndex) {
		index = theIndex;
		edges = new HashSet<Edge>();
		visited = false;
		hasFrom = false;
	}
}

class Element implements Comparable<Element> {
	int from;
	int to;
	int weight;

	Element(int theFrom, int theTo, int theWeight) {
		from = theFrom;
		to = theTo;
		weight = theWeight;
	}

	public int compareTo(Element another) {
		return this.weight - another.weight;
	}
}