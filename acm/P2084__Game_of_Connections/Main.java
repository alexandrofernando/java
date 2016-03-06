package P2084__Game_of_Connections;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-2
 * Time: 20:08:04
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        BigInteger results[] = new BigInteger[101];
        results[0] = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            results[i] = BigInteger.ZERO;
            for (int j = 0; j <= i * 2 - 2; j += 2) {
                results[i] = results[i].add(results[j / 2].multiply(results[(i * 2 - 2 - j) / 2]));
            }
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == -1) {
                break;
            }
            System.out.println(results[n]);
        }
    }
}
