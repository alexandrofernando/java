package P2785__4_Values_whose_Sum_is_0;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-29
 * Time: 7:50:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static final int hashsize = 4194304;

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        int B[] = new int[n];
        int C[] = new int[n];
        int D[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            B[i] = in.nextInt();
            C[i] = in.nextInt();
            D[i] = in.nextInt();
        }
        int sum1[] = new int[n * n];
        int sum2[] = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1[n * i + j] = A[i] + B[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum2[n * i + j] = -C[i] - D[j];
            }
        }
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        int result = 0;
        int p1 = 0;
        int p2 = 0;
        int count1 = 0;
        int count2 = 0;
        int value1 = 0;
        int value2 = 0;
        boolean forward1 = true;
        boolean forward2 = true;
        while (true) {
            if (forward1 == true) {
                if (p1 == n * n) {
                    count1 = 0;
                } else {
                    for (value1 = sum1[p1], count1 = 0; p1 < n * n && sum1[p1] == value1; p1++) {
                        count1++;
                    }
                }
            }
            if (forward2 == true) {
                if (p2 == n * n) {
                    count2 = 0;
                } else {
                    for (value2 = sum2[p2], count2 = 0; p2 < n * n && sum2[p2] == value2; p2++) {
                        count2++;
                    }
                }
            }
            if (count1 == 0 || count2 == 0) {
                break;
            }
            if (value1 == value2) {
                result += count1 * count2;
                forward1 = true;
                forward2 = true;
            } else if (value1 < value2) {
                forward1 = true;
                forward2 = false;
            } else {
                forward1 = false;
                forward2 = true;
            }
        }
        System.out.println(result);
    }
}
