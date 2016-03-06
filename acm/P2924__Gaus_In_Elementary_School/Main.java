package P2924__Gaus_In_Elementary_School;

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
            long n = cin.nextLong();
            long m = cin.nextLong();
            long sum = (n + m) * (m - n + 1) / 2;
            System.out.println("Scenario #" + t + ":");
            System.out.println(sum);
            System.out.println();
        }
    }
}
