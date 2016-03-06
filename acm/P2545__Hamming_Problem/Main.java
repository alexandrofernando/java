package P2545__Hamming_Problem;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
        int p1 = cin.nextInt();
        int p2 = cin.nextInt();
        int p3 = cin.nextInt();
        int n = cin.nextInt();
        ArrayList<Long> sequence = new ArrayList<Long>();
        long a = 1;
        while (a > 0 && a < 1E18) {
            long b = a;
            while (b > 0 && b < 1E18) {
                long c = b;
                while (c > 0 && c < 1E18) {
                    sequence.add(c);
                    c *= p3;
                }
                b *= p2;
            }
            a *= p1;
        }
        Collections.sort(sequence);
        System.out.println(sequence.get(n));
    }
}
