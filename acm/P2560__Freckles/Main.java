package P2560__Freckles;

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
        int n = cin.nextInt();
        Point points[] = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(cin.nextDouble(), cin.nextDouble());
        }
        points[0].used = true;
        PriorityQueue<Distance> order = new PriorityQueue<Distance>();
        for (int i = 1; i < n; i++) {
            order.offer(new Distance(0, i, Point.getDis(points[0], points[i])));
        }
        double total = 0;
        for (int i = 0; i < n - 1; i++) {
            Distance head;
            do {
                head = order.poll();
            } while (points[head.v2].used == true);
            total += head.distance;
            points[head.v2].used = true;
            for (int j = 0; j < n; j++) {
                if (j != head.v2 && points[j].used == false) {
                    order.offer(new Distance(head.v2, j,
                                             Point.getDis(points[head.v2],
                            points[j])));
                }
            }
        }
        System.out.printf("%.2f\n", total);
    }
}


class Point {
    double x;
    double y;
    boolean used;
    public Point(double X, double Y) {
        this.x = X;
        this.y = Y;
        this.used = false;
    }

    static double getDis(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}


class Distance implements Comparable<Distance> {
    int v1;
    int v2;
    double distance;
    public Distance(int V1, int V2, double theDistance) {
        this.v1 = V1;
        this.v2 = V2;
        this.distance = theDistance;
    }

    public int compareTo(Distance another) {
        if (this.distance < another.distance) {
            return -1;
        } else if (this.distance > another.distance) {
            return 1;
        } else {
            return 0;
        }
    }
}
