package P2002__Squares;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-3-15
 * Time: 21:46:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static Point points[];
    static HashMap<Point, Integer> map;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            points = new Point[n];
            boolean adjacents[][] = new boolean[n][n];
            map = new HashMap<Point, Integer>();
            for (int i = 0; i < n; i++) {
                points[i] = new Point(in.nextInt(), in.nextInt());
                map.put(points[i], i);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && !adjacents[i][j]) {
                        int p3 = next(i, j);
                        if (p3 == -1) {
                            continue;
                        }
                        int p4 = next(j, p3);
                        if (p4 == -1) {
                            continue;
                        }
                        adjacents[i][j] = true;
                        adjacents[j][p3] = true;
                        adjacents[p3][p4] = true;
                        adjacents[p4][i] = true;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static int next(int p0, int p1) {
        int x = -(points[p0].y - points[p1].y) + points[p1].x;
        int y = points[p0].x - points[p1].x + points[p1].y;
        Integer index = map.get(new Point(x, y));
        if (index != null) {
            return index;
        } else {
            return -1;
        }
    }
}

class Point {
    int x;
    int y;

    Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int hashCode() {
        return this.x * 20000 + this.y;
    }

    public boolean equals(Object o) {
        Point another = (Point) o;
        if (this.x == another.x && this.y == another.y) {
            return true;
        } else {
            return false;
        }
    }
}