package P3085__Quick_Change;

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
            int change = cin.nextInt();
            int quarter = change / 25;
            change %= 25;
            int dime = change / 10;
            change %= 10;
            int nickel = change / 5;
            change %= 5;
            int penny = change;
            System.out.printf(
                "%d %d QUARTER(S), %d DIME(S), %d NICKEL(S), %d PENNY(S)\n", t,
                quarter, dime, nickel, penny);
        }
    }
}
