package P1163__The_Triangle;

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
        int N = cin.nextInt();
        int number[][] = new int[N][];
        for (int i = 0; i < N; i++) {
            number[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                number[i][j] = cin.nextInt();
            }
        }
        int sum[][] = new int[N][];
        for (int i = N - 1; i >= 0; i--) {
            sum[i] = new int[i + 1];
            if (i == N - 1) {
                for (int j = 0; j < N; j++) {
                    sum[N - 1][j] = number[N - 1][j];
                }
            }
            else {
                for (int j = 0; j < i + 1; j++) {
                    int temp;
                    if (sum[i + 1][j] > sum[i + 1][j + 1]) {
                        temp = sum[i + 1][j];
                    }
                    else {
                        temp = sum[i + 1][j + 1];
                    }
                    sum[i][j] = temp + number[i][j];
                }
            }
        }
        System.out.println(sum[0][0]);
    }
}
