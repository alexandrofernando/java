package P1665__Biker_s_Trip_Odometer;

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
        int test = 1;
        final double PI = 3.1415927;
        while (true) {
            double diameter = cin.nextDouble();
            int revolution = cin.nextInt();
            double time = cin.nextDouble();
            if (revolution == 0) {
                break;
            }
            System.out.print("Trip #" + test + ": ");
            test++;
            double distance = PI * diameter * revolution / 12 / 5280;
            double MPH = distance / (time / 3600);
            System.out.printf("%.2f %.2f\n", distance, MPH);
        }
    }
}
