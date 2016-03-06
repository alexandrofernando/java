package P2309__BST;

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
            int X = cin.nextInt();
            if (X % 2 == 1) {
                System.out.println(X + " " + X);
            } else {
                for (int i = 4; ; i *= 2) {
                    if (X % i == i / 2) {
                        System.out.println((X - i / 2 + 1) + " " +
                                           (X + i / 2 - 1));
                        break;
                    }
                }
            }
        }
    }
}
