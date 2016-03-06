package P1631__Bridging_signals;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-8
 * Time: 6:58:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int p = in.nextInt();
            int ports[] = new int[p];
            int largest = 0;
            ArrayList<Integer> lasts = new ArrayList<Integer>();
            lasts.add(Integer.MIN_VALUE);
            for (int i = 0; i < p; i++) {
                ports[i] = in.nextInt();
                int pos = Collections.binarySearch(lasts, ports[i]);
                pos = -pos - 1;
                if (pos == lasts.size()) {
                    lasts.add(ports[i]);
                    largest++;
                } else {
                    lasts.set(pos, ports[i]);
                }
            }
            System.out.println(largest);
        }
    }
}
