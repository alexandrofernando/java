package P2313__Sequence;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-23
 * Time: 21:19:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        int B[] = new int[N];
        B[0] = A[0];
        B[N - 1] = A[N - 1];
        for (int i = 1; i < N - 1; i++) {
            B[i] = middle(B[i - 1], A[i], A[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            result += Math.abs(B[i] - A[i]) + Math.abs(B[i] - B[i + 1]);
        }
        System.out.println(result);
    }

    static int middle(int a, int b, int c) {
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        } else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        } else {
            return c;
        }
    }
}
