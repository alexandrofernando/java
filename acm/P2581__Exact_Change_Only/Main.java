package P2581__Exact_Change_Only;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static boolean find;
    static int resultA;
    static int resultB;
    static int resultC;
    static int resultD;
    static int coin;
    static int B;
    static int C;
    static int D;
    static int E;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextDouble() == true) {
            int A = (int) Math.round(cin.nextDouble() * 100);
            B = cin.nextInt();
            C = cin.nextInt();
            D = cin.nextInt();
            E = cin.nextInt();
            find = false;
            coin = Integer.MAX_VALUE;
            search(A, 0, 0, 0, 0, 0);
            if (find == true) {
                System.out.println(resultA + " " + resultB + " " + resultC +
                                   " " + resultD);
            } else {
                System.out.println("NO EXACT CHANGE");
            }
        }
    }

    static void search(int target, int depth, int curA, int curB, int curC,
                       int curD) {
        if (depth == 4) {
            find = true;
            resultA = curA;
            resultB = curB;
            resultC = curC;
            resultD = curD;
            coin = curA + curB + curC + curD;
        } else if (depth == 0) {
            int bottom = (int) Math.ceil(Math.max(target - C * 10 - D * 5 - E,
                                                  0) / 25.0);
            int top = Math.min(Math.min(coin - 1, target / 25), B);
            for (int i = top; i >= bottom; i--) {
                search(target - i * 25, 1, i, curB, curC, curD);
            }
        } else if (depth == 1) {
            int bottom = (int) Math.ceil(Math.max(target - D * 5 - E, 0) / 10.0);
            int top = Math.min(Math.min(coin - curA - 1, target / 10), C);
            for (int i = top; i >= bottom; i--) {
                search(target - i * 10, 2, curA, i, curC, curD);
            }
        } else if (depth == 2) {
            int bottom = (int) Math.ceil(Math.max(target - E, 0) / 5.0);
            int top = Math.min(Math.min(coin - curA - curB - 1, target / 5), D);
            for (int i = top; i >= bottom; i--) {
                search(target - i * 5, 3, curA, curB, i, curD);
            }
        } else if (depth == 3) {
            if (curA + curB + curC + target < coin) {
                search(0, 4, curA, curB, curC, target);
            }
        }
    }
}
