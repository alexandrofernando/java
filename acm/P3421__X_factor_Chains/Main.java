package P3421__X_factor_Chains;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-10-20
 * Time: 7:15:08
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int X = in.nextInt();
            ArrayList<Integer> counts = new ArrayList<Integer>();
            int total = 0;
            for (int i = 2; i * i <= X; i++) {
                int count = 0;
                while (X % i == 0) {
                    count++;
                    X /= i;
                }
                counts.add(count);
                total += count;
            }
            if (X != 1) {
                counts.add(1);
                total += 1;
            }
            int number = 1;
            System.out.print(total);
            for (int i = 0; i < counts.size(); i++) {
                int count = counts.get(i);
                number *= C(total, count);
                total -= count;
            }
            System.out.println(" " + number);
        }
    }

    static int C(int m, int n) {
        if (n + n > m) {
            n = m - n;
        }
        int result = 1;
        for (int i = m; i > m - n; i--) {
            result *= i;
        }
        for (int i = 1; i <= n; i++) {
            result /= i;
        }
        return result;
    }
}
