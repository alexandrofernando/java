package P2606__Rabbit_Hunt;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;
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
        int N = cin.nextInt();
        Point points[] = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(cin.nextInt(), cin.nextInt());
        }
        Arrays.sort(points);
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                } else {
                    int divisor = gcd(dx, dy);
                    dx /= divisor;
                    dy /= divisor;
                }
                Dx_Dy d = new Dx_Dy(dx, dy);
                int number;
                if (points[j].map.containsKey(d) == true) {
                    number = points[j].map.get(d) + 1;
                } else {
                    number = 2;
                }
                if (points[i].map.containsKey(d) == false ||
                    points[i].map.get(d) < number) {
                    points[i].map.put(d, number);
                }
                if (number > result) {
                    result = number;
                }
            }
        }
        System.out.println(result);
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        } while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;
    TreeMap<Dx_Dy, Integer> map;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
        this.map = new TreeMap<Dx_Dy, Integer>();
    }

    public int compareTo(Point another) {
        if (this.x != another.x) {
            return this.x - another.x;
        } else {
            return this.y - another.y;
        }
    }
}


class Dx_Dy implements Comparable<Dx_Dy> {
    int dx;
    int dy;
    public Dx_Dy(int Dx, int Dy) {
        this.dx = Dx;
        this.dy = Dy;
    }

    public int compareTo(Dx_Dy another) {
        if (this.dx != another.dx) {
            return this.dx - another.dx;
        } else {
            return this.dy - another.dy;
        }
    }
}
