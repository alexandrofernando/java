package P1321__Chessboard_Problem;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-1
 * Time: 8:32:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int C;
    static char board[][];
    static int n;
    static boolean column[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            n = in.nextInt();
            int K = in.nextInt();
            if (n == -1 && K == -1) {
                break;
            }
            board = new char[n][n];
            column = new boolean[n];
            for (int i = 0; i < n; i++) {
                String str = in.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            C = 0;
            search(0, n - K);
            System.out.println(C);
        }
    }

    static void search(int row, int skip) {
        if (row == n) {
            C++;
        } else {
            if (skip > 0) {
                search(row + 1, skip - 1);
            }
            if (n - row > skip) {
                for (int i = 0; i < n; i++) {
                    if (board[row][i] == '#' && column[i] == false) {
                        column[i] = true;
                        search(row + 1, skip);
                        column[i] = false;
                    }
                }
            }
        }
    }
}
