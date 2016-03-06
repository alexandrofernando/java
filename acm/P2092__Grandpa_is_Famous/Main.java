package P2092__Grandpa_is_Famous;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-21
 * Time: 22:33:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            int counts[] = new int[10001];
            for (int i = 0; i < N * M; i++) {
                counts[in.nextInt()]++;
            }
            int max = 0;
            for (int i = 1; i <= 10000; i++) {
                if (counts[i] > max) {
                    max = counts[i];
                }
            }
            int second = 0;
            for (int i = 1; i <= 10000; i++) {
                if (counts[i] > second && counts[i] != max) {
                    second = counts[i];
                }
            }
            for (int i = 1; i <= 10000; i++) {
                if (counts[i] == second) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
