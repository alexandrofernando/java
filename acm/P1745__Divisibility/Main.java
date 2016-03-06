package P1745__Divisibility;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-30
 * Time: 7:45:53
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int K;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        K = in.nextInt();
        boolean remainders[] = new boolean[K];
        remainders[(in.nextInt() % K + K) % K] = true;
        for (int i = 0; i < N - 1; i++) {
            int number = in.nextInt();
            boolean temp1[] = build(remainders, number);
            boolean temp2[] = build(remainders, -number);
            for (int j = 0; j < K; j++) {
                remainders[j] = temp1[j] || temp2[j];
            }
        }
        if (remainders[0] == true) {
            System.out.println("Divisible");
        } else {
            System.out.println("Not divisible");
        }
    }

    static boolean[] build(boolean previous[], int add) {
        boolean current[] = new boolean[K];
        for (int i = 0; i < K; i++) {
            if (previous[i] == true) {
                current[((i + add) % K + K) % K] = true;
            }
        }
        return current;
    }
}
