package P1942__Paths_On_A_Grid;

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
        while (true) {
            long n = cin.nextLong();
            long m = cin.nextLong();
            if (n == 0 && m == 0) {
                break;
            }
            long a = n + m;
            long b = (n > m) ? m : n;
            double result = 1;
            for (long i = a; i > a - b; i--) {
                result *= i;
            }
            for (long i = b; i > 0; i--) {
                result /= i;
            }
            System.out.printf("%.0f\n", result);
        }
    }
}
