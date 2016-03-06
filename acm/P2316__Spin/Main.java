package P2316__Spin;

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
        String str = cin.next();
        int D = str.length();
        int digits[] = new int[D];
        for (int i = 0; i < D; i++) {
            digits[i] = str.charAt(i) - '0';
        } while (cin.hasNext()) {
            str = cin.next();
            for (int i = 0; i < D; i++) {
                digits[i] = (digits[i] + str.charAt(i) - '0') % 10;
            }
        }
        for (int i = 0; i < D; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
