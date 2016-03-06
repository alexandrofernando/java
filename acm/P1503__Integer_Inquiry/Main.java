package P1503__Integer_Inquiry;

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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        BigDecimal sum = new BigDecimal(0);
        do {
            BigDecimal number = cin.nextBigDecimal();
            if (number.compareTo(new BigDecimal(0)) == 0) {
                break;
            }
            sum = sum.add(number);
        }
        while (true);
        System.out.println(sum.toPlainString());
    }
}
