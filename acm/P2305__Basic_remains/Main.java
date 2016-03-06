package P2305__Basic_remains;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-2-10
 * Time: 20:48:48
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int b = in.nextInt();
            if (b == 0) {
                break;
            }
            BigInteger p = in.nextBigInteger(b);
            BigInteger m = in.nextBigInteger(b);
            BigInteger result = p.mod(m);
            System.out.println(result.toString(b));
        }
    }
}
