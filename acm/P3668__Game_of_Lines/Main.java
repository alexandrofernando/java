package P3668__Game_of_Lines;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-7
 * Time: 1:06:25
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int x[] = new int[N];
        int y[] = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        ArrayList<Slope> slopes = new ArrayList<Slope>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                slopes.add(new Slope(x[i] - x[j], y[i] - y[j]));
            }
        }
        Collections.sort(slopes);
        int result = 1;
        for (int i = 1; i < slopes.size(); i++) {
            Slope s1 = slopes.get(i - 1);
            Slope s2 = slopes.get(i);
            if (s1.x * s2.y != s1.y * s2.x) {
                result++;
            }
        }
        System.out.println(result);
    }
}

class Slope implements Comparable<Slope> {
    int x;
    int y;
    double angle;

    Slope(int X, int Y) {
        this.x = X;
        this.y = Y;
        this.angle = Math.atan2(Y, X);
        if (this.angle < 0) {
            this.angle += Math.PI * 2;
        }
        if (this.angle >= Math.PI) {
            this.angle -= Math.PI;
        }
    }

    public int compareTo(Slope another) {
        if (this.angle < another.angle) {
            return -1;
        } else {
            return 1;
        }
    }
}