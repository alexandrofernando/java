package P1120__A_New_Growth_Industry;

import java.util.Scanner;
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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int day = cin.nextInt();
        int D[] = new int[16];
        for (int i = 0; i < 16; i++) {
            D[i] = cin.nextInt();
        }
        int densities[][] = new int[22][22];
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                densities[i][j] = cin.nextInt();
            }
        }
        for (int i = 0; i < day; i++) {
            int newDensities[][] = new int[22][22];
            for (int j = 1; j <= 20; j++) {
                for (int k = 1; k <= 20; k++) {
                    int temp = densities[j][k] + densities[j - 1][k] +
                        densities[j + 1][k] + densities[j][k - 1] +
                        densities[j][k + 1];
                    newDensities[j][k] = densities[j][k] + D[temp];
                    if (newDensities[j][k] > 3) {
                        newDensities[j][k] = 3;
                    }
                    if (newDensities[j][k] < 0) {
                        newDensities[j][k] = 0;
                    }
                }
            }
            densities = newDensities;
        }
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (densities[i][j] == 0) {
                    System.out.print('.');
                }
                else if (densities[i][j] == 1) {
                    System.out.print('!');
                }
                else if (densities[i][j] == 2) {
                    System.out.print('X');
                }
                else if (densities[i][j] == 3) {
                    System.out.print('#');
                }
            }
            System.out.println();
        }
    }
}
