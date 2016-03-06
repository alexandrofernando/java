package P2460__Brownie_Points_I;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-25
 * Time: 9:26:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int x[] = new int[n];
            int y[] = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            int centerX = x[n / 2];
            int centerY = y[n / 2];
            int stan = 0;
            int ollie = 0;
            for (int i = 0; i < n; i++) {
                if (x[i] == centerX || y[i] == centerY) {
                    continue;
                }
                if ((x[i] > centerX && y[i] > centerY) || (x[i] < centerX && y[i] < centerY)) {
                    stan++;
                } else {
                    ollie++;
                }
            }
            System.out.println(stan + " " + ollie);
        }
    }
}
