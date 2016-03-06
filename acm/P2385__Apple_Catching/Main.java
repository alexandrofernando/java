package P2385__Apple_Catching;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-19
 * Time: 0:01:34
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int W = in.nextInt();
        int max[][] = new int[W + 1][2];
        for (int i = 0; i <= W; i++) {
            max[i][1] = -1;
        }
        for (int i = 0; i < T; i++) {
            int tree = in.nextInt() - 1;
            int temp[][] = new int[W + 1][2];
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k < 2; k++) {
                    if (tree == k) {
                        if (j == 0) {
                            temp[j][k] = max[j][k] + 1;
                        } else {
                            temp[j][k] = Math.max(max[j][k] + 1, max[j - 1][(k + 1) % 2] + 1);
                        }
                    } else {
                        if (j == 0) {
                            temp[j][k] = max[j][k];
                        } else {
                            temp[j][k] = Math.max(max[j][k], max[j - 1][(k + 1) % 2]);
                        }
                    }
                }
            }
            max = temp;
        }
        System.out.println(Math.max(max[W][0], max[W][1]));
    }
}
