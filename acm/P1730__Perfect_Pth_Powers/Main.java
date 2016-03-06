package P1730__Perfect_Pth_Powers;

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
        while (true) {
            long x = cin.nextLong();
            if (x == 0) {
                break;
            }
            boolean negative = false;
            if (x < 0) {
                x = -x;
                negative = true;
            }
            for (int p = 32; p >= 1; p--) {
                if (negative == true && p % 2 == 0) {
                    continue;
                }
                long root = Math.round(Math.pow(x, 1.0 / p));
                long temp = 1;
                for (int i = 0; i < p; i++) {
                    temp *= root;
                }
                if (temp == x) {
                    System.out.println(p);
                    break;
                }
            }
        }
    }
}
