package P2657__Comfort;

import java.util.Scanner;
import java.io.File;

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
        int Z = cin.nextInt();
        int M = cin.nextInt();
        int obstacles[] = new int[M];
        for (int i = 0; i < M; i++) {
            obstacles[i] = cin.nextInt();
        }
        for (int i = 1; i <= Z - 1; i++) {
            Cycle_Step cs = new Cycle_Step(modularLinearMin(N,
                    (i - (Z - 1) % i) % i, i), Z - 1);
            boolean power = true;
            for (int j = 0; j < M; j++) {
                Cycle_Step temp = new Cycle_Step(modularLinearMin(N,
                        (i - (obstacles[j] - 1) % i) % i, i), obstacles[j] - 1);
                if (temp.compareTo(cs) < 0) {
                    power = false;
                    break;
                }
            }
            if (power == true) {
                System.out.println(i);
                break;
            }
        }
    }

    static int modularLinearMin(int a, int b, int n) {
        D_X_Y dxy = extendedEuclid(a, n);
        int min = Integer.MAX_VALUE;
        if (b % dxy.d == 0) {
            int x0 = dxy.x * b / dxy.d;
            for (int i = 0; i < dxy.d; i++) {
                int x = (x0 + i * n / dxy.d) % n;
                x = (x % n + n) % n;
                if (x < min) {
                    min = x;
                }
            }
        }
        return min;
    }

    static D_X_Y extendedEuclid(int a, int b) {
        if (b == 0) {
            return new D_X_Y(a, 1, 0);
        }
        D_X_Y dxy = extendedEuclid(b, a % b);
        return new D_X_Y(dxy.d, dxy.y, dxy.x - a / b * dxy.y);
    }
}


class D_X_Y {
    int d;
    int x;
    int y;
    public D_X_Y(int D, int X, int Y) {
        this.d = D;
        this.x = X;
        this.y = Y;
    }
}


class Cycle_Step implements Comparable<Cycle_Step> {
    int cycle;
    int step;
    public Cycle_Step(int theCycle, int theStep) {
        this.cycle = theCycle;
        this.step = theStep;
    }

    public int compareTo(Cycle_Step another) {
        if (this.cycle != another.cycle) {
            return this.cycle - another.cycle;
        } else {
            return this.step - another.step;
        }
    }
}
