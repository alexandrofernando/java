package P2659__Ball_Bearings;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            double D = cin.nextDouble();
            double d = cin.nextDouble();
            double s = cin.nextDouble();
            double a = (D - d) / 2;
            double b = d + s;
            double angle = Math.acos((a * a * 2 - b * b) / (2 * a * a));
            int m = (int) Math.floor(Math.PI * 2 / angle);
            System.out.println(m);
        }
    }
}
