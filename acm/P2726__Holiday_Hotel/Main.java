package P2726__Holiday_Hotel;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

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
            Holiday holidays[] = new Holiday[N];
            for (int i = 0; i < N; i++) {
                holidays[i] = new Holiday(cin.nextInt(), cin.nextInt());
            }
            Arrays.sort(holidays, new MyComparator1());
            int min1 = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (holidays[i].cost < min1) {
                    holidays[i].condition1 = true;
                    min1 = holidays[i].cost;
                } else {
                    holidays[i].condition1 = false;
                }
            }
            Arrays.sort(holidays, new MyComparator2());
            int min2 = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (holidays[i].distance < min2) {
                    holidays[i].condition2 = true;
                    min2 = holidays[i].distance;
                } else {
                    holidays[i].condition2 = false;
                }
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (holidays[i].condition1 == true && holidays[i].condition2 == true) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}


class Holiday {
    int distance;
    int cost;
    boolean condition1;
    boolean condition2;
    public Holiday(int theDistance, int theCost) {
        this.distance = theDistance;
        this.cost = theCost;
    }
}


class MyComparator1 implements Comparator<Holiday> {
    public int compare(Holiday a, Holiday b) {
        if (a.distance != b.distance) {
            return a.distance - b.distance;
        } else {
            return b.cost - a.cost;
        }
    }
}


class MyComparator2 implements Comparator<Holiday> {
    public int compare(Holiday a, Holiday b) {
        if (a.cost != b.cost) {
            return a.cost - b.cost;
        } else {
            return b.distance - a.distance;
        }
    }
}
