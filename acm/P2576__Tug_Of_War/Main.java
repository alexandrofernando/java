package P2576__Tug_Of_War;

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
        int n = cin.nextInt();
        int weights[] = new int[n + 1];
        int total = 0;
        for (int i = 1; i <= n; i++) {
            weights[i] = cin.nextInt();
            total += weights[i];
        }
        boolean sum[][] = new boolean[55][45005];
        sum[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = n / 2; j >= 0; j--) {
                for (int k = 0; k < 45005; k++) {
                    if (sum[j][k] == true) {
                        sum[j + 1][k + weights[i]] = true;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int w1 = 0;
        int w2 = 0;
        for (int i = 0; i < 45005; i++) {
            if (sum[n / 2][i] == true) {
                int a = i;
                int b = total - i;
                if (Math.abs(a - b) < min) {
                    w1 = Math.min(a, b);
                    w2 = Math.max(a, b);
                    min = Math.abs(a - b);
                }
            }
        }
        System.out.println(w1 + " " + w2);
    }
}
