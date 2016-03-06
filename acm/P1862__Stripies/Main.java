package P1862__Stripies;

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
        int N = cin.nextInt();
        double weights[] = new double[N];
        for (int i = 0; i < N; i++) {
            weights[i] = cin.nextDouble();
        }
        Arrays.sort(weights);
        for (int i = N - 2; i >= 0; i--) {
            weights[i] = 2 * Math.sqrt(weights[i] * weights[i + 1]);
        }
        System.out.printf("%.3f\n", weights[0]);
    }
}
