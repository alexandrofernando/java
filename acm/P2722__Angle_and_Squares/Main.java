package P2722__Angle_and_Squares;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-15
 * Time: 0:21:16
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            double xa = in.nextDouble();
            double ya = in.nextDouble();
            double xb = in.nextDouble();
            double yb = in.nextDouble();
            double length = 0;
            double area1 = 0;
            for (int i = 0; i < N; i++) {
                double edge = in.nextDouble();
                length += Math.sqrt(2) * edge;
                area1 += 0.5 * edge * edge;
            }
            double temp1 = xa - (xa + ya) / (xb + yb) * xb;
            double temp2 = ya - (xa + ya) / (xb + yb) * yb;
            double a = Math.sqrt(length * length / (temp1 * temp1 + temp2 * temp2));
            double b = a * (xa + ya) / (xb + yb);
            double x1 = a * xa;
            double y1 = a * ya;
            double x2 = b * xb;
            double y2 = b * yb;
            double area2 = 0.5 * Math.abs(x1 * y2 - x2 * y1);
            double area = area2 - area1;
            System.out.printf("%.3f\n", area);
        }
    }
}
