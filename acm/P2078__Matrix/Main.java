package P2078__Matrix;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-6
 * Time: 1:21:06
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int n;
    static int matrix[][];
    static int sums[];
    static int result;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            n = in.nextInt();
            if (n == -1) {
                break;
            }
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            sums = new int[n];
            result = Integer.MAX_VALUE;
            search(0);
            System.out.println(result);
        }
    }

    static void search(int row) {
        if (row == n) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (sums[i] > max) {
                    max = sums[i];
                }
            }
            if (max < result) {
                result = max;
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sums[j] += matrix[row][(j + i) % n];
                }
                search(row + 1);
                for (int j = 0; j < n; j++) {
                    sums[j] -= matrix[row][(j + i) % n];
                }
            }
        }
    }
}
