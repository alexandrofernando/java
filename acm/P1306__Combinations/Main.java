package P1306__Combinations;

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
            int N = cin.nextInt();
            int M = cin.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            int m = M;
            if (m * 2 > N) {
                m = N - M;
            }
            double result = 1;
            for (int i = m; i > 0; i--) {
                result /= i;
                result *= N - m + i;
            }
            System.out.printf("%d things taken %d at a time is %.0f exactly.\n",
                              N, M, result);
        }
    }
}
