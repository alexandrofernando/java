package P1154__Letters;

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
    static int R;
    static int C;
    static int max;
    static char boards[][];
    static boolean used[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        R = cin.nextInt();
        C = cin.nextInt();
        boards = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = cin.next();
            for (int j = 0; j < C; j++) {
                boards[i][j] = line.charAt(j);
            }
        }
        used = new boolean[26];
        max = -1;
        search(0, 0, 1);
        System.out.println(max);
    }

    static void search(int x, int y, int step) {
        if (step > max) {
            max = step;
        }
        used[boards[x][y] - 'A'] = true;
        int offsetX[] = {
            -1, 0, 1, 0};
        int offsetY[] = {
            0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int tempX = x + offsetX[i];
            int tempY = y + offsetY[i];
            if (tempX >= 0 && tempX < R && tempY >= 0 && tempY < C &&
                used[boards[tempX][tempY] - 'A'] == false) {
                search(tempX, tempY, step + 1);
            }
        }
        used[boards[x][y] - 'A'] = false;
    }
}
