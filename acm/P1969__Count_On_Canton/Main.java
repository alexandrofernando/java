package P1969__Count_On_Canton;

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
        while (cin.hasNextInt() == true) {
            int n = cin.nextInt();
            int m = (int) Math.ceil( ( -1 + Math.sqrt(1 + n * 8)) / 2) - 1;
            int rest = n - m * (m + 1) / 2;
            int a;
            int b;
            if (m % 2 == 0) {
                a = m + 2 - rest;
                b = rest;
            }
            else {
                a = rest;
                b = m + 2 - rest;
            }
            System.out.println("TERM " + n + " IS " + a + "/" + b);
        }
    }
}
