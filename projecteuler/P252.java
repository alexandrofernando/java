import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P252 {
	static int S = 290797;
	static double maxArea = 0;

	public static void main(String args[]) {
		final int POINT_NUM = 500;
		Point points[] = new Point[POINT_NUM];
		for (int i = 0; i < POINT_NUM; i++) {
			points[i] = new Point(nextT(), nextT());
		}
		searchEmptyConvexPolygons(points);
		System.out.printf("%.1f\n", maxArea);
	}

	static int nextT() {
		S = (int) ((long) S * S % 50515093);
		int T = S % 2000 - 1000;
		return T;
	}

	static void searchEmptyConvexPolygons(Point v[]) {
		for (int i = 0; i < v.length; i++) {
			ArrayList<Point> vp = removeAndSort(v, i);
			Graph vgp = computeVisibilityGraph(vp);
			reportEmptyConvexPolygons(v[i], vp, vgp);
		}
	}

	static void reportEmptyConvexPolygons(Point p0, ArrayList<Point> vp,
			Graph vgp) {
		HashMap<Edge, ArrayList<ArrayList<Point>>> chainsMap = new HashMap<Edge, ArrayList<ArrayList<Point>>>();
		for (int i = 0; i < vp.size() - 1; i++) {
			chainsTreat(i, p0, vp, vgp, chainsMap);
		}
	}

	@SuppressWarnings("unchecked")
	static void chainsTreat(int indexP, Point p0, ArrayList<Point> vp,
			Graph vgp, HashMap<Edge, ArrayList<ArrayList<Point>>> chainsMap) {
		int imax = vgp.incomingEdges[indexP].size() - 1;
		int omax = vgp.outgoingEdges[indexP].size() - 1;
		ArrayList<Edge> outgoingEdgesConvex = (ArrayList<Edge>) vgp.outgoingEdges[indexP]
				.clone();

		for (int j = 0; j <= omax; j++) {
			Edge outJ = vgp.getOutgoing(indexP, j);
			ArrayList<Point> chain = create(p0, vp, outJ);
			computeAreaAndUpdateMax(chain);
			ArrayList<ArrayList<Point>> chains = new ArrayList<ArrayList<Point>>();
			chains.add(chain);
			chainsMap.put(outJ, chains);
		}
		int m = 0;
		int om = omax;
		for (int j = 0; j <= imax; j++) {
			Edge inJ = vgp.getIncoming(indexP, j);
			while (true) {
				if (m > omax) {
					break;
				}
				Edge outM = vgp.getOutgoing(indexP, m);
				if (isTurnNonRight(vp.get(inJ.from), vp.get(indexP),
						vp.get(outM.to))) {
					break;
				}
				outgoingEdgesConvex.remove(outM);
				om--;
				m++;
			}
			for (ArrayList<Point> ch : chainsMap.get(inJ)) {
				for (int t = 0; t <= om; t++) {
					Edge outTConvex = outgoingEdgesConvex.get(t);
					ch.add(vp.get(outTConvex.to));
					computeAreaAndUpdateMax(ch);
					chainsMap.get(outTConvex)
							.add((ArrayList<Point>) ch.clone());
					ch.remove(ch.size()-1);
				}
			}
		}
	}

	static void computeAreaAndUpdateMax(ArrayList<Point> chain) {
		double area = 0;
		for (int i = 0; i < chain.size(); i++) {
			Point p1 = chain.get(i);
			Point p2 = chain.get((i + 1) % chain.size());
			area += p1.x * p2.y - p2.x * p1.y;
		}
		area = Math.abs(area / 2);
		maxArea = Math.max(maxArea, area);
	}

	static ArrayList<Point> create(Point p0, ArrayList<Point> vp, Edge edge) {
		ArrayList<Point> chain = new ArrayList<Point>();
		chain.add(p0);
		chain.add(vp.get(edge.from));
		chain.add(vp.get(edge.to));
		return chain;
	}

	@SuppressWarnings("unchecked")
	static Graph computeVisibilityGraph(ArrayList<Point> vp) {
		Graph vgp = new Graph(vp.size());
		Queue<Integer> q[] = new Queue[vp.size()];
		for (int i = 0; i < q.length; i++) {
			q[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < vp.size() - 1; i++) {
			proceed(i, i + 1, vp, q, vgp);
		}
		return vgp;
	}

	static void proceed(int i, int j, ArrayList<Point> vp, Queue<Integer> q[],
			Graph vgp) {
		while (!q[i].isEmpty()
				&& isTurnNonRight(vp.get(q[i].peek()), vp.get(i), vp.get(j))) {
			proceed(q[i].peek(), j, vp, q, vgp);
			q[i].poll();
		}
		vgp.addEdge(i, j);
		q[j].offer(i);
	}

	static boolean isTurnNonRight(Point p1, Point p2, Point p3) {
		return computeCrossProduct(Point.substract(p3, p2),
				Point.substract(p2, p1)) <= 0;
	}

	static long computeCrossProduct(Point p1, Point p2) {
		return (long) p1.x * p2.y - (long) p2.x * p1.y;
	}

	static ArrayList<Point> removeAndSort(Point v[], int indexP) {
		ArrayList<Point> vp = new ArrayList<Point>();
		for (int i = 0; i < v.length; i++) {
			if (i == indexP) {
				continue;
			}
			if (v[i].x < v[indexP].x
					|| (v[i].x == v[indexP].x && v[i].y <= v[indexP].y)) {
				continue;
			}
			vp.add(v[i]);
		}
		Collections.sort(vp, new AngleComparator(v[indexP]));
		return vp;
	}
}

class Edge {
	int from;
	int to;

	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		return from * to;
	}

	@Override
	public boolean equals(Object obj) {
		Edge other = (Edge) obj;
		return from == other.from && to == other.to;
	}
}

class Graph {
	ArrayList<Edge> incomingEdges[];
	ArrayList<Edge> outgoingEdges[];

	@SuppressWarnings("unchecked")
	Graph(int size) {
		incomingEdges = new ArrayList[size];
		outgoingEdges = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			incomingEdges[i] = new ArrayList<Edge>();
			outgoingEdges[i] = new ArrayList<Edge>();
		}
	}

	void addEdge(int from, int to) {
		Edge edge = new Edge(from, to);
		outgoingEdges[from].add(edge);
		incomingEdges[to].add(edge);
	}

	Edge getIncoming(int vertexIndex, int edgeIndex) {
		return incomingEdges[vertexIndex].get(edgeIndex);
	}

	Edge getOutgoing(int vertexIndex, int edgeIndex) {
		return outgoingEdges[vertexIndex].get(edgeIndex);
	}
}

class AngleComparator implements Comparator<Point> {
	Point p0;

	public AngleComparator(Point p0) {
		this.p0 = p0;
	}

	@Override
	public int compare(Point p1, Point p2) {
		double angle1 = Math.atan2(p1.y - p0.y, p1.x - p0.x);
		double angle2 = Math.atan2(p2.y - p0.y, p2.x - p0.x);
		return (int) Math.signum(angle1 - angle2);
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static Point substract(Point p1, Point p2) {
		return new Point(p1.x - p2.x, p1.y - p2.y);
	}
}