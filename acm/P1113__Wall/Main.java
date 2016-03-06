package P1113__Wall;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-3
 * Time: 18:54:34
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int N;
    static ArrayList<Point> points;

    public static void main(String args[]) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        points = new ArrayList<Point>();
        for (int i = 0; i < N; i++) {
            line = stdin.readLine();
            st = new StringTokenizer(line);
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (points.get(i).y < points.get(min).y || (points.get(i).y == points.get(min).y && points.get(i).x < points.get(min).x)) {
                min = i;
            }
        }
        if (min != 0) {
            Point temp = points.get(0);
            points.set(0, points.get(min));
            points.set(min, temp);
        }
        Collections.sort(points.subList(1, points.size()), new MyComparator());
        for (int i = 1; i < points.size() - 1; i++) {
            int x1 = points.get(i).x - points.get(0).x;
            int y1 = points.get(i).y - points.get(0).y;
            int x2 = points.get(i + 1).x - points.get(0).x;
            int y2 = points.get(i + 1).y - points.get(0).y;
            if (x2 * y1 == x1 * y2) {
                points.remove(i + 1);
                i--;
            }
        }
        Stack<Point> stack = new Stack<Point>();
        stack.push(points.get(0));
        stack.push(points.get(1));
        stack.push(points.get(2));
        for (int i = 3; i < points.size(); i++) {
            Point p3 = points.get(i);
            while (true) {
                Point p1 = stack.get(stack.size() - 2);
                Point p2 = stack.peek();
                int x1 = p2.x - p1.x;
                int y1 = p2.y - p1.y;
                int x2 = p3.x - p1.x;
                int y2 = p3.y - p1.y;
                if (x1 * y2 - x2 * y1 > 0) {
                    break;
                }
                stack.pop();
            }
            stack.push(p3);
        }
        double result = 0;
        for (int i = 0; i < stack.size(); i++) {
            int x1 = stack.get(i).x;
            int y1 = stack.get(i).y;
            int x2 = stack.get((i + 1) % stack.size()).x;
            int y2 = stack.get((i + 1) % stack.size()).y;
            result += Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }
        result += 2 * Math.PI * L;
        System.out.println(Math.round(result));
    }

    static class MyComparator implements Comparator<Point> {
        public int compare(Point point1, Point point2) {
            int x1 = point1.x - points.get(0).x;
            int y1 = point1.y - points.get(0).y;
            int x2 = point2.x - points.get(0).x;
            int y2 = point2.y - points.get(0).y;
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