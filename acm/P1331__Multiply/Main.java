package P1331__Multiply;

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
            int p = cin.nextInt();
            int q = cin.nextInt();
            int r = cin.nextInt();
            int base = 0;
            for (int j = 2; j <= 16; j++) {
                int a = convert(p, j);
                int b = convert(q, j);
                int c = convert(r, j);
                if (a > 0 && b > 0 && c > 0 && a * b == c) {
                    base = j;
                    break;
                }
            }
            System.out.println(base);
        }
    }

    static int convert(int number, int base) {
        int result = 0;
        int coef = 1;
        while (number != 0) {
            int digit = number % 10;
            if (digit >= base) {
                return 0;
            }
            result += digit * coef;
            coef *= base;
            number /= 10;
        }
        return result;
    }
}
