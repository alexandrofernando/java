package P1090__Chain;

import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    static int rings[];
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        rings = new int[n];
        for (int i = 0; i < n; i++) {
            rings[i] = cin.nextInt();
        }
        BigDecimal count = new BigDecimal(0);
        BigDecimal base = new BigDecimal(2);
        for (int i = 0; i < n; i++) {
            if (rings[i] == 1) {
                BigDecimal temp = base.subtract(new BigDecimal(1));
                count = temp.subtract(count);
            }
            base = base.multiply(new BigDecimal(2));
        }
        System.out.println(count.toPlainString());
    }
}
