package P2935__Basic_Wall_Maze;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-16
 * Time: 20:18:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int startX = in.nextInt();
            int startY = in.nextInt();
            if (startX == 0 && startY == 0) {
                break;
            }
            int endX = in.nextInt();
            int endY = in.nextInt();
            if (startX == endX && startY == endY) {
                System.out.println();
            } else {
                char grid[][] = new char[7][7];
                Wall walls[] = new Wall[3];
                for (int i = 0; i < 3; i++) {
                    walls[i] = new Wall(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                }
                LinkedList<Square> queue = new LinkedList<Square>();
                grid[startX][startY] = 'A';
                queue.offer(new Square(startX, startY));
                while (true) {
                    Square head = queue.poll();
                    int offsetX[] = {0, 1, 0, -1};
                    int offsetY[] = {-1, 0, 1, 0};
                    int edgeX[] = {-1, 0, 0, 0, 0, -1, -1, -1};
                    int edgeY[] = {-1, -1, -1, 0, 0, 0, 0, -1};
                    char step[] = {'N', 'E', 'S', 'W'};
                    boolean find = false;
                    for (int i = 0; i < 4; i++) {
                        boolean power = true;
                        for (int j = 0; j < 3; j++) {
                            if (walls[j].isContain(head.x + edgeX[i * 2], head.y + edgeY[i * 2], head.x + edgeX[i * 2 + 1], head.y + edgeY[i * 2 + 1]) == true) {
                                power = false;
                                break;
                            }
                        }
                        if (power == true) {
                            int newX = head.x + offsetX[i];
                            int newY = head.y + offsetY[i];
                            if (newX >= 1 && newX <= 6 && newY >= 1 && newY <= 6 && grid[newX][newY] == 0) {
                                grid[newX][newY] = step[i];
                                if (newX == endX && newY == endY) {
                                    find = true;
                                    break;
                                }
                                queue.offer(new Square(newX, newY));
                            }
                        }
                    }
                    if (find == true) {
                        break;
                    }
                }
                String path = "";
                int x = endX;
                int y = endY;
                while (x != startX || y != startY) {
                    path = grid[x][y] + path;
                    if (grid[x][y] == 'N') {
                        y++;
                    } else if (grid[x][y] == 'E') {
                        x--;
                    } else if (grid[x][y] == 'S') {
                        y--;
                    } else if (grid[x][y] == 'W') {
                        x++;
                    }
                }
                System.out.println(path);
            }
        }
    }
}

class Square {
    int x;
    int y;

    public Square(int X, int Y) {
        this.x = X;
        this.y = Y;
    }
}

class Wall {
    int startX;
    int startY;
    int endX;
    int endY;

    public Wall(int theStartX, int theStartY, int theEndX, int theEndY) {
        this.startX = theStartX;
        this.startY = theStartY;
        this.endX = theEndX;
        this.endY = theEndY;
    }

    boolean isContain(int x1, int y1, int x2, int y2) {
        if (isMiddle(x1, this.startX, this.endX) == true && isMiddle(y1, this.startY, this.endY) == true && isMiddle(x2, this.startX, this.endX) == true && isMiddle(y2, this.startY, this.endY) == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isMiddle(int a, int b, int c) {
        if ((a - b) * (a - c) <= 0) {
            return true;
        } else {
            return false;
        }
    }
}