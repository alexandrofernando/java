package P2488__A_Knight_s_Journey;

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
    static int p;
    static int q;
    static boolean find;
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            p = cin.nextInt();
            q = cin.nextInt();
            System.out.println("Scenario #" + t + ":");
            visited = new boolean[q + 1][p + 1];
            find = false;
            for (int i = 1; i <= q; i++) {
                for (int j = 1; j <= p; j++) {
                    visited[i][j] = true;
                    search(i, j, (char) ('A' - 1 + i) + "" + j, 1);
                    visited[i][j] = false;
                    if (find == true) {
                        break;
                    }
                }
                if (find == true) {
                    break;
                }
            }
            if (find == false) {
                System.out.println("impossible");
            }
            System.out.println();
        }
    }

    static void search(int x, int y, String path, int finish) {
        if (finish == p * q) {
            System.out.println(path);
            find = true;
        } else {
            int offsetX[] = { -2, -2, -1, -1, 1, 1, 2, 2};
            int offsetY[] = { -1, 1, -2, 2, -2, 2, -1, 1};
            for (int i = 0; i < 8; i++) {
                int newX = x + offsetX[i];
                int newY = y + offsetY[i];
                if (newX >= 1 && newX <= q && newY >= 1 && newY <= p &&
                    visited[newX][newY] == false) {
                    visited[newX][newY] = true;
                    String str = (char) ('A' - 1 + newX) + "" + newY;
                    search(newX, newY, path + str, finish + 1);
                    visited[newX][newY] = false;
                    if (find == true) {
                        break;
                    }
                }
            }
        }
    }
}
