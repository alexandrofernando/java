package P3138__ACM_Team_Selection;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 7:23:04
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = 1;
        while (true) {
            int S = in.nextInt();
            int T = in.nextInt();
            int M = in.nextInt();
            if (S == 0 && T == 0 && M == 0) {
                break;
            }
            int schools[] = new int[S + 1];
            for (int i = 0; i < S; i++) {
                int school = in.nextInt();
                schools[school] = in.nextInt() + in.nextInt();
            }
            boolean condition1[] = new boolean[S + 1];
            for (int i = 0; i < T; i++) {
                int school = in.nextInt();
                if (in.nextInt() >= M) {
                    condition1[school] = true;
                }
            }
            int total = 0;
            for (int i = 1; i <= S; i++) {
                total += schools[i];
                if (condition1[i] == true) {
                    total++;
                }
            }
            System.out.println("Case " + test + ": " + total);
            test++;
        }
    }
}
