package P2007__Scrambled_Polygon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 18:13:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        in.nextInt();
        ArrayList<Point> points = new ArrayList<Point>();
        boolean quadrants[] = new boolean[5];
        while (in.hasNextInt() == true) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x, y));
            if (x > 0 && y > 0) {
                quadrants[1] = true;
            } else if (x < 0 && y > 0) {
                quadrants[2] = true;
            } else if (x < 0 && y < 0) {
                quadrants[3] = true;
            } else {
                quadrants[4] = true;
            }
        }
        if (quadrants[1] == false || quadrants[4] == false) {
            for (int i = 0; i < points.size(); i++) {
                Point point = points.get(i);
                if (point.angle < 0) {
                    point.angle += 360;
                }
            }
        }
        Collections.sort(points);
        System.out.println("(0,0)");
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            System.out.println("(" + point.x + "," + point.y + ")");
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    double angle;

    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
        this.angle = Math.atan2(Y, X);
    }

    public int compareTo(Point another) {
        if (this.angle < another.angle) {
            return -1;
        } else {
            return 1;
        }
    }
}