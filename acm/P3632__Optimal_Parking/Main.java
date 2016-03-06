package P3632__Optimal_Parking;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 15:15:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int store = in.nextInt();
                min = Math.min(min, store);
                max = Math.max(max, store);
            }
            System.out.println((max - min) * 2);
        }
    }
}
