package P1024__Tester_Program;

import java.util.Scanner;
import java.util.LinkedList;
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
    static int width;
    static int height;
    static Grid grids[][];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            width = cin.nextInt();
            height = cin.nextInt();
            grids = new Grid[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grids[i][j] = new Grid();
                }
            }
            grids[0][0].isPath = true;
            String path = cin.next();
            Point start = new Point(0, 0);
            Point end = new Point(0, 0);
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'U') {
                    end.translate(1, 0);
                }
                else if (path.charAt(i) == 'R') {
                    end.translate(0, 1);
                }
                else if (path.charAt(i) == 'D') {
                    end.translate( -1, 0);
                }
                else if (path.charAt(i) == 'L') {
                    end.translate(0, -1);
                }
                grids[end.x][end.y].isPath = true;
            }
            int m = cin.nextInt();
            Wall walls[] = new Wall[m];
            for (int i = 0; i < m; i++) {
                walls[i] = new Wall(cin.nextInt(), cin.nextInt(), cin.nextInt(),
                                    cin.nextInt());
                if (walls[i].x1 == walls[i].x2) {
                    if (walls[i].y1 + 1 == walls[i].y2) {
                        grids[walls[i].x1][walls[i].y1].connect[1] = false;
                        grids[walls[i].x2][walls[i].y2].connect[3] = false;
                    }
                    else if (walls[i].y1 == walls[i].y2 + 1) {
                        grids[walls[i].x1][walls[i].y1].connect[3] = false;
                        grids[walls[i].x2][walls[i].y2].connect[1] = false;
                    }
                }
                else if (walls[i].y1 == walls[i].y2) {
                    if (walls[i].x1 + 1 == walls[i].x2) {
                        grids[walls[i].x1][walls[i].y1].connect[0] = false;
                        grids[walls[i].x2][walls[i].y2].connect[2] = false;
                    }
                    else if (walls[i].x1 == walls[i].x2 + 1) {
                        grids[walls[i].x1][walls[i].y1].connect[2] = false;
                        grids[walls[i].x2][walls[i].y2].connect[0] = false;
                    }
                }
            }
            bfs(start, 0);
            bfs(end, 1);
            boolean correct = true;
            if (grids[end.x][end.y].distance[0] != path.length()) {
                correct = false;
            }
            else {
                int tempX = end.x;
                int tempY = end.y;
                int offsetX[] = {
                    1, 0, -1, 0};
                int offsetY[] = {
                    0, 1, 0, -1};
                while (tempX != start.x || tempY != start.y) {
                    if (grids[tempX][tempY].isPath == false ||
                        grids[tempX][tempY].unique[0] == false) {
                        correct = false;
                        break;
                    }
                    Grid temp = grids[tempX][tempY];
                    tempX += offsetX[temp.previous[0]];
                    tempY += offsetY[temp.previous[0]];
                }
                if (correct == true) {
                    for (int i = 0; i < m; i++) {
                        boolean power = false;
                        for (int j = 0; j < 2; j++) {
                            if (grids[walls[i].x1][walls[i].y1].distance[j] !=
                                -1 &&
                                grids[walls[i].x2][walls[i].y2].distance[ (j +
                                1) % 2] != -1 &&
                                grids[walls[i].x1][walls[i].y1].distance[j] +
                                grids[walls[i].x2][walls[i].y2].distance[ (j +
                                1) % 2] + 1 <= path.length()) {
                                power = true;
                                break;
                            }
                        }
                        if (power == false) {
                            correct = false;
                            break;
                        }
                    }
                }
            }
            if (correct == true) {
                System.out.println("CORRECT");
            }
            else {
                System.out.println("INCORRECT");
            }
        }
    }

    static void bfs(Point source, int index) {
        LinkedList<Group> queue = new LinkedList<Group> ();
        queue.offer(new Group(source.x, source.y, 0));
        grids[source.x][source.y].distance[index] = 0;
        int offsetX[] = {
            1, 0, -1, 0};
        int offsetY[] = {
            0, 1, 0, -1};
        while (queue.isEmpty() == false) {
            Group head = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = head.x + offsetX[i];
                int tempY = head.y + offsetY[i];
                if (grids[head.x][head.y].connect[i] == true && tempX >= 0 &&
                    tempX < height && tempY >= 0 && tempY < width) {
                    if (grids[tempX][tempY].distance[index] == -1) {
                        grids[tempX][tempY].distance[index] = head.distance + 1;
                        grids[tempX][tempY].previous[index] = (i + 2) % 4;
                        grids[tempX][tempY].unique[index] = true;
                        queue.offer(new Group(tempX, tempY, head.distance + 1));
                    }
                    else if (grids[tempX][tempY].distance[index] ==
                             head.distance + 1) {
                        grids[tempX][tempY].unique[index] = false;
                    }
                }
            }
        }
    }
}

class Grid {
    boolean isPath;
    int distance[];
    int previous[];
    boolean unique[];
    boolean connect[];
    public Grid() {
        this.isPath = false;
        this.distance = new int[2];
        this.previous = new int[2];
        this.unique = new boolean[2];
        for (int i = 0; i < 2; i++) {
            this.distance[i] = -1;
            this.previous[i] = -1;
            this.unique[i] = true;
        }
        this.connect = new boolean[4];
        for (int i = 0; i < 4; i++) {
            this.connect[i] = true;
        }
    }
}

class Group {
    int x;
    int y;
    int distance;
    public Group(int X, int Y, int theDistance) {
        this.x = X;
        this.y = Y;
        this.distance = theDistance;
    }
}

class Wall {
    int y1;
    int x1;
    int y2;
    int x2;
    public Wall(int Y1, int X1, int Y2, int X2) {
        this.y1 = Y1;
        this.x1 = X1;
        this.y2 = Y2;
        this.x2 = X2;
    }
}

class Point {
    int x;
    int y;
    public Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public void translate(int offsetX, int offsetY) {
        this.x += offsetX;
        this.y += offsetY;
    }
}
