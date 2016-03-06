package P1096__Space_Station_Shielding;

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
    static int grid[][][];
    static int n, m, k;
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        k = cin.nextInt();
        int l = cin.nextInt();
        while (n != 0 || m != 0 || k != 0 || l != 0) {
            grid = new int[n][m][k];
            for (int i = 0; i < l; i++) {
                int temp = cin.nextInt();
                int x = temp / (m * k);
                temp -= x * m * k;
                int y = temp / k;
                temp -= y * k;
                int z = temp;
                grid[x][y][z] = 2;
            }
            LinkedList queue = new LinkedList<Triple> ();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j][0] == 0) {
                        grid[i][j][0] = 1;
                        queue.offer(new Triple(i, j, 0));
                    }
                    if (grid[i][j][k - 1] == 0) {
                        grid[i][j][k - 1] = 1;
                        queue.offer(new Triple(i, j, k - 1));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int s = 0; s < k; s++) {
                    if (grid[i][0][s] == 0) {
                        grid[i][0][s] = 1;
                        queue.offer(new Triple(i, 0, s));
                    }
                    if (grid[i][m - 1][s] == 0) {
                        grid[i][m - 1][s] = 1;
                        queue.offer(new Triple(i, m - 1, s));
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                for (int s = 0; s < k; s++) {
                    if (grid[0][j][s] == 0) {
                        grid[0][j][s] = 1;
                        queue.offer(new Triple(0, j, s));
                    }
                    if (grid[n - 1][j][s] == 0) {
                        grid[n - 1][j][s] = 1;
                        queue.offer(new Triple(n - 1, j, s));
                    }
                }
            }
            while (queue.peek() != null) {
                Triple temp = (Triple) queue.remove();
                if (temp.x > 0 && grid[temp.x - 1][temp.y][temp.z] == 0) {
                    grid[temp.x - 1][temp.y][temp.z] = 1;
                    queue.offer(new Triple(temp.x - 1, temp.y, temp.z));
                }
                if (temp.x < n - 1 && grid[temp.x + 1][temp.y][temp.z] == 0) {
                    grid[temp.x + 1][temp.y][temp.z] = 1;
                    queue.offer(new Triple(temp.x + 1, temp.y, temp.z));
                }
                if (temp.y > 0 && grid[temp.x][temp.y - 1][temp.z] == 0) {
                    grid[temp.x][temp.y - 1][temp.z] = 1;
                    queue.offer(new Triple(temp.x, temp.y - 1, temp.z));
                }
                if (temp.y < m - 1 && grid[temp.x][temp.y + 1][temp.z] == 0) {
                    grid[temp.x][temp.y + 1][temp.z] = 1;
                    queue.offer(new Triple(temp.x, temp.y + 1, temp.z));
                }
                if (temp.z > 0 && grid[temp.x][temp.y][temp.z - 1] == 0) {
                    grid[temp.x][temp.y][temp.z - 1] = 1;
                    queue.offer(new Triple(temp.x, temp.y, temp.z - 1));
                }
                if (temp.z < k - 1 && grid[temp.x][temp.y][temp.z + 1] == 0) {
                    grid[temp.x][temp.y][temp.z + 1] = 1;
                    queue.offer(new Triple(temp.x, temp.y, temp.z + 1));
                }
            }
            int shield = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int s = 0; s < k; s++) {
                        if (grid[i][j][s] == 2) {
                            if (i == 0 || grid[i - 1][j][s] == 1) {
                                shield++;
                            }
                            if (i == n - 1 || grid[i + 1][j][s] == 1) {
                                shield++;
                            }
                            if (j == 0 || grid[i][j - 1][s] == 1) {
                                shield++;
                            }
                            if (j == m - 1 || grid[i][j + 1][s] == 1) {
                                shield++;
                            }
                            if (s == 0 || grid[i][j][s - 1] == 1) {
                                shield++;
                            }
                            if (s == k - 1 || grid[i][j][s + 1] == 1) {
                                shield++;
                            }
                        }
                    }
                }
            }
            System.out.println("The number of faces needing shielding is " +
                               shield + ".");
            n = cin.nextInt();
            m = cin.nextInt();
            k = cin.nextInt();
            l = cin.nextInt();
        }
    }
}

class Triple {
    int x, y, z;
    public Triple(int X, int Y, int Z) {
        this.x = X;
        this.y = Y;
        this.z = Z;
    }
}
