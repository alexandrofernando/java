package P2526__Center_Of_Symmetry;

import java.util.Scanner;
import java.io.File;
import java.util.HashSet;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            HashSet<Point> hashset = new HashSet<Point>();
            Point points[] = new Point[n];
            for (int i = 0; i < n; i++) {
                int x = cin.nextInt();
                int y = cin.nextInt();
                if (x < minX) {
                    minX = x;
                }
                if (x > maxX) {
                    maxX = x;
                }
                if (y < minY) {
                    minY = y;
                }
                if (y > maxY) {
                    maxY = y;
                }
                points[i] = new Point(x, y);
                hashset.add(points[i]);
            }
            int sumX = minX + maxX;
            int sumY = minY + maxY;
            boolean power = true;
            for (int i = 0; i < n; i++) {
                Point temp = new Point(sumX - points[i].x, sumY - points[i].y);
                if (hashset.contains(temp) == false) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
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

    public int hashCode() {
        return this.x + this.y;
    }

    public boolean equals(Object another) {
        Point a = (Point) another;
        if (this.x == a.x && this.y == a.y) {
            return true;
        } else {
            return false;
        }
    }
}
