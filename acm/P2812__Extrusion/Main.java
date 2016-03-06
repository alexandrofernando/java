package P2812__Extrusion;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 6:13:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            if (N < 3) {
                break;
            }
            double x[] = new double[N];
            double y[] = new double[N];
            for (int i = 0; i < N; i++) {
                x[i] = in.nextDouble();
                y[i] = in.nextDouble();
            }
            double area = 0;
            for (int i = 0; i < N; i++) {
                area += (y[i] * x[(i + 1) % N] - x[i] * y[(i + 1) % N]);
            }
            area /= 2;
            double volume = in.nextDouble();
            double length = volume / area;
            System.out.printf("BAR LENGTH: %.2f\n", length);
        }
    }
}
