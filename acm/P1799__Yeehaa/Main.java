package P1799__Yeehaa;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            double R = cin.nextDouble();
            int n = cin.nextInt();
            double temp = Math.sin(Math.PI / n);
            double r = temp * R / (temp + 1);
            System.out.println("Scenario #" + t + ":");
            System.out.printf("%.3f\n\n", r);
        }
    }
}
