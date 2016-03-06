package P2251__Dungeon_Master;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-16
 * Time: 22:56:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int level = in.nextInt();
            int row = in.nextInt();
            int column = in.nextInt();
            if (level == 0 && row == 0 && column == 0) {
                break;
            }
            char dungeon[][][] = new char[level][row][column];
            Point start = null;
            Point exit = null;
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    String str = in.next();
                    for (int k = 0; k < column; k++) {
                        dungeon[i][j][k] = str.charAt(k);
                        if (dungeon[i][j][k] == 'S') {
                            start = new Point(i, j, k);
                            dungeon[i][j][k] = '.';
                        } else if (dungeon[i][j][k] == 'E') {
                            exit = new Point(i, j, k);
                            dungeon[i][j][k] = '.';
                        }
                    }
                }
            }
            LinkedList<Element> queue = new LinkedList<Element>();
            boolean visited[][][] = new boolean[level][row][column];
            visited[start.x][start.y][start.z] = true;
            queue.add(new Element(start, 0));
            int result = -1;
            while (!queue.isEmpty()) {
                Element head = queue.poll();
                int offsetX[] = {0, 0, 0, 0, -1, 1};
                int offsetY[] = {0, 0, -1, 1, 0, 0};
                int offsetZ[] = {-1, 1, 0, 0, 0, 0};
                for (int i = 0; i < 6; i++) {
                    int newX = head.point.x + offsetX[i];
                    int newY = head.point.y + offsetY[i];
                    int newZ = head.point.z + offsetZ[i];
                    if (newX >= 0 && newX < level && newY >= 0 && newY < row && newZ >= 0 && newZ < column && dungeon[newX][newY][newZ] == '.' && !visited[newX][newY][newZ]) {
                        if (newX == exit.x && newY == exit.y && newZ == exit.z) {
                            result = head.step + 1;
                            break;
                        }
                        visited[newX][newY][newZ] = true;
                        queue.add(new Element(new Point(newX, newY, newZ), head.step + 1));
                    }
                }
                if (result != -1) {
                    break;
                }
            }
            if (result != -1) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }
}

class Point {
    int x;
    int y;
    int z;

    Point(int X, int Y, int Z) {
        this.x = X;
        this.y = Y;
        this.z = Z;
    }
}

class Element {
    Point point;
    int step;

    Element(Point thePoint, int theStep) {
        this.point = thePoint;
        this.step = theStep;
    }
}