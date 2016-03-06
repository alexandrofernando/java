package P3404__Bridge_over_a_rough_river;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-6-13
 * Time: 22:01:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int speeds[] = new int[n];
        for (int i = 0; i < n; i++) {
            speeds[i] = in.nextInt();
        }
        Arrays.sort(speeds);
        int time = 0;
        while (n >= 4) {
            if (2 * speeds[1] >= speeds[0] + speeds[n - 2]) {
                time += speeds[n - 1] + speeds[0] + speeds[n - 2] + speeds[0];
            } else if (2 * speeds[1] < speeds[0] + speeds[n - 2]) {
                time += speeds[1] + speeds[0] + speeds[n - 1] + speeds[1];
            }
            n -= 2;
        }
        if (n == 1 || n == 2) {
            time += speeds[n - 1];
        } else if (n == 3) {
            time += speeds[2] + speeds[0] + speeds[1];
        }
        System.out.println(time);
    }
}
