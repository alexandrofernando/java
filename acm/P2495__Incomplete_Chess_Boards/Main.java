package P2495__Incomplete_Chess_Boards;

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
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            int d = cin.nextInt();
            int temp1 = (a + b) % 2;
            int temp2 = (c + d) % 2;
            System.out.println("Scenario #" + t + ":");
            if (temp1 == temp2) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            System.out.println();
        }
    }
}
