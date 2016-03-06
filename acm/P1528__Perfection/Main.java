package P1528__Perfection;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        System.out.println("PERFECTION OUTPUT");
        while (true) {
            int integer = cin.nextInt();
            if (integer == 0) {
                break;
            }
            int sum = 0;
            for (int i = 1; i * 2 <= integer && sum <= integer; i++) {
                if (integer % i == 0) {
                    sum += i;
                }
            }
            System.out.printf("%5d  ", integer);
            if (sum < integer) {
                System.out.println("DEFICIENT");
            } else if (sum > integer) {
                System.out.println("ABUNDANT");
            } else {
                System.out.println("PERFECT");
            }
        }
        System.out.println("END OF OUTPUT");
    }
}
