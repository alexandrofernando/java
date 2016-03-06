package P1565__Skew_Binary;

import java.util.Scanner;
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
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        do {
            String str = cin.next();
            if (str.equals("0") == true) {
                break;
            }
            int length = str.length();
            int result = 0;
            for (int i = length - 1; i >= 0; i--) {
                result += (str.charAt(i) - '0') * (Math.pow(2, length - i) - 1);
            }
            System.out.println(result);
        }
        while (true);
    }
}
