package P3199__Uncle_Jack;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 7:42:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            int D = in.nextInt();
            if (N == 0 && D == 0) {
                break;
            }
            BigInteger result = new BigInteger(N + "");
            result = result.pow(D);
            System.out.println(result);
        }
    }
}
