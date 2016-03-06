package P2365__Rope;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 17:56:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double R = in.nextDouble();
        double x[] = new double[N];
        double y[] = new double[N];
        for (int i = 0; i < N; i++) {
            x[i] = in.nextDouble();
            y[i] = in.nextDouble();
        }
        double length = 2 * Math.PI * R;
        for (int i = 0; i < N; i++) {
            length += Math.sqrt((x[i] - x[(i + 1) % N]) * (x[i] - x[(i + 1) % N]) + (y[i] - y[(i + 1) % N]) * (y[i] - y[(i + 1) % N]));
        }
        System.out.printf("%.2f\n", length);
    }
}
