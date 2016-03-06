package P2059__Watchdog;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-16
 * Time: 23:41:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int S = in.nextInt();
            int H = in.nextInt();
            int x[] = new int[H];
            int y[] = new int[H];
            for (int i = 0; i < H; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            boolean find = false;
            for (int i = 0; i <= S; i++) {
                for (int j = 0; j <= S; j++) {
                    double max = 0;
                    boolean power = true;
                    for (int k = 0; k < H; k++) {
                        if (i == x[k] && j == y[k]) {
                            power = false;
                            break;
                        }
                        double distance = Math.sqrt((i - x[k]) * (i - x[k]) + (j - y[k]) * (j - y[k]));
                        if (distance > max) {
                            max = distance;
                        }
                    }
                    if (power == true && i >= max && i + max <= S && j >= max && j + max <= S) {
                        System.out.println(i + " " + j);
                        find = true;
                        break;
                    }
                }
                if (find == true) {
                    break;
                }
            }
            if (find == false) {
                System.out.println("poodle");
            }
        }
    }
}
