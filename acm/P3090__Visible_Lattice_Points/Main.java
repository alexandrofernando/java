package P3090__Visible_Lattice_Points;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-4
 * Time: 19:44:26
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        int results[] = new int[1001];
        results[1] = 3;
        for (int i = 2; i <= 1000; i++) {
            results[i] = results[i - 1];
            for (int j = 1; j < i; j++) {
                if (GCD(i, j) == 1) {
                    results[i] += 2;
                }
            }
        }
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = in.nextInt();
            System.out.println(t + " " + N + " " + results[N]);
        }
    }

    static int GCD(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
