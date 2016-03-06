package P1258__Agri_Net;

import java.util.Scanner;
import java.io.File;
import java.util.PriorityQueue;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt() == true) {
            int N = cin.nextInt();
            int distances[][] = new int[N][N];
            boolean used[] = new boolean[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distances[i][j] = cin.nextInt();
                }
            }
            PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
            used[0] = true;
            for (int i = 1; i < N; i++) {
                queue.add(new Edge(0, i, distances[0][i]));
            }
            int total = 0;
            for (int i = 0; i < N - 1; i++) {
                Edge edge;
                do {
                    edge = queue.poll();
                } while (used[edge.v2] == true);
                total += edge.length;
                used[edge.v2] = true;
                for (int j = 0; j < N; j++) {
                    if (used[j] == false) {
                        queue.add(new Edge(edge.v2, j, distances[edge.v2][j]));
                    }
                }
            }
            System.out.println(total);
        }
    }
}


class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int length;
    public Edge(int V1, int V2, int theLength) {
        this.v1 = V1;
        this.v2 = V2;
        this.length = theLength;
    }

    public int compareTo(Edge another) {
        return this.length - another.length;
    }
}
