package P2028__When_Can_We_Meet;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 6:45:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            int Q = in.nextInt();
            if (N == 0 && Q == 0) {
                break;
            }
            int counts[] = new int[100];
            for (int i = 0; i < N; i++) {
                int M = in.nextInt();
                for (int j = 0; j < M; j++) {
                    counts[in.nextInt()]++;
                }
            }
            int max = 0;
            for (int i = 1; i < 100; i++) {
                if (counts[i] > counts[max]) {
                    max = i;
                }
            }
            if (counts[max] >= Q) {
                System.out.println(max);
            } else {
                System.out.println(0);
            }
        }
    }
}
