package P2405__Beavergnaw;

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
        while (true) {
            int D = cin.nextInt();
            int V = cin.nextInt();
            if (D == 0 && V == 0) {
                break;
            }
            double d = Math.pow(D * D * D - 6 / Math.PI * V, 1.0 / 3);
            System.out.printf("%.3f\n", d);
        }
    }
}
