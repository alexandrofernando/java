package P1089__Intervals;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
        int n = cin.nextInt();
        Interval intervals[] = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(cin.nextInt(), cin.nextInt());
        }
        Arrays.sort(intervals);
        int left = intervals[0].a;
        int right = intervals[0].b;
        for (int i = 1; i < n; i++) {
            if (intervals[i].a <= right) {
                if (intervals[i].b > right) {
                    right = intervals[i].b;
                }
            }
            else {
                System.out.println(left + " " + right);
                left = intervals[i].a;
                right = intervals[i].b;
            }
        }
        System.out.println(left + " " + right);
    }
}

class Interval
    implements Comparable<Interval> {
    int a;
    int b;
    public Interval(int A, int B) {
        this.a = A;
        this.b = B;
    }

    public int compareTo(Interval another) {
        if (this.a != another.a) {
            return this.a - another.a;
        }
        else {
            return another.b - this.b;
        }
    }
}
