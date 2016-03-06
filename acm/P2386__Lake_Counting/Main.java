package P2386__Lake_Counting;

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
        int N = cin.nextInt();
        int M = cin.nextInt();
        char squares[][] = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = cin.next();
            for (int j = 0; j < M; j++) {
                squares[i][j] = line.charAt(j);
            }
        }
        int pond = 0;
        LinkedList<Point> queue = new LinkedList<Point>();
        boolean visited[][] = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (squares[i][j] == 'W' && visited[i][j] == false) {
                    pond++;
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    while (queue.isEmpty() == false) {
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;
                        if (x - 1 >= 0 && y - 1 >= 0 &&
                            squares[x - 1][y - 1] == 'W' &&
                            visited[x - 1][y - 1] == false) {
                            queue.offer(new Point(x - 1, y - 1));
                            visited[x - 1][y - 1] = true;
                        }
                        if (x - 1 >= 0 && squares[x - 1][y] == 'W' &&
                            visited[x - 1][y] == false) {
                            queue.offer(new Point(x - 1, y));
                            visited[x - 1][y] = true;
                        }
                        if (x - 1 >= 0 && y + 1 < M &&
                            squares[x - 1][y + 1] == 'W' &&
                            visited[x - 1][y + 1] == false) {
                            queue.offer(new Point(x - 1, y + 1));
                            visited[x - 1][y + 1] = true;
                        }
                        if (y - 1 >= 0 && squares[x][y - 1] == 'W' &&
                            visited[x][y - 1] == false) {
                            queue.offer(new Point(x, y - 1));
                            visited[x][y - 1] = true;
                        }
                        if (y + 1 < M && squares[x][y + 1] == 'W' &&
                            visited[x][y + 1] == false) {
                            queue.offer(new Point(x, y + 1));
                            visited[x][y + 1] = true;
                        }
                        if (x + 1 < N && y - 1 >= 0 &&
                            squares[x + 1][y - 1] == 'W' &&
                            visited[x + 1][y - 1] == false) {
                            queue.offer(new Point(x + 1, y - 1));
                            visited[x + 1][y - 1] = true;
                        }
                        if (x + 1 < N && squares[x + 1][y] == 'W' &&
                            visited[x + 1][y] == false) {
                            queue.offer(new Point(x + 1, y));
                            visited[x + 1][y] = true;
                        }
                        if (x + 1 < N && y + 1 < M &&
                            squares[x + 1][y + 1] == 'W' &&
                            visited[x + 1][y + 1] == false) {
                            queue.offer(new Point(x + 1, y + 1));
                            visited[x + 1][y + 1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(pond);
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
