package P1127__Jack_Straws;

import java.util.Scanner;
import java.io.File;

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
    static int n;
    static boolean connects[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            n = cin.nextInt();
            if (n == 0) {
                break;
            }
            Line lines[] = new Line[n];
            for (int i = 0; i < n; i++) {
                lines[i] = new Line(cin.nextInt(), cin.nextInt(), cin.nextInt(),
                                    cin.nextInt());
            }
            connects = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    connects[i][j] = Line.isIntersect(lines[i], lines[j]);
                }
            }
            transmit();
            do {
                int a = cin.nextInt();
                int b = cin.nextInt();
                if (a == 0 && b == 0) {
                    break;
                }
                if (connects[a - 1][b - 1] == true) {
                    System.out.println("CONNECTED");
                }
                else {
                    System.out.println("NOT CONNECTED");
                }
            }
            while (true);
        }
        while (true);
    }

    static void transmit() {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (connects[i][j] == true) {
                    for (int k = 0; k < n; k++) {
                        connects[i][k] = connects[i][k] || connects[j][k];
                    }
                }
            }
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

    static Point subtract(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }

    static int crossProduct(Point a, Point b) {
        return a.x * b.y - b.x * a.y;
    }
}

class Line {
    Point p1;
    Point p2;
    public Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    static boolean isIntersect(Line a, Line b) {
        int d1 = direction(b.p1, b.p2, a.p1);
        int d2 = direction(b.p1, b.p2, a.p2);
        int d3 = direction(a.p1, a.p2, b.p1);
        int d4 = direction(a.p1, a.p2, b.p2);
        if ( ( (d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
            ( (d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
            return true;
        }
        else if (d1 == 0 && onSegment(b.p1, b.p2, a.p1) == true) {
            return true;
        }
        else if (d2 == 0 && onSegment(b.p1, b.p2, a.p2) == true) {
            return true;
        }
        else if (d3 == 0 && onSegment(a.p1, a.p2, b.p1) == true) {
            return true;
        }
        else if (d4 == 0 && onSegment(a.p1, a.p2, b.p2) == true) {
            return true;
        }
        else {
            return false;
        }
    }

    private static int direction(Point a, Point b, Point c) {
        return Point.crossProduct(Point.subtract(c, a), Point.subtract(c, b));
    }

    private static boolean onSegment(Point a, Point b, Point c) {
        if (c.x >= Math.min(a.x, b.x) && c.x <= Math.max(a.x, b.x) &&
            c.y >= Math.min(a.y, b.y) && c.y <= Math.max(a.y, b.y)) {
            return true;
        }
        else {
            return false;
        }
    }
}
