package P3620__Avoid_The_Lakes;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-15
 * Time: 15:00:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int N;
    static int M;
    static int cells[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        int K = in.nextInt();
        cells = new int[N][M];
        for (int i = 0; i < K; i++) {
            int R = in.nextInt();
            int C = in.nextInt();
            cells[R - 1][C - 1] = 1;
        }
        int largest = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cells[i][j] == 1) {
                    int area = bfs(i, j);
                    largest = Math.max(largest, area);
                }
            }
        }
        System.out.println(largest);
    }

    static int bfs(int x, int y) {
        cells[x][y] = -1;
        int total = 1;
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point head = queue.poll();
            int offsetX[] = {-1, 0, 1, 0};
            int offsetY[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nextX = head.x + offsetX[i];
                int nextY = head.y + offsetY[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && cells[nextX][nextY] == 1) {
                    cells[nextX][nextY] = -1;
                    total++;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        return total;
    }
}

class Point {
    int x;
    int y;

    Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }
}