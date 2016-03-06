package P3018__Giftbox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.
                in));
        while (true) {
            String line = stdin.readLine();
            if (line == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens() == false) {
                break;
            }
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int boxes[][] = new int[n + 1][d];
            for (int i = 0; i < n + 1; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                for (int j = 0; j < d; j++) {
                    boxes[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(boxes[i]);
            }
            ArrayList<Edge> edges = new ArrayList<Edge>();
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i != j && contain(boxes[i], boxes[j]) == true) {
                        edges.add(new Edge(i, j));
                    }
                }
            }
            int D[] = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                D[i] = Integer.MAX_VALUE;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < edges.size(); j++) {
                    Edge edge = edges.get(j);
                    if (D[edge.from] != Integer.MAX_VALUE &&
                        D[edge.from] - 1 < D[edge.to]) {
                        D[edge.to] = D[edge.from] - 1;
                    }
                }
            }
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                if (D[i] < result) {
                    result = D[i];
                }
            }
            if (result >= 0) {
                System.out.println("Please look for another gift shop!");
            } else {
                System.out.println( -result);
            }
        }
    }

    static boolean contain(int inner[], int outer[]) {
        for (int i = 0; i < inner.length; i++) {
            if (inner[i] >= outer[i]) {
                return false;
            }
        }
        return true;
    }
}


class Edge {
    int from;
    int to;
    public Edge(int theFrom, int theTo) {
        this.from = theFrom;
        this.to = theTo;
    }
}
