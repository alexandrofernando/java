package P3619__Speed_Reading;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-10
 * Time: 22:39:56
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        for (int i = 0; i < K; i++) {
            int S = in.nextInt();
            int T = in.nextInt();
            int R = in.nextInt();
            int cycle = N / (S * T);
            if (cycle * S * T == N) {
                System.out.println(cycle * (T + R) - R);
            } else {
                System.out.println(cycle * (T + R) + (int) Math.ceil((double) (N - cycle * S * T) / S));
            }
        }
    }
}
