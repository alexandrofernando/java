package P1065__Wooden_Sticks;

import java.util.Scanner;
import java.io.File;
import java.util.Comparator;
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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            Stick sticks[] = new Stick[n];
            for (int i = 0; i < n; i++) {
                sticks[i] = new Stick(cin.nextInt(), cin.nextInt());
            }
            Arrays.sort(sticks, new MyComparator());
            int finish = 0;
            int time = 0;
            while (finish < n) {
                time++;
                int currentL = -1;
                int currentW = -1;
                for (int i = 0; i < sticks.length; i++) {
                    if (sticks[i].used == false && sticks[i].length >= currentL &&
                        sticks[i].weight >= currentW) {
                        currentL = sticks[i].length;
                        currentW = sticks[i].weight;
                        sticks[i].used = true;
                        finish++;
                    }
                }
            }
            System.out.println(time);
        }
    }
}

class Stick {
    int length;
    int weight;
    boolean used;
    public Stick(int theLength, int theWeight) {
        this.length = theLength;
        this.weight = theWeight;
        this.used = false;
    }
}

class MyComparator
    implements Comparator<Stick> {
    public int compare(Stick a, Stick b) {
        if (a.length < b.length) {
            return -1;
        }
        else if (a.length > b.length) {
            return 1;
        }
        else {
            return a.weight - b.weight;
        }
    }
}
