package P2605__Simple_Game_On_A_Grid;

import java.util.Scanner;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        if (m == 1) {
            System.out.println( (n + 1) / 2);
        }
        else if (n == 1) {
            System.out.println( (m + 1) / 2);
        }
        else if (m % 3 == 0 || n % 3 == 0) {
            System.out.println(2);
        }
        else {
            System.out.println(1);
        }
    }
}
