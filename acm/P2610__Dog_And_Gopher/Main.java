package P2610__Dog_And_Gopher;

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
        Point gopher = new Point(cin.nextDouble(), cin.nextDouble());
        Point dog = new Point(cin.nextDouble(), cin.nextDouble());
        boolean escape = false;
        while (cin.hasNextDouble() == true) {
            Point hole = new Point(cin.nextDouble(), cin.nextDouble());
            double distance1 = Point.distance(gopher, hole);
            double distance2 = Point.distance(dog, hole);
            if (distance1 * 2 < distance2) {
                System.out.printf(
                        "The gopher can escape through the hole at (%.3f,%.3f).\n",
                        hole.x, hole.y);
                escape = true;
                break;
            }
        }
        if (escape == false) {
            System.out.println("The gopher cannot escape.");
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

    static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
