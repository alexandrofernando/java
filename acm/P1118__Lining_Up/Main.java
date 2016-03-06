package P1118__Lining_Up;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            Point points[] = new Point[N];
            for (int i = 0; i < N; i++) {
                points[i] = new Point(cin.nextInt(), cin.nextInt());
            }
            int result = 2;
            for (int i = 0; i < N; i++) {
                TreeMap<Slope, Integer> map = new TreeMap<Slope, Integer> ();
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        Slope s = new Slope(points[j].x - points[i].x,
                                            points[j].y - points[i].y);
                        if (map.containsKey(s) == true) {
                            int temp = map.get(s) + 1;
                            map.put(s, temp);
                            if (temp > result) {
                                result = temp;
                            }
                        }
                        else {
                            map.put(s, 2);
                        }
                    }
                }
            }
            System.out.println(result);
        }
        while (true);
    }
}

class Slope
    implements Comparable<Slope> {
    int dx;
    int dy;
    public Slope(int theDx, int theDy) {
        this.dx = theDx;
        this.dy = theDy;
    }

    public int compareTo(Slope another) {
        return this.dx * another.dy - another.dx * this.dy;
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
