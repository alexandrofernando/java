package P3331__The_Idiot_of_the_Year_Contest;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-20
 * Time: 7:54:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int day = in.nextInt();
            int digit = in.nextInt();
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= day; i++) {
                factorial = factorial.multiply(new BigInteger(i + ""));
            }
            String str = factorial.toString();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) - '0' == digit) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
