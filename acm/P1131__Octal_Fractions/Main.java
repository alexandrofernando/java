package P1131__Octal_Fractions;

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
        while (cin.hasNext() == true) {
            String str = cin.next();
            System.out.print(str + " [8] = ");
            BigDecimal temp = new BigDecimal(0);
            for (int i = 2; i < str.length(); i++) {
                int add = str.charAt(i) - '0';
                BigDecimal temp1 = temp.multiply(new BigDecimal(1000));
                BigDecimal temp2 = new BigDecimal(add);
                for (int j = 0; j < i - 1; j++) {
                    temp2 = temp2.multiply(new BigDecimal(125));
                }
                temp = temp1.add(temp2);
            }
            int length = (str.length() - 2) * 3;
            String result = temp.toPlainString();
            int append = length - result.length();
            for (int i = 0; i < append; i++) {
                result = "0" + result;
            }
            result = "0." + result;
            do {
                int len = result.length();
                if (result.charAt(len - 1) != '0') {
                    break;
                }
                result = result.substring(0, len - 1);
            }
            while (true);
            System.out.println(result + " [10]");
        }
    }
}
