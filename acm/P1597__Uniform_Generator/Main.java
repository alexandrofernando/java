package P1597__Uniform_Generator;

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
        while (cin.hasNextInt() == true) {
            int step = cin.nextInt();
            int mod = cin.nextInt();
            System.out.printf("%10d%10d%4s", step, mod, "");
            if (gcd(step, mod) == 1) {
                System.out.println("Good Choice");
            } else {
                System.out.println("Bad Choice");
            }
            System.out.println();
        }
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        } while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
