package P2918__Tudoku;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 8:16:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int board[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String str = in.next();
                for (int j = 0; j < 9; j++) {
                    board[i][j] = str.charAt(j) - '0';
                }
            }
            boolean fill = true;
            while (fill == true) {
                fill = false;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (board[i][j] == 0) {
                            int rowX[] = new int[8];
                            int rowY[] = new int[8];
                            int pos = 0;
                            for (int k = 0; k < 9; k++) {
                                if (k != j) {
                                    rowX[pos] = i;
                                    rowY[pos] = k;
                                    pos++;
                                }
                            }
                            int rest = exam(rowX, rowY);
                            if (rest != 0) {
                                board[i][j] = rest;
                                fill = true;
                                break;
                            }
                            int columnX[] = new int[8];
                            int columnY[] = new int[8];
                            pos = 0;
                            for (int k = 0; k < 9; k++) {
                                if (k != i) {
                                    columnX[pos] = k;
                                    columnY[pos] = j;
                                    pos++;
                                }
                            }
                            rest = exam(columnX, columnY);
                            if (rest != 0) {
                                board[i][j] = rest;
                                fill = true;
                                break;
                            }
                            int squareX[] = new int[8];
                            int squareY[] = new int[8];
                            int tempX = i / 3 * 3;
                            int tempY = j / 3 * 3;
                            pos = 0;
                            for (int p = 0; p < 3; p++) {
                                for (int q = 0; q < 3; q++) {
                                    if (tempX + p != i || tempY + q != j) {
                                        squareX[pos] = tempX + p;
                                        squareY[pos] = tempY + q;
                                        pos++;
                                    }
                                }
                            }
                            rest = exam(squareX, squareY);
                            if (rest != 0) {
                                board[i][j] = rest;
                                fill = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (t != 1) {
                System.out.println();
            }
            System.out.println("Scenario #" + t + ":");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }

    static int exam(int x[], int y[]) {
        boolean used[] = new boolean[10];
        for (int i = 0; i < 8; i++) {
            used[board[x[i]][y[i]]] = true;
        }
        int rest = -1;
        for (int i = 1; i <= 9; i++) {
            if (used[i] == false) {
                if (rest == -1) {
                    rest = i;
                } else {
                    return 0;
                }
            }
        }
        return rest;
    }
}
