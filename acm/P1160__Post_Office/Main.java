package P1160__Post_Office;

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
        int V = cin.nextInt();
        int P = cin.nextInt();
        int positions[] = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            positions[i] = cin.nextInt();
        }
        int sums[][] = new int[P + 1][V + 1];
        for (int i = 1; i <= P; i++) {
            for (int j = i; j <= V; j++) {
                if (i == 1) {
                    sums[1][j] = 0;
                    for (int k = 1; k <= V; k++) {
                        sums[1][j] += Math.abs(positions[k] - positions[j]);
                    }
                }
                else {
                    sums[i][j] = Integer.MAX_VALUE;
                    for (int k = i - 1; k < j; k++) {
                        int temp = sums[i - 1][k];
                        for (int r = j;
                             positions[j] - positions[r] <
                             positions[r] - positions[k]; r--) {
                            temp = temp - (positions[r] - positions[k]) +
                                (positions[j] - positions[r]);
                        }
                        int dis = positions[j] - positions[k];
                        temp -= dis * (V - j);
                        if (temp < sums[i][j]) {
                            sums[i][j] = temp;
                        }
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = P; i <= V; i++) {
            if (sums[P][i] < result) {
                result = sums[P][i];
            }
        }
        System.out.println(result);
    }
}
