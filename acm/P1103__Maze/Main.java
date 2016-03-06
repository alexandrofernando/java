package P1103__Maze;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

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
    static int row;
    static int column;
    static Square squares[][];
    static boolean visited[][];
    static int length;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = 1;
        do {
            int w = cin.nextInt();
            int h = cin.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            row = 2 * h - 1;
            column = 2 * w - 1;
            squares = new Square[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = (i % 2 == 0) ? 1 : 0; j < column; j += 2) {
                    squares[i][j] = new Square();
                }
            }
            for (int i = 0; i < h; i++) {
                String line = cin.next();
                for (int j = 0; j < w; j++) {
                    if (line.charAt(j) == '/') {
                        if (i != 0) {
                            squares[i * 2 - 1][j * 2].connects[2] = false;
                        }
                        if (j != w - 1) {
                            squares[i * 2][j * 2 + 1].connects[0] = false;
                        }
                        if (i != h - 1) {
                            squares[i * 2 + 1][j * 2].connects[0] = false;
                        }
                        if (j != 0) {
                            squares[i * 2][j * 2 - 1].connects[2] = false;
                        }
                    }
                    else if (line.charAt(j) == '\\') {
                        if (i != 0) {
                            squares[i * 2 - 1][j * 2].connects[3] = false;
                        }
                        if (j != w - 1) {
                            squares[i * 2][j * 2 + 1].connects[3] = false;
                        }
                        if (i != h - 1) {
                            squares[i * 2 + 1][j * 2].connects[1] = false;
                        }
                        if (j != 0) {
                            squares[i * 2][j * 2 - 1].connects[1] = false;
                        }
                    }
                }
            }
            int max = 0;
            int count = 0;
            visited = new boolean[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = (i % 2 == 0) ? 1 : 0; j < column; j += 2) {
                    if (visited[i][j] == false) {
                        length = 0;
                        if (BFS(i, j) == true) {
                            count++;
                            if (length > max) {
                                max = length;
                            }
                        }
                    }
                }
            }
            System.out.println("Maze #" + test + ":");
            test++;
            if (count == 0) {
                System.out.println("There are no cycles.");
            }
            else {
                System.out.println(count + " Cycles; the longest has length " +
                                   max + ".");
            }
            System.out.println();
        }
        while (true);
    }

    static boolean BFS(int x, int y) {
        LinkedList<Coordinate> queue = new LinkedList<Coordinate> ();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        length++;
        int offsetX[] = {
            -1, -1, 1, 1};
        int offsetY[] = {
            -1, 1, 1, -1};
        boolean closed = true;
        while (queue.isEmpty() == false) {
            Coordinate head = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (squares[head.x][head.y].connects[i] == true) {
                    int newX = head.x + offsetX[i];
                    int newY = head.y + offsetY[i];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < column) {
                        if (visited[newX][newY] == false) {
                            visited[newX][newY] = true;
                            length++;
                            queue.offer(new Coordinate(newX, newY));
                        }
                    }
                    else {
                        closed = false;
                    }
                }
            }
        }
        return closed;
    }
}

class Coordinate {
    int x;
    int y;
    public Coordinate(int X, int Y) {
        this.x = X;
        this.y = Y;
    }
}

class Square {
    boolean connects[]; //index:0-top_left,1-top_right,2-bottom_right,3-bottom_left
    public Square() {
        this.connects = new boolean[4];
        for (int i = 0; i < 4; i++) {
            this.connects[i] = true;
        }
    }
}
