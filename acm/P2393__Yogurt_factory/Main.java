package P2393__Yogurt_factory;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-2
 * Time: 4:52:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int C[] = new int[N];
        int Y[] = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = in.nextInt();
            Y[i] = in.nextInt();
        }
        long cost = 0;
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (C[j] + (i - j) * S < min) {
                    min = C[j] + (i - j) * S;
                }
            }
            cost += min * Y[i];
        }
        System.out.println(cost);
    }
}
