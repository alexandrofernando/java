package P2704__Pascal_s_Travels;

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
            int n = cin.nextInt();
            if (n == -1) {
                break;
            }
            int board[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                String str = cin.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = str.charAt(j) - '0';
                }
            }
            long paths[][] = new long[n][n];
            paths[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        if (j + board[i][j] < n) {
                            paths[i][j + board[i][j]] += paths[i][j];
                        }
                        if (i + board[i][j] < n) {
                            paths[i + board[i][j]][j] += paths[i][j];
                        }
                    }
                }
            }
            System.out.println(paths[n - 1][n - 1]);
        }
    }
}
