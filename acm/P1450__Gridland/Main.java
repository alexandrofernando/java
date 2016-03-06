package P1450__Gridland;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            System.out.println("Scenario #" + t + ":");
            double length;
            if (m % 2 == 0 || n % 2 == 0) {
                length = m * n;
            } else {
                length = m * n + 0.41;
            }
            System.out.printf("%.2f\n", length);
            System.out.println();
        }
    }
}
