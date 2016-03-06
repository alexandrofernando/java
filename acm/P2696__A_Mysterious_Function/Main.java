package P2696__A_Mysterious_Function;

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
            int c = cin.nextInt();
            int d = cin.nextInt();
            int e = cin.nextInt();
            int f = cin.nextInt();
            int g = cin.nextInt();
            int h = cin.nextInt();
            int n = cin.nextInt();
            int F[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    F[i] = a;
                } else if (i == 1) {
                    F[i] = b;
                } else if (i == 2) {
                    F[i] = c;
                } else if (i % 2 == 1) {
                    F[i] = (d * F[i - 1] + e * F[i - 2] - f * F[i - 3]) % g;
                    if (F[i] < 0) {
                        F[i] += g;
                    }
                } else {
                    F[i] = (f * F[i - 1] - d * F[i - 2] + e * F[i - 3]) % h;
                    if (F[i] < 0) {
                        F[i] += h;
                    }
                }
            }
            System.out.println(F[n]);
        }
    }
}
