package P1001__Exponentiation;

import java.util.Scanner;
import java.math.BigDecimal;
import java.io.File;

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
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            if (cin.hasNextBigDecimal() == false) {
                break;
            }
            BigDecimal R = cin.nextBigDecimal();
            int n = cin.nextInt();
            BigDecimal result = R.pow(n);
            String str = result.toPlainString();
            while (str.charAt(0) == '0') {
                str = str.substring(1);
            }
            if (str.indexOf('.') != -1) {
                while (str.charAt(str.length() - 1) == '0') {
                    str = str.substring(0, str.length() - 1);
                }
            }
            if (str.charAt(str.length() - 1) == '.') {
                str = str.substring(0, str.length() - 1);
            }
            System.out.println(str);
        }
    }
}
