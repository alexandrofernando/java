package P2507__Crossed_Ladders;

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
            double x = cin.nextDouble();
            double y = cin.nextDouble();
            double c = cin.nextDouble();
            double top = Math.min(x, y);
            double bottom = 0;
            while (top - bottom > 1E-4) {
                double middle = (top + bottom) / 2;
                double temp = (Math.sqrt(x * x - middle * middle) - c) *
                              (Math.sqrt(y * y - middle * middle) - c);
                if (temp < c * c) {
                    top = middle;
                } else {
                    bottom = middle;
                }
            }
            double d = (top + bottom) / 2;
            System.out.printf("%.3f\n", d);
        }
    }
}
