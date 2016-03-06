package P3529__Wormholes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static int[] distances;
	static ArrayList<Edge> edges;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sk = new StringTokenizer(in.readLine());
		int test = Integer.parseInt(sk.nextToken());
		for (int t = 1; t <= test; t++) {
			sk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(sk.nextToken());
			int M = Integer.parseInt(sk.nextToken());
			int W = Integer.parseInt(sk.nextToken());
			visited = new boolean[N];
			distances = new int[N];
			edges = new ArrayList<Edge>();
			for (int i = 0; i < M; i++) {
				sk = new StringTokenizer(in.readLine());
				int S = Integer.parseInt(sk.nextToken()) - 1;
				int E = Integer.parseInt(sk.nextToken()) - 1;
				int T = Integer.parseInt(sk.nextToken());
				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));
			}
			for (int i = 0; i < W; i++) {
				sk = new StringTokenizer(in.readLine());
				int S = Integer.parseInt(sk.nextToken()) - 1;
				int E = Integer.parseInt(sk.nextToken()) - 1;
				int T = -Integer.parseInt(sk.nextToken());
				edges.add(new Edge(S, E, T));
			}
			boolean found = false;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					if (!bellman_ford(i)) {
						found = true;
						break;
					}
				}
			}
			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static boolean bellman_ford(int source) {
		visited[source] = true;
		distances[source] = 0;
		for (int i = 1; i <= N - 1; i++) {
			boolean changed = false;
			for (int j = 0; j < edges.size(); j++) {
				if (relax(j)) {
					changed = true;
				}
			}
			if (!changed) {
				break;
			}
		}
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if (distances[edge.end] > distances[edge.start] + edge.weight) {
				return false;
			}
		}
		return true;
	}

	static boolean relax(int edgeIndex) {
		Edge edge = edges.get(edgeIndex);
		if (distances[edge.end] > distances[edge.start] + edge.weight) {
			distances[edge.end] = distances[edge.start] + edge.weight;
			return true;
		}
		return false;
	}
}

class Edge {
	int start;
	int end;
	int weight;

	Edge(int theStart, int theEnd, int theWeight) {
		this.start = theStart;
		this.end = theEnd;
		this.weight = theWeight;
	}
}
