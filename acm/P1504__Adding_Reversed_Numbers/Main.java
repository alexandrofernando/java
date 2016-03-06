package P1504__Adding_Reversed_Numbers;

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
    static final int size = 10;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = reverse(a);
            int d = reverse(b);
            int sum = c + d;
            int result = reverse(sum);
            System.out.println(result);
        }
    }

    static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }
}
