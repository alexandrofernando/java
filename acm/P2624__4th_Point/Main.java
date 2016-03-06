package P2624__4th_Point;

import java.util.Scanner;
import java.io.File;

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
        while (cin.hasNextDouble() == true) {
            Point a = new Point(cin.nextDouble(), cin.nextDouble());
            Point b = new Point(cin.nextDouble(), cin.nextDouble());
            Point c = new Point(cin.nextDouble(), cin.nextDouble());
            Point d = new Point(cin.nextDouble(), cin.nextDouble());
            if (a.equals(c) == true) {
                Point temp = a;
                a = b;
                b = temp;
            } else if (a.equals(d) == true) {
                Point temp = a;
                a = b;
                b = temp;
                temp = c;
                c = d;
                d = temp;
            } else if (b.equals(d) == true) {
                Point temp = c;
                c = d;
                d = temp;
            }
            double resultX = d.x - c.x + a.x;
            double resultY = d.y - c.y + a.y;
            System.out.printf("%.3f %.3f\n", resultX, resultY);
        }
    }
}


class Point {
    double x;
    double y;
    public Point(double X, double Y) {
        this.x = X;
        this.y = Y;
    }

    public boolean equals(Point another) {
        if (this.x == another.x && this.y == another.y) {
            return true;
        } else {
            return false;
        }
    }
}
