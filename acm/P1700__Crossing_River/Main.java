package P1700__Crossing_River;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = cin.nextInt();
            int times[] = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                times[i] = cin.nextInt();
            }
            Arrays.sort(times, 1, N + 1);
            int total = 0;
            while (N >= 4) {
                if (times[2] * 2 > times[1] + times[N - 1]) {
                    total += times[1] * 2 + times[N - 1] + times[N];
                } else {
                    total += times[1] + 2 * times[2] + times[N];
                }
                N -= 2;
            }
            if (N == 1) {
                total += times[1];
            } else if (N == 2) {
                total += times[2];
            } else if (N == 3) {
                total += times[1] + times[2] + times[3];
            }
            System.out.println(total);
        }
    }
}
