package P2710__Consecutive_Digits;

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
            int numerator = cin.nextInt();
            int denominator = cin.nextInt();
            int begin = cin.nextInt();
            int end = cin.nextInt();
            System.out.print("Problem set " + t + ": " + numerator + " / " +
                             denominator + ", base 7 digits " + begin +
                             " through " + end + ": ");
            numerator %= denominator;
            for (int i = 0; i <= end; i++) {
                numerator *= 7;
                int digit = numerator / denominator;
                if (i >= begin) {
                    System.out.print(digit);
                }
                numerator %= denominator;
            }
            System.out.println();
        }
    }
}
