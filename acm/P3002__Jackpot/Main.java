package P3002__Jackpot;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-29
 * Time: 19:20:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int w = in.nextInt();
            int periods[] = new int[w];
            for (int i = 0; i < w; i++) {
                periods[i] = in.nextInt();
            }
            int gcd = 1;
            for (int i = 0; i < w; i++) {
                for (int j = i + 1; j < w; j++) {
                    int temp = GCD(periods[i], periods[j]);
                    gcd *= temp;
                    for (int k = 0; k < w; k++) {
                        periods[k] /= GCD(periods[k], temp);
                    }
                }
            }
            long result = gcd;
            for (int i = 0; i < w; i++) {
                result *= periods[i];
            }
            if (result <= 1000000000) {
                System.out.println(result);
            } else {
                System.out.println("More than a billion.");
            }
        }
    }

    static int GCD(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
