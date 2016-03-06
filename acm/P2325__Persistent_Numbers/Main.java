package P2325__Persistent_Numbers;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2008-4-11
 * Time: 22:40:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            BigInteger number = in.nextBigInteger();
            if (number.toString().equals("-1") == true) {
                break;
            }
            if (number.toString().equals("0") == true) {
                System.out.println(10);
            } else if (number.toString().equals("1") == true) {
                System.out.println(11);
            } else {
                int total = 0;
                int counts[] = new int[10];
                for (int i = 9; i >= 2; i--) {
                    BigInteger temp = new BigInteger(i + "");
                    while (number.mod(temp).compareTo(BigInteger.ZERO) == 0) {
                        number = number.divide(temp);
                        counts[i]++;
                        total++;
                    }
                }
                if (number.compareTo(BigInteger.ONE) == 0) {
                    if (total == 1) {
                        System.out.print(1);
                    }
                    for (int i = 2; i <= 9; i++) {
                        for (int j = 0; j < counts[i]; j++) {
                            System.out.print(i);
                        }
                    }
                    System.out.println();
                } else {
                    System.out.println("There is no such number.");
                }
            }
        }
    }
}
