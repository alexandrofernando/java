package P2508__Conic_Distance;

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
        while (cin.hasNextDouble() == true) {
            double r = cin.nextDouble();
            double h = cin.nextDouble();
            double d1 = cin.nextDouble();
            double A1 = cin.nextDouble();
            double d2 = cin.nextDouble();
            double A2 = cin.nextDouble();
            double angle = Math.abs(A1 - A2);
            if (angle > 180) {
                angle = 360 - angle;
            }
            double alpha = angle / 360 *
                           ((2 * Math.PI * r) / Math.sqrt(r * r + h * h));
            double d = Math.sqrt(d1 * d1 + d2 * d2 -
                                 2 * d1 * d2 * Math.cos(alpha));
            System.out.printf("%.2f\n", d);
        }
    }
}
