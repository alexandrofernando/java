package P1491__Pi;

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
            if (N == 0) {
                break;
            }
            int numbers[] = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = cin.nextInt();
            }
            int total = N * (N - 1) / 2;
            int pair = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (gcd(numbers[i], numbers[j]) == 1) {
                        pair++;
                    }
                }
            }
            if (pair == 0) {
                System.out.println("No estimate for this data set.");
            } else {
                double Pi = Math.sqrt(6.0 / pair * total);
                System.out.printf("%.6f\n", Pi);
            }
        }
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        } while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
