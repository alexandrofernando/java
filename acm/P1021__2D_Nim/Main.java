package P1021__2D_Nim;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Iterator;

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
    static int n;
    static boolean grid[][][];
    static boolean visit[][][];
    static LinkedList<Cluster> list;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            width = cin.nextInt();
            height = cin.nextInt();
            n = cin.nextInt();
            grid = new boolean[2][width][height];
            for (int i = 0; i < n; i++) {
                grid[0][cin.nextInt()][cin.nextInt()] = true;
            }
            for (int i = 0; i < n; i++) {
                grid[1][cin.nextInt()][cin.nextInt()] = true;
            }
            list = new LinkedList<Cluster> ();
            visit = new boolean[2][width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[0][i][j] == true && visit[0][i][j] == false) {
                        list.add(BFS(0, i, j));
                    }
                }
            }
            boolean equivalent = true;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[1][i][j] == true && visit[1][i][j] == false) {
                        if (compare(BFS(1, i, j)) == false) {
                            equivalent = false;
                            break;
                        }
                    }
                }
                if (equivalent == false) {
                    break;
                }
            }
            if (equivalent == true) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    static Cluster BFS(int index, int x, int y) {
        int minX = x, maxX = x, minY = y, maxY = y;
        visit[index][x][y] = true;
        int queueX[] = new int[n];
        int queueY[] = new int[n];
        queueX[0] = x;
        queueY[0] = y;
        int front = 0;
        int rear = 1;
        while (front != rear) {
            int tempX = queueX[front];
            int tempY = queueY[front];
            if (tempX > 0 && grid[index][tempX - 1][tempY] == true &&
                visit[index][tempX - 1][tempY] == false) {
                visit[index][tempX - 1][tempY] = true;
                queueX[rear] = tempX - 1;
                queueY[rear] = tempY;
                rear++;
                if (tempX - 1 < minX) {
                    minX = tempX - 1;
                }
            }
            if (tempX < width - 1 && grid[index][tempX + 1][tempY] == true &&
                visit[index][tempX + 1][tempY] == false) {
                visit[index][tempX + 1][tempY] = true;
                queueX[rear] = tempX + 1;
                queueY[rear] = tempY;
                rear++;
                if (tempX + 1 > maxX) {
                    maxX = tempX + 1;
                }
            }
            if (tempY > 0 && grid[index][tempX][tempY - 1] == true &&
                visit[index][tempX][tempY - 1] == false) {
                visit[index][tempX][tempY - 1] = true;
                queueX[rear] = tempX;
                queueY[rear] = tempY - 1;
                rear++;
                if (tempY - 1 < minY) {
                    minY = tempY - 1;
                }
            }
            if (tempY < height - 1 && grid[index][tempX][tempY + 1] == true &&
                visit[index][tempX][tempY + 1] == false) {
                visit[index][tempX][tempY + 1] = true;
                queueX[rear] = tempX;
                queueY[rear] = tempY + 1;
                rear++;
                if (tempY + 1 > maxY) {
                    maxY = tempY + 1;
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

    static boolean compare(Cluster cluster) {
        Iterator<Cluster> iterator = list.listIterator();
        while (iterator.hasNext() == true) {
            Cluster one = iterator.next();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (compare(one, cluster) == true) {
                        iterator.remove();
                        return true;
                    }
                    cluster.rotate();
                }
                cluster.reflect();
            }
        }
        return false;
    }

    static boolean compare(Cluster a, Cluster b) {
        if (a.row != b.row || a.column != b.column) {
            return false;
        }
        for (int i = 0; i < a.row; i++) {
            for (int j = 0; j < a.column; j++) {
                if (a.shape[i][j] != b.shape[i][j]) {
                    return false;
                }
            }
        }
        return true;
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
}
