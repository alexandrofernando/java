package P1828__Monkey_s_Pride;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
        while (true) {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            Point points[] = new Point[N];
            for (int i = 0; i < N; i++) {
                points[i] = new Point(cin.nextInt(), cin.nextInt());
            }
            Arrays.sort(points);
            int maxY = Integer.MIN_VALUE;
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (points[i].y > maxY) {
                    maxY = points[i].y;
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int compareTo(Point another) {
        if (this.x != another.x) {
            return another.x - this.x;
        } else {
            return another.y - this.y;
        }
    }
}
