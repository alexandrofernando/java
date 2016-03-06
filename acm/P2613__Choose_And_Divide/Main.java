package P2613__Choose_And_Divide;

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
    static int counts[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt() == true) {
            int p = cin.nextInt();
            int q = cin.nextInt();
            int r = cin.nextInt();
            int s = cin.nextInt();
            if (q * 2 > p) {
                q = p - q;
            }
            if (s * 2 > r) {
                s = r - s;
            }
            counts = new int[10000];
            for (int i = p; i > p - q; i--) {
                counts[i]++;
            }
            for (int i = q; i > 0; i--) {
                counts[i]--;
            }
            for (int i = r; i > r - s; i--) {
                counts[i]--;
            }
            for (int i = s; i > 0; i--) {
                counts[i]++;
            }
            double result = 1;
            int multiply = 1;
            int divide = 1;
            while (true) {
                multiply = next(multiply, 1);
                divide = next(divide, -1);
                if (multiply == 10000 && divide == 10000) {
                    break;
                }
                result = result * multiply / divide;
                counts[multiply]--;
                counts[divide]++;
            }
            System.out.printf("%.5f\n", result);
        }
    }

    static int next(int number, int type) {
        while (number < 10000 && counts[number] * type <= 0) {
            number++;
        }
        return number;
    }
}
