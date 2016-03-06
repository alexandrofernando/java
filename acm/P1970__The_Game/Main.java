package P1970__The_Game;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 23:26:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int board[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            board = new int[20][20];
            for (int i = 1; i <= 19; i++) {
                for (int j = 1; j <= 19; j++) {
                    board[i][j] = in.nextInt();
                }
            }
            boolean win = false;
            for (int j = 1; j <= 19; j++) {
                for (int i = 1; i <= 19; i++) {
                    int offsetX[] = {-1, 0, 1, 1};
                    int offsetY[] = {1, 1, 1, 0};
                    for (int k = 0; k < 4; k++) {
                        if (board[i][j] != 0 && consecutive(i, j, offsetX[k], offsetY[k]) == 5 && consecutive(i, j, -offsetX[k], -offsetY[k]) == 1) {
                            System.out.println(board[i][j]);
                            System.out.println(i + " " + j);
                            win = true;
                            break;
                        }
                    }
                    if (win == true) {
                        break;
                    }
                }
                if (win == true) {
                    break;
                }
            }
            if (win == false) {
                System.out.println(0);
            }
        }
    }

    static int consecutive(int x, int y, int offsetX, int offsetY) {
        int count = 0;
        int tempX = x;
        int tempY = y;
        while (tempX >= 1 && tempX <= 19 && tempY >= 1 && tempY <= 19) {
            if (board[tempX][tempY] != board[x][y]) {
                break;
            }
            count++;
            tempX += offsetX;
            tempY += offsetY;
        }
        return count;
    }
}
