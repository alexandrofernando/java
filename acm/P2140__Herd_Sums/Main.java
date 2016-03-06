package P2140__Herd_Sums;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int result = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                int temp = N / i;
                if (i % 2 == 1) {
                    result += count(i, temp);
                }
                if (temp % 2 == 1) {
                    result += count(temp, i);
                }
            }
        }
        System.out.println(result);
    }

    static int count(int odd, int number) {
        int counter = 0;
        if (number * 2 > odd) {
            counter++;
        }
        if ( (odd - 1) / 2 >= number) {
            counter++;
        }
        return counter;
    }
}
