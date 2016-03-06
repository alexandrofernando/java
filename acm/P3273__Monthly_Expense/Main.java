package P3273__Monthly_Expense;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-8
 * Time: 0:38:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static int N;
    static int M;
    static int moneys[];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        moneys = new int[N];
        for (int i = 0; i < N; i++) {
            moneys[i] = in.nextInt();
        }
        int top = 1000000000;
        int bottom = 1;
        int result = -1;
        while (bottom <= top) {
            int middle = (bottom + top) / 2;
            if (check(middle) == true) {
                result = middle;
                top = middle - 1;
            } else {
                bottom = middle + 1;
            }
        }
        System.out.println(result);
    }

    static boolean check(int total) {
        int month = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + moneys[i] <= total) {
                sum += moneys[i];
            } else if (moneys[i] > total) {
                return false;
            } else {
                sum = moneys[i];
                month++;
                if (month >= M) {
                    return false;
                }
            }
        }
        return true;
    }
}
