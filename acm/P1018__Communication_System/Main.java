package P1018__Communication_System;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

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
    static int n;
    static LinkedList<Manufacturer> devices[];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            n = cin.nextInt();
            int upperLimit = -1;
            devices = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                devices[i] = new LinkedList<Manufacturer> ();
                int m = cin.nextInt();
                for (int j = 0; j < m; j++) {
                    devices[i].add(new Manufacturer(cin.nextInt(), cin.nextInt()));
                }
                Collections.sort(devices[i], new MyComparator());
                int previous = -1;
                Iterator<Manufacturer> iterator = devices[i].listIterator();
                while (iterator.hasNext() == true) {
                    Manufacturer one = iterator.next();
                    if (previous == -1 || one.bandwidth > previous) {
                        previous = one.bandwidth;
                    }
                    else {
                        iterator.remove();
                    }
                }
                int temp = devices[i].getLast().bandwidth;
                if (upperLimit == -1 || temp < upperLimit) {
                    upperLimit = temp;
                }
            }
            double result = -1;
            for (int i = 0; i < n; i++) {
                Iterator<Manufacturer> iterator = devices[i].listIterator();
                while (iterator.hasNext() == true) {
                    Manufacturer one = iterator.next();
                    if (one.bandwidth <= upperLimit) {
                        double temp = search(one.bandwidth);
                        if (temp > result) {
                            result = temp;
                        }
                    }
                }
            }
            System.out.printf("%.3f\n", result);
        }
    }

    static double search(int B) {
        int P = 0;
        for (int i = 0; i < n; i++) {
            Iterator<Manufacturer> iterator = devices[i].listIterator();
            while (iterator.hasNext() == true) {
                Manufacturer one = iterator.next();
                if (one.bandwidth >= B) {
                    P += one.price;
                    break;
                }
            }
        }
        return (double) B / P;
    }
}

class MyComparator
    implements Comparator<Manufacturer> {
    public int compare(Manufacturer a, Manufacturer b) {
        if (a.price < b.price) {
            return -1;
        }
        if (a.price == b.price && a.bandwidth > b.bandwidth) {
            return -1;
        }
        return 1;
    }
}

class Manufacturer {
    int bandwidth;
    int price;
    public Manufacturer(int theBandwidth, int thePrice) {
        this.bandwidth = theBandwidth;
        this.price = thePrice;
    }
}
