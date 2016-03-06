package P3132__Sum_of_Different_Primes;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 6:24:19
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int results[][] = new int[1121][15];
        boolean composites[] = new boolean[1121];
        for (int i = 2; i < composites.length; i++) {
            if (composites[i] == false) {
                for (int k = 14; k >= 2; k--) {
                    for (int j = i + 2; j < 1121; j++) {
                        results[j][k] += results[j - i][k - 1];
                    }
                }
                results[i][1] = 1;
                if (i <= 33) {
                    for (int j = i * i; j < 1121; j += i) {
                        composites[j] = true;
                    }
                }
            }
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int K = in.nextInt();
            if (n == 0 && K == 0) {
                break;
            }
            System.out.println(results[n][K]);
        }
    }
}
