package P1405__Heritage;

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
        int N = cin.nextInt();
        BigDecimal current = new BigDecimal(2);
        BigDecimal product = new BigDecimal(1);
        for (int i = 0; i < N; i++) {
            System.out.println(current);
            product = product.multiply(current);
            current = product.add(new BigDecimal(1));
        }
    }
}
