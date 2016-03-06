package P1454__Factorial_Frequencies;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-23
 * Time: 22:34:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                factorial = factorial.multiply(new BigInteger(i + ""));
            }
            String str = factorial.toString();
            int counts[] = new int[10];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - '0']++;
            }
            System.out.println(n + "! --");
            for (int i = 0; i < 10; i++) {
                System.out.printf("   (%d)%5d", i, counts[i]);
                if (i == 4 || i == 9) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
