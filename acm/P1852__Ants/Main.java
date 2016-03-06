package P1852__Ants;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-17
 * Time: 19:56:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int length = in.nextInt();
            int n = in.nextInt();
            int minTime = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int position = in.nextInt();
                minTime = Math.max(minTime, Math.min(position, length - position));
                if (position < min) {
                    min = position;
                }
                if (position > max) {
                    max = position;
                }
            }
            int maxTime = Math.max(length - min, max);
            System.out.println(minTime + " " + maxTime);
        }
    }
}
