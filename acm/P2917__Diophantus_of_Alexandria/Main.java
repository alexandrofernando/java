package P2917__Diophantus_of_Alexandria;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-26
 * Time: 1:58:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int result = 1;
            int factor = 2;
            while (factor * factor <= n) {
                int count = 0;
                while (n % factor == 0) {
                    n /= factor;
                    count++;
                }
                result *= (count * 2 + 1);
                if (n == 1) {
                    break;
                }
                if (factor == 2) {
                    factor++;
                } else {
                    factor += 2;
                }
            }
            if (n > 1) {
                result *= 3;
            }
            result = result / 2 + 1;
            System.out.println("Scenario #" + t + ":");
            System.out.println(result);
            System.out.println();
        }
    }
}
