package P2527__Polynomial_Remains;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-6
 * Time: 6:28:53
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int K = in.nextInt();
            if (n == -1 && K == -1) {
                break;
            }
            int a[] = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                a[i] = in.nextInt();
            }
            for (int i = n; i >= K; i--) {
                a[i - K] -= a[i];
            }
            int degree = Math.min(K - 1, n);
            while (degree >= 0 && a[degree] == 0) {
                degree--;
            }
            if (degree < 0) {
                System.out.println(0);
            } else {
                for (int i = 0; i <= degree; i++) {
                    if (i != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(a[i]);
                }
                System.out.println();
            }
        }
    }
}
