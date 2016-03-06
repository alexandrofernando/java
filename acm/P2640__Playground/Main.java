package P2640__Playground;

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
        while (true) {
            int K = cin.nextInt();
            if (K == 0) {
                break;
            }
            double radii[] = new double[K];
            for (int i = 0; i < K; i++) {
                radii[i] = cin.nextDouble();
            }
            Arrays.sort(radii);
            boolean power = false;
            double sum = 0;
            for (int i = 0; i < K; i++) {
                if (i != 0 && radii[i] <= sum) {
                    power = true;
                    break;
                }
                sum += radii[i];
            }
            if (power == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
