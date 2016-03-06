package P3086__Triangular_Sums;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int w[] = new int[301];
        int side = 3;
        for (int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + i * side;
            side += i + 2;
        }
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            System.out.printf("%d %d %d\n", t, n, w[n]);
        }
    }
}
