package P1604__Just_The_Facts;

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
        while (cin.hasNextInt() == true) {
            int N = cin.nextInt();
            System.out.printf("%5d -> ", N);
            int result = 1;
            while (N != 0) {
                while (N % 5 != 0) {
                    result = result * N % 10;
                    N--;
                }
                N /= 5;
                if (N != 0) {
                    if (N % 4 == 0) {
                        result = result * 6 % 10;
                    } else if (N % 4 == 1) {
                        result = result * 2 % 10;
                    } else if (N % 4 == 2) {
                        result = result * 4 % 10;
                    } else if (N % 4 == 3) {
                        result = result * 8 % 10;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
