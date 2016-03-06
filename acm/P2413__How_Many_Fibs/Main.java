package P2413__How_Many_Fibs;

import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

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
        BigDecimal f[] = new BigDecimal[500];
        f[0] = new BigDecimal(1);
        f[1] = new BigDecimal(2);
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        } while (true) {
            BigDecimal a = cin.nextBigDecimal();
            BigDecimal b = cin.nextBigDecimal();
            if (a.compareTo(BigDecimal.ZERO) == 0 &&
                b.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
            int count = 0;
            for (int i = 0; i < f.length; i++) {
                if (f[i].compareTo(b) > 0) {
                    break;
                }
                if (f[i].compareTo(a) >= 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
