package P1928__The_Peanuts;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
            int M = cin.nextInt();
            int N = cin.nextInt();
            int K = cin.nextInt();
            ArrayList<Point> points = new ArrayList<Point>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = cin.nextInt();
                    if (temp != 0) {
                        points.add(new Point(i, j, temp));
                    }
                }
            }
            Collections.sort(points);
            int result = 0;
            int preX = 0;
            int preY = 0;
            for (int i = 0; i < points.size(); i++) {
                int time;
                int spend;
                Point point = points.get(i);
                if (i == 0) {
                    time = (point.x + 1) * 2 + 1;
                    spend = point.x + 2;
                } else {
                    time = Math.abs(point.x - preX) + Math.abs(point.y - preY) +
                           point.x + 2;
                    spend = Math.abs(point.x - preX) + Math.abs(point.y - preY) +
                            1;
                }
                if (time <= K) {
                    result += point.peanut;
                    K -= spend;
                } else {
                    break;
                }
                preX = point.x;
                preY = point.y;
            }
            System.out.println(result);
        }
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;
    int peanut;
    public Point(int X, int Y, int thePeanut) {
        this.x = X;
        this.y = Y;
        this.peanut = thePeanut;
    }

    public int compareTo(Point another) {
        return another.peanut - this.peanut;
    }
}
