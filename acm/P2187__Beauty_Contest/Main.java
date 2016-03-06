package P2187__Beauty_Contest;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-1-21
 * Time: 20:46:34
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Point> farms = new ArrayList<Point>();
        for (int i = 0; i < N; i++) {
            farms.add(new Point(in.nextInt(), in.nextInt()));
        }
        int min = 0;
        for (int i = 1; i < farms.size(); i++) {
            if (farms.get(i).y < farms.get(min).y || (farms.get(i).y == farms.get(min).y && farms.get(i).x < farms.get(min).x)) {
                min = i;
            }
        }
        if (min != 0) {
            Point temp = farms.get(0);
            farms.set(0, farms.get(min));
            farms.set(min, temp);
        }
        Collections.sort(farms.subList(1, farms.size()), new MyComparator(farms.get(0)));
        for (int i = 1; i < farms.size() - 1; i++) {
            int x1 = farms.get(i).x - farms.get(0).x;
            int y1 = farms.get(i).y - farms.get(0).y;
            int x2 = farms.get(i + 1).x - farms.get(0).x;
            int y2 = farms.get(i + 1).y - farms.get(0).y;
            if (x2 * y1 == x1 * y2) {
                farms.remove(i + 1);
                i--;
            }
        }
        int max = 0;
        if (farms.size() == 2) {
            max = (farms.get(0).x - farms.get(1).x) * (farms.get(0).x - farms.get(1).x) + (farms.get(0).y - farms.get(1).y) * (farms.get(0).y - farms.get(1).y);
        } else {
            Stack<Point> convex = new Stack<Point>();
            convex.push(farms.get(0));
            convex.push(farms.get(1));
            convex.push(farms.get(2));
            for (int i = 3; i < farms.size(); i++) {
                Point p3 = farms.get(i);
                while (true) {
                    Point p1 = convex.get(convex.size() - 2);
                    Point p2 = convex.peek();
                    int x1 = p2.x - p1.x;
                    int y1 = p2.y - p1.y;
                    int x2 = p3.x - p1.x;
                    int y2 = p3.y - p1.y;
                    if (x1 * y2 - x2 * y1 > 0) {
                        break;
                    }
                    convex.pop();
                }
                convex.push(p3);
            }
            for (int i = 0; i < convex.size(); i++) {
                for (int j = i + 1; j < convex.size(); j++) {
                    int temp = (convex.get(i).x - convex.get(j).x) * (convex.get(i).x - convex.get(j).x) + (convex.get(i).y - convex.get(j).y) * (convex.get(i).y - convex.get(j).y);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static class MyComparator implements Comparator<Point> {
        Point point;

        public MyComparator(Point thePoint) {
            this.point = thePoint;
        }

        public int compare(Point point1, Point point2) {
            int x1 = point1.x - point.x;
            int y1 = point1.y - point.y;
            int x2 = point2.x - point.x;
            int y2 = point2.y - point.y;
            if (x2 * y1 == x1 * y2) {
                int d1 = x1 * x1 + y1 * y1;
                int d2 = x2 * x2 + y2 * y2;
                return d2 - d1;
            }
            double angle1 = Math.atan2(y1, x1);
            double angle2 = Math.atan2(y2, x2);
            if (angle1 < angle2) {
                return -1;
            } else {
                return 1;
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
}