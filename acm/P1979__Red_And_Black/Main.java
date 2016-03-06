package P1979__Red_And_Black;

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
            int W = cin.nextInt();
            int H = cin.nextInt();
            if (W == 0 && H == 0) {
                break;
            }
            cin.nextLine();
            char tiles[][] = new char[H][W];
            boolean visited[][] = new boolean[H][W];
            LinkedList<Point> queue = new LinkedList<Point>();
            int count = 0;
            for (int i = 0; i < H; i++) {
                String line = cin.nextLine();
                for (int j = 0; j < W; j++) {
                    tiles[i][j] = line.charAt(j);
                    if (tiles[i][j] == '@') {
                        visited[i][j] = true;
                        queue.offer(new Point(i, j));
                        count++;
                    }
                }
            } while (queue.isEmpty() == false) {
                Point head = queue.poll();
                int x = head.x;
                int y = head.y;
                int offsetX[] = { -1, 0, 0, 1};
                int offsetY[] = {0, -1, 1, 0};
                for (int i = 0; i < 4; i++) {
                    int newX = x + offsetX[i];
                    int newY = y + offsetY[i];
                    if (newX >= 0 && newX < H && newY >= 0 && newY < W &&
                        tiles[newX][newY] == '.' && visited[newX][newY] == false) {
                        visited[newX][newY] = true;
                        queue.offer(new Point(newX, newY));
                        count++;
                    }
                }
            }
            System.out.println(count);
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
