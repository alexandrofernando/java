package P2301__Beat_The_Spread;

import java.util.Scanner;
import java.io.File;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int s = cin.nextInt();
            int d = cin.nextInt();
            if (s < d || (s + d) % 2 == 1) {
                System.out.println("impossible");
            }
            else {
                System.out.println( (s + d) / 2 + " " + (s - d) / 2);
            }
        }
    }
}
