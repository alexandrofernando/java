package P2612__Mine_Sweeper;

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
        int n = cin.nextInt();
        cin.nextLine();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = cin.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        char touch[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = cin.nextLine();
            for (int j = 0; j < n; j++) {
                touch[i][j] = line.charAt(j);
            }
        }
        boolean mine = false;
        char output[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (touch[i][j] == 'x') {
                    if (board[i][j] == '*') {
                        mine = true;
                    } else {
                        int count = 0;
                        if (i > 0 && j > 0 && board[i - 1][j - 1] == '*') {
                            count++;
                        }
                        if (i > 0 && board[i - 1][j] == '*') {
                            count++;
                        }
                        if (i > 0 && j < n - 1 && board[i - 1][j + 1] == '*') {
                            count++;
                        }
                        if (j > 0 && board[i][j - 1] == '*') {
                            count++;
                        }
                        if (j < n - 1 && board[i][j + 1] == '*') {
                            count++;
                        }
                        if (i < n - 1 && j > 0 && board[i + 1][j - 1] == '*') {
                            count++;
                        }
                        if (i < n - 1 && board[i + 1][j] == '*') {
                            count++;
                        }
                        if (i < n - 1 && j < n - 1 &&
                            board[i + 1][j + 1] == '*') {
                            count++;
                        }
                        output[i][j] = (char) ('0' + count);
                    }
                } else {
                    output[i][j] = '.';
                }
            }
        }
        if (mine == true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '*') {
                        output[i][j] = '*';
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }
}
