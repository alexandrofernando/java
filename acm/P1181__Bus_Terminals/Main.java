package P1181__Bus_Terminals;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static int lengths[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        Point points[] = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(cin.nextInt(), cin.nextInt());
        }
        lengths = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lengths[i][j] = Point.getLength(points[i], points[j]);
            }
        }
        int D1 = 20000;
        for (int i = 0; i < N; i++) {
            int first = -1;
            int second = -1;
            for (int j = 0; j < N; j++) {
                if (lengths[i][j] > first) {
                    second = first;
                    first = lengths[i][j];
                }
                else if (lengths[i][j] > second) {
                    second = lengths[i][j];
                }
            }
            if (first + second < D1) {
                D1 = first + second;
            }
        }
        int D2 = 20000;
        if (N >= 4) {
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> array = new ArrayList<Integer> ();
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        array.add(j);
                    }
                }
                Collections.sort(array, new MyComparator(i));
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        int r1;
                        int r2 = -1;
                        int s = 20000;
                        for (int k = 0; k < N - 1; k++) {
                            int p = array.get(k);
                            if (p != j) {
                                if (lengths[p][j] > r2) {
                                    if (r2 != -1) {
                                        r1 = lengths[p][i];
                                        if (r1 + r2 < s) {
                                            s = r1 + r2;
                                        }
                                    }
                                    r2 = lengths[p][j];
                                }
                            }
                        }
                        if (s + lengths[i][j] < D2) {
                            D2 = s + lengths[i][j];
                        }
                    }
                }
            }
        }
        int D;
        if (D1 < D2) {
            D = D1;
        }
        else {
            D = D2;
        }
        System.out.println(D);
    }

    static class MyComparator
        implements Comparator<Integer> {
        int vertex;
        public MyComparator(int theVertex) {
            this.vertex = theVertex;
        }

        public int compare(Integer a, Integer b) {
            return lengths[vertex][b] - lengths[vertex][a];
        }
    }
}

class Point {
    int x;
    int y;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    static int getLength(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
