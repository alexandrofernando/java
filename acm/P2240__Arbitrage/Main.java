package P2240__Arbitrage;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-6-17
 * Time: 2:19:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static String names[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = in.next();
            }
            double rates[][] = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        rates[i][i] = 1;
                    } else {
                        rates[i][j] = -1;
                    }
                }
            }
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                String from = in.next();
                double rate = in.nextDouble();
                String to = in.next();
                int index1 = getIndex(from);
                int index2 = getIndex(to);
                rates[index1][index2] = Math.max(rates[index1][index2], rate);
            }
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (rates[i][j] >= 0) {
                        for (int k = 0; k < n; k++) {
                            if (rates[j][k] >= 0) {
                                rates[i][k] = Math.max(rates[i][k], rates[i][j] * rates[j][k]);
                            }
                        }
                    }
                }
            }
            boolean possible = false;
            for (int i = 0; i < n; i++) {
                if (rates[i][i] > 1) {
                    possible = true;
                }
            }
            System.out.print("Case " + test + ": ");
            test++;
            if (possible == true) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static int getIndex(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].compareTo(name) == 0) {
                return i;
            }
        }
        return -1;
    }
}
