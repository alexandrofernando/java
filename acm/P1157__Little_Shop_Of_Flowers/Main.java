package P1157__Little_Shop_Of_Flowers;

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
        int F = cin.nextInt();
        int V = cin.nextInt();
        int value[][] = new int[F][V];
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < V; j++) {
                value[i][j] = cin.nextInt();
            }
        }
        int max[][] = new int[F][V];
        for (int i = 0; i < F; i++) {
            for (int j = i; j < V; j++) {
                if (j == 0) {
                    max[i][j] = value[i][j];
                }
                else if (i == 0) {
                    max[i][j] = Math.max(max[i][j - 1], value[i][j]);
                }
                else {
                    max[i][j] = Math.max(max[i][j - 1],
                                         max[i - 1][j - 1] + value[i][j]);
                }
            }
        }
        System.out.println(max[F - 1][V - 1]);
    }
}
