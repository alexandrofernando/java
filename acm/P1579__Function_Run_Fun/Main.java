package P1579__Function_Run_Fun;

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
        int w[][][] = new int[21][21][21];
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        w[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] -
                                     w[i][j - 1][k];
                    } else {
                        w[i][j][k] = w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i -
                                     1][j][k - 1] - w[i - 1][j - 1][k - 1];
                    }
                }
            }
        } while (true) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            int result;
            if (a < 0 || b < 0 || c < 0) {
                result = 1;
            } else if (a > 20 || b > 20 || c > 20) {
                result = w[20][20][20];
            } else {
                result = w[a][b][c];
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
        }
    }
}
