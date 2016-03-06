package P3230__Travel;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-22
 * Time: 22:50:02
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            int expenses[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    expenses[i][j] = in.nextInt();
                }
            }
            int max[] = new int[n];
            for (int i = 0; i < m; i++) {
                int temp[] = new int[n];
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        temp[j] = -expenses[0][j];
                    } else {
                        temp[j] = Integer.MIN_VALUE;
                        for (int k = 0; k < n; k++) {
                            if (max[k] - expenses[k][j] > temp[j]) {
                                temp[j] = max[k] - expenses[k][j];
                            }
                        }
                    }
                    temp[j] += in.nextInt();
                }
                max = temp;
            }
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (max[i] > result) {
                    result = max[i];
                }
            }
            System.out.println(result);
        }
    }
}
