package P1050__To_The_Max;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int array[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = cin.nextInt();
            }
        }
        int maxSum = -1300000;
        for (int i = 0; i < n; i++) {
            int sum[] = new int[n];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] += array[j][k];
                }
                int temp = max(sum, n);
                if (temp > maxSum) {
                    maxSum = temp;
                }
            }
        }
        System.out.println(maxSum);
    }

    public static int max(int sum[], int n) {
        int result = -1300000;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += sum[j];
                if (temp > result) {
                    result = temp;
                }
            }
        }
        return result;
    }
}
