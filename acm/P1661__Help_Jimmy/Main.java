package P1661__Help_Jimmy;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-6
 * Time: 6:56:33
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int MAX;
    static Platform platforms[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = in.nextInt();
            int X = in.nextInt();
            int Y = in.nextInt();
            MAX = in.nextInt();
            platforms = new Platform[N];
            for (int i = 0; i < N; i++) {
                platforms[i] = new Platform(in.nextInt(), in.nextInt(), in.nextInt());
            }
            Arrays.sort(platforms);
            for (int i = 0; i < N; i++) {
                platforms[i].time1 = search(platforms[i].x1, platforms[i].height, i);
                platforms[i].time2 = search(platforms[i].x2, platforms[i].height, i);
            }
            int time = search(X, Y, N);
            System.out.println(time);
        }
    }

    static int search(int x, int y, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (y - platforms[i].height > MAX) {
                return Integer.MAX_VALUE;
            }
            if (x >= platforms[i].x1 && x <= platforms[i].x2) {
                int temp1 = Integer.MAX_VALUE;
                int temp2 = Integer.MAX_VALUE;
                if (platforms[i].time1 != Integer.MAX_VALUE) {
                    temp1 = x - platforms[i].x1 + platforms[i].time1;
                }
                if (platforms[i].time2 != Integer.MAX_VALUE) {
                    temp2 = platforms[i].x2 - x + platforms[i].time2;
                }
                if (temp1 == Integer.MAX_VALUE && temp2 == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return y - platforms[i].height + Math.min(temp1, temp2);
                }
            }
        }
        if (y <= MAX) {
            return y;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}

class Platform implements Comparable<Platform> {
    int x1;
    int x2;
    int height;
    int time1;
    int time2;

    public Platform(int X1, int X2, int theHeight) {
        this.x1 = X1;
        this.x2 = X2;
        this.height = theHeight;
        this.time1 = Integer.MAX_VALUE;
        this.time2 = Integer.MAX_VALUE;
    }

    public int compareTo(Platform another) {
        return this.height - another.height;
    }
}