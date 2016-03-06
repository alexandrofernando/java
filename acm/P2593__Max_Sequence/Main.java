package P2593__Max_Sequence;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static int N;
    static int numbers[];
    static int frontMaxs[];
    static int rearMaxs[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            N = cin.nextInt();
            if (N == 0) {
                break;
            }
            numbers = new int[N + 1];
            frontMaxs = new int[N + 2];
            rearMaxs = new int[N + 2];
            frontMaxs[0] = Integer.MIN_VALUE;
            rearMaxs[N + 1] = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                numbers[i] = cin.nextInt();
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                if (sum > 0) {
                    sum += numbers[i];
                } else {
                    sum = numbers[i];
                }
                if (sum > max) {
                    max = sum;
                }
                frontMaxs[i] = max;
            }
            sum = 0;
            max = Integer.MIN_VALUE;
            for (int i = N; i > 1; i--) {
                if (sum > 0) {
                    sum += numbers[i];
                } else {
                    sum = numbers[i];
                }
                if (sum > max) {
                    max = sum;
                }
                rearMaxs[i] = max;
            }
            int S = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                if (frontMaxs[i] + rearMaxs[i + 1] > S) {
                    S = frontMaxs[i] + rearMaxs[i + 1];
                }
            }
            System.out.println(S);
        }
    }
}
