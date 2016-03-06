package P2249__Binomial_Showdown;

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
            int n = cin.nextInt();
            int K = cin.nextInt();
            if (n == 0 && K == 0) {
                break;
            }
            if (K > n / 2) {
                K = n - K;
            }
            double result = 1;
            for (int i = 0; i < K; i++) {
                result *= (n - i);
                result /= i + 1;
            }
            System.out.printf("%.0f\n", result);
        }
    }
}
