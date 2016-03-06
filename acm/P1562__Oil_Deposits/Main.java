package P1562__Oil_Deposits;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

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
            int m = cin.nextInt();
            int n = cin.nextInt();
            cin.nextLine();
            if (m == 0) {
                break;
            }
            char grids[][] = new char[m][n];
            for (int i = 0; i < m; i++) {
                String temp = cin.nextLine();
                for (int j = 0; j < n; j++) {
                    grids[i][j] = temp.charAt(j);
                }
            }
            boolean used[][] = new boolean[m][n];
            int deposit = 0;
            int offsetX[] = { -1, -1, 0, 1, 1, 1, 0, -1};
            int offsetY[] = {0, 1, 1, 1, 0, -1, -1, -1};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grids[i][j] == '@' && used[i][j] == false) {
                        LinkedList<Point> queue = new LinkedList<Point>();
                        queue.offer(new Point(i, j));
                        used[i][j] = true;
                        while (queue.isEmpty() == false) {
                            Point head = queue.poll();
                            for (int k = 0; k < 8; k++) {
                                int newX = head.x + offsetX[k];
                                int newY = head.y + offsetY[k];
                                if (newX >= 0 && newX < m && newY >= 0 &&
                                    newY < n && grids[newX][newY] == '@' &&
                                    used[newX][newY] == false) {
                                    used[newX][newY] = true;
                                    queue.offer(new Point(newX, newY));
                                }
                            }
                        }
                        deposit++;
                    }
                }
            }
            System.out.println(deposit);
        }
    }
}


class Point {
    int x;
    int y;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }
}
