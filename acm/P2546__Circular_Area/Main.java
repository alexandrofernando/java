package P2546__Circular_Area;

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
        double x1 = cin.nextDouble();
        double y1 = cin.nextDouble();
        double r1 = cin.nextDouble();
        double x2 = cin.nextDouble();
        double y2 = cin.nextDouble();
        double r2 = cin.nextDouble();
        double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double area;
        if (d >= r1 + r2) {
            area = 0;
        } else if (r1 >= d + r2) {
            area = Math.PI * r2 * r2;
        } else if (r2 >= d + r1) {
            area = Math.PI * r1 * r1;
        } else {
            double angle1 = Math.acos((r1 * r1 + d * d - r2 * r2) / (2 * r1 * d));
            double angle2 = Math.acos((r2 * r2 + d * d - r1 * r1) / (2 * r2 * d));
            double hemline = r1 * Math.sin(angle1) * 2;
            double height1 = r1 * Math.cos(angle1);
            double height2 = r2 * Math.cos(angle2);
            double triangle1 = hemline * height1 / 2;
            double triangle2 = hemline * height2 / 2;
            double sector1 = r1 * r1 * angle1;
            double sector2 = r2 * r2 * angle2;
            area = (sector1 - triangle1) + (sector2 - triangle2);
        }
        System.out.printf("%.3f\n", area);
    }
}
