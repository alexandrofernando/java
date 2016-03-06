package P3348__Cows;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-16
 * Time: 17:15:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> trees = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            trees.add(new Point(in.nextInt(), in.nextInt()));
        }
        int min = 0;
        for (int i = 1; i < trees.size(); i++) {
            if (trees.get(i).y < trees.get(min).y || (trees.get(i).y == trees.get(min).y && trees.get(i).x < trees.get(min).x)) {
                min = i;
            }
        }
        if (min != 0) {
            Point temp = trees.get(0);
            trees.set(0, trees.get(min));
            trees.set(min, temp);
        }
        Collections.sort(trees.subList(1, trees.size()), new MyComparator(trees.get(0)));
        for (int i = 1; i < trees.size() - 1; i++) {
            int x1 = trees.get(i).x - trees.get(0).x;
            int y1 = trees.get(i).y - trees.get(0).y;
            int x2 = trees.get(i + 1).x - trees.get(0).x;
            int y2 = trees.get(i + 1).y - trees.get(0).y;
            if (x2 * y1 == x1 * y2) {
                trees.remove(i + 1);
                i--;
            }
        }
        if (trees.size() < 3) {
            System.out.println(0);
        } else {
            Stack<Point> convex = new Stack<Point>();
            convex.push(trees.get(0));
            convex.push(trees.get(1));
            convex.push(trees.get(2));
            for (int i = 3; i < trees.size(); i++) {
                Point p3 = trees.get(i);
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
            int area = 0;
            for (int i = 0; i < convex.size(); i++) {
                area += convex.get(i).x * convex.get((i + 1) % convex.size()).y - convex.get(i).y * convex.get((i + 1) % convex.size()).x;
            }
            System.out.println(area / 100);
        }
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