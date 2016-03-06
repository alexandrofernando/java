package P2586__Y2K_Accounting_Bug;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-2-15
 * Time: 22:25:26
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int surplus = in.nextInt();
            int deficit = in.nextInt();
            int max = -1;
            for (int i = 0; i < 4096; i++) {
                int balances[] = decode(i, surplus, deficit);
                boolean legal = true;
                for (int j = 0; j < 8; j++) {
                    if (sum(balances, j, j + 5) >= 0) {
                        legal = false;
                        break;
                    }
                }
                if (legal == false) {
                    continue;
                }
                max = Math.max(max, sum(balances, 0, 12));
            }
            if (max >= 0) {
                System.out.println(max);
            } else {
                System.out.println("Deficit");
            }
        }
    }

    static int sum(int a[], int begin, int end) {
        int total = 0;
        for (int i = begin; i < end; i++) {
            total += a[i];
        }
        return total;
    }

    static int[] decode(int code, int surplus, int deficit) {
        int balances[] = new int[12];
        for (int i = 0; i < 12; i++) {
            if (code % 2 == 0) {
                balances[i] = surplus;
            } else {
                balances[i] = -deficit;
            }
            code /= 2;
        }
        return balances;
    }
}
