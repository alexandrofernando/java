package P2499__Binary_Tree;

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
            int left = 0;
            int right = 0;
            while (a != b) {
                if (a > b) {
                    if (b == 1) {
                        left += a - b;
                        a = 1;
                    } else {
                        left += a / b;
                        a %= b;
                    }
                } else {
                    if (a == 1) {
                        right += b - a;
                        b = 1;
                    } else {
                        right += b / a;
                        b %= a;
                    }
                }
            }
            System.out.println("Scenario #" + t + ":");
            System.out.println(left + " " + right);
            System.out.println();
        }
    }
}
