package P1915__Knight_Moves;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int length = cin.nextInt();
            boolean visited[][] = new boolean[length][length];
            int startX = cin.nextInt();
            int startY = cin.nextInt();
            int endX = cin.nextInt();
            int endY = cin.nextInt();
            LinkedList<Point> queue = new LinkedList<Point>();
            queue.add(new Point(startX, startY, 0));
            visited[startX][startY] = true;
            while (queue.isEmpty() == false) {
                Point head = queue.poll();
                if (head.x == endX && head.y == endY) {
                    System.out.println(head.step);
                    break;
                }
                int offsetX[] = { -2, -1, 1, 2, 2, 1, -1, -2};
                int offsetY[] = {1, 2, 2, 1, -1, -2, -2, -1};
                for (int i = 0; i < 8; i++) {
                    int newX = head.x + offsetX[i];
                    int newY = head.y + offsetY[i];
                    if (newX >= 0 && newX < length && newY >= 0 &&
                        newY < length && visited[newX][newY] == false) {
                        visited[newX][newY] = true;
                        queue.offer(new Point(newX, newY, head.step + 1));
                    }
                }
            }
        }
    }
}


class Point {
    int x;
    int y;
    int step;
    public Point(int X, int Y, int theStep) {
        this.x = X;
        this.y = Y;
        this.step = theStep;
    }
}
