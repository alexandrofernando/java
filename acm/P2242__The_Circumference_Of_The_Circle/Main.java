package P2242__The_Circumference_Of_The_Circle;

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
            double x1 = cin.nextDouble();
            double y1 = cin.nextDouble();
            double x2 = cin.nextDouble();
            double y2 = cin.nextDouble();
            double x3 = cin.nextDouble();
            double y3 = cin.nextDouble();
            double a11 = 2 * x1 - 2 * x2;
            double a12 = 2 * y1 - 2 * y2;
            double b1 = x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2;
            double a21 = 2 * x2 - 2 * x3;
            double a22 = 2 * y2 - 2 * y3;
            double b2 = x2 * x2 + y2 * y2 - x3 * x3 - y3 * y3;
            double x = (b1 * a22 - b2 * a12) / (a11 * a22 - a12 * a21);
            double y = (b2 * a11 - b1 * a21) / (a11 * a22 - a12 * a21);
            double r = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
            double c = 2 * 3.141592653589793 * r;
            System.out.printf("%.2f\n", c);
        }
    }
}
