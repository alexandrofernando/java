package P2247__Humble_Numbers;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        long a = 1;
        for (int i = 0; i <= 30; i++) {
            long b = 1;
            for (int j = 0; j <= 19; j++) {
                if (a * b > 2000000000) {
                    break;
                }
                long c = 1;
                for (int k = 0; k <= 13; k++) {
                    if (a * b * c > 2000000000) {
                        break;
                    }
                    long d = 1;
                    for (int p = 0; p <= 11; p++) {
                        if (a * b * c * d > 2000000000) {
                            break;
                        }
                        sequence.add((int) (a * b * c * d));
                        d *= 7;
                    }
                    c *= 5;
                }
                b *= 3;
            }
            a *= 2;
        }
        Collections.sort(sequence);
        while (true) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            if (n % 10 == 1 && n % 100 != 11) {
                System.out.print("The " + n + "st humble number is ");
            } else if (n % 10 == 2 && n % 100 != 12) {
                System.out.print("The " + n + "nd humble number is ");
            } else if (n % 10 == 3 && n % 100 != 13) {
                System.out.print("The " + n + "rd humble number is ");
            } else {
                System.out.print("The " + n + "th humble number is ");
            }
            System.out.println(sequence.get(n - 1) + ".");
        }
    }
}
