package P1192__Optimal_Connective_Subset;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;

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
    static int max;
    static TreeMap<Point, Integer> map;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        map = new TreeMap<Point, Integer> ();
        for (int i = 0; i < N; i++) {
            map.put(new Point(cin.nextInt(), cin.nextInt()), cin.nextInt());
        }
        max = -100000;
        search(map.firstKey(), (int) 1E7, (int) 1E7);
        System.out.println(max);
    }

    static int search(Point point, int fromX, int fromY) {
        int sum = map.get(point);
        int offsetX[] = {
            -1, 0, 1, 0};
        int offsetY[] = {
            0, 1, 0, -1};
        int add = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = point.x + offsetX[i];
            int nextY = point.y + offsetY[i];
            if (nextX != fromX || nextY != fromY) {
                Point nextPoint = new Point(nextX, nextY);
                if (map.containsKey(nextPoint) == true) {
                    int temp = search(nextPoint, point.x, point.y);
                    if (temp > 0) {
                        add += temp;
                    }
                }
            }
        }
        sum += add;
        if (sum > max) {
            max = sum;
        }
        return sum;
    }
}

class Point
    implements Comparable<Point> {
    int x;
    int y;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int compareTo(Point another) {
        if (this.x != another.x) {
            return this.x - another.x;
        }
        else {
            return this.y - another.y;
        }
    }
}
