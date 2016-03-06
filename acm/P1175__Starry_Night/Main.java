package P1175__Starry_Night;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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
    static char map[][];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        width = cin.nextInt();
        height = cin.nextInt();
        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = cin.next();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        ArrayList<Cluster> clusters = new ArrayList<Cluster> ();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == '1') {
                    Cluster temp = BFS(i, j);
                    int mark = clusters.indexOf(temp);
                    if (mark != -1) {
                        BFS(i, j, (char) (mark + 'a'));
                    }
                    else {
                        BFS(i, j, (char) (clusters.size() + 'a'));
                        clusters.add(temp);
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void BFS(int x, int y, char ch) {
        map[x][y] = ch;
        int queueX[] = new int[10000];
        int queueY[] = new int[10000];
        int offsetX[] = {
            -1, -1, 0, 1, 1, 1, 0, -1};
        int offsetY[] = {
            0, 1, 1, 1, 0, -1, -1, -1};
        queueX[0] = x;
        queueY[0] = y;
        int front = 0;
        int rear = 1;
        while (front != rear) {
            int tempX = queueX[front];
            int tempY = queueY[front];
            for (int i = 0; i < 8; i++) {
                int newX = tempX + offsetX[i];
                int newY = tempY + offsetY[i];
                if (newX >= 0 && newX < height && newY >= 0 && newY < width &&
                    map[newX][newY] == ' ') {
                    map[newX][newY] = ch;
                    queueX[rear] = newX;
                    queueY[rear] = newY;
                    rear++;
                }
            }
            front++;
        }
    }

    static Cluster BFS(int x, int y) {
        int minX = x, maxX = x, minY = y, maxY = y;
        map[x][y] = ' ';
        int queueX[] = new int[10000];
        int queueY[] = new int[10000];
        int offsetX[] = {
            -1, -1, 0, 1, 1, 1, 0, -1};
        int offsetY[] = {
            0, 1, 1, 1, 0, -1, -1, -1};
        queueX[0] = x;
        queueY[0] = y;
        int front = 0;
        int rear = 1;
        while (front != rear) {
            int tempX = queueX[front];
            int tempY = queueY[front];
            for (int i = 0; i < 8; i++) {
                int newX = tempX + offsetX[i];
                int newY = tempY + offsetY[i];
                if (newX >= 0 && newX < height && newY >= 0 && newY < width &&
                    map[newX][newY] == '1') {
                    map[newX][newY] = ' ';
                    queueX[rear] = newX;
                    queueY[rear] = newY;
                    rear++;
                    if (newX < minX) {
                        minX = newX;
                    }
                    else if (newX > maxX) {
                        maxX = newX;
                    }
                    if (newY < minY) {
                        minY = newY;
                    }
                    else if (newY > maxY) {
                        maxY = newY;
                    }
                }
            }
            front++;
        }
        Cluster result = new Cluster(maxX - minX + 1, maxY - minY + 1);
        for (int i = 0; i < front; i++) {
            result.shape[queueX[i] - minX][queueY[i] - minY] = true;
        }
        return result;
    }
}

class Cluster {
    int row;
    int column;
    boolean shape[][];
    public Cluster(int theRow, int theColumn) {
        this.row = theRow;
        this.column = theColumn;
        this.shape = new boolean[theRow][theColumn];
    }

    public void rotate() {
        boolean temp[][] = new boolean[this.column][this.row];
        for (int i = 0; i < this.column; i++) {
            for (int j = 0; j < this.row; j++) {
                temp[i][j] = this.shape[j][this.column - i - 1];
            }
        }
        this.shape = temp;
        this.row = temp.length;
        this.column = temp[0].length;
    }

    public void reflect() {
        boolean temp[][] = new boolean[this.row][this.column];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                temp[i][j] = this.shape[i][this.column - j - 1];
            }
        }
        this.shape = temp;
    }

    public boolean equals(Object another) {
        Cluster a = (Cluster) another;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.row == a.row && this.column == a.column) {
                    boolean power = true;
                    for (int p = 0; p < this.row; p++) {
                        for (int q = 0; q < this.column; q++) {
                            if (this.shape[p][q] != a.shape[p][q]) {
                                power = false;
                                break;
                            }
                        }
                        if (power == false) {
                            break;
                        }
                    }
                    if (power == true) {
                        return true;
                    }
                }
                a.rotate();
            }
            a.reflect();
        }
        return false;
    }
}
