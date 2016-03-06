package P1328__Radar_Installation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 23:40:40
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int n = in.nextInt();
            int d = in.nextInt();
            if (n == 0 && d == 0) {
                break;
            }
            boolean possible = true;
            ArrayList<Interval> intervals = new ArrayList<Interval>();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if (y > d) {
                    possible = false;
                }
                if (possible == true) {
                    double temp = Math.sqrt(d * d - y * y);
                    intervals.add(new Interval(x - temp, x + temp));
                }
            }
            System.out.print("Case " + test + ": ");
            test++;
            if (possible == false) {
                System.out.println(-1);
            } else {
                Collections.sort(intervals);
                for (int i = 0; i < intervals.size() - 1; i++) {
                    Interval a = intervals.get(i);
                    Interval b = intervals.get(i + 1);
                    if (a.end - b.end > -1E-9) {
                        intervals.remove(i);
                        i--;
                        if (i > -1) {
                            i--;
                        }
                    }
                }
                int result = 0;
                double previous = -Double.MAX_VALUE;
                for (int i = 0; i < intervals.size(); i++) {
                    Interval temp = intervals.get(i);
                    if (temp.start - previous > 1E-9) {
                        previous = temp.end;
                        result++;
                    }
                }
                System.out.println(result);
            }
        }
    }
}

class Interval implements Comparable<Interval> {
    double start;
    double end;

    public Interval(double theStart, double theEnd) {
        this.start = theStart;
        this.end = theEnd;
    }

    public int compareTo(Interval another) {
        if (Math.abs(this.start - another.start) > 1E-9) {
            if (this.start < another.start) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (Math.abs(this.end - another.end) < 1E-9) {
                return 0;
            } else if (this.end < another.end) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}