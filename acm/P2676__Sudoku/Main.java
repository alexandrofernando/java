package P2676__Sudoku;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-10
 * Time: 1:49:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int table[][];
    static boolean rows[][];
    static boolean columns[][];
    static boolean squares[][][];
    static boolean find;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            rows = new boolean[9][10];
            columns = new boolean[9][10];
            squares = new boolean[3][3][10];
            table = new int[9][9];
            int pending = 0;
            for (int i = 0; i < 9; i++) {
                String line = in.next();
                for (int j = 0; j < 9; j++) {
                    int temp = line.charAt(j) - '0';
                    if (temp != 0) {
                        table[i][j] = temp;
                        rows[i][temp] = true;
                        columns[j][temp] = true;
                        squares[i / 3][j / 3][temp] = true;
                    } else {
                        pending++;
                    }
                }
            }
            find = false;
            search(0, 0, pending);
        }
    }

    static void search(int r, int c, int pending) {
        if (pending == 0) {
            find = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(table[i][j]);
                }
                System.out.println();
            }
        } else {
            for (int i = r; i < 9; i++) {
                for (int j = (i == r ? c : 0); j < 9; j++) {
                    if (table[i][j] == 0) {
                        for (int k = 1; k <= 9; k++) {
                            if (rows[i][k] == false && columns[j][k] == false && squares[i / 3][j / 3][k] == false) {
                                table[i][j] = k;
                                rows[i][k] = true;
                                columns[j][k] = true;
                                squares[i / 3][j / 3][k] = true;
                                search(i, j + 1, pending - 1);
                                if (find == true) {
                                    return;
                                }
                                squares[i / 3][j / 3][k] = false;
                                columns[j][k] = false;
                                rows[i][k] = false;
                                table[i][j] = 0;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
}
