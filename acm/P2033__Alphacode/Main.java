package P2033__Alphacode;

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
            String str = cin.next();
            if (str.equals("0") == true) {
                break;
            }
            int length = str.length();
            int prev2 = 0;
            int prev1 = 1;
            int current = 0;
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    current = 1;
                } else {
                    char pre = str.charAt(i - 1);
                    char cur = str.charAt(i);
                    if (cur == '0') {
                        current = prev2;
                    } else if (pre == '1' ||
                               (pre == '2' && cur >= '1' && cur <= '6')) {
                        current = prev2 + prev1;
                    } else {
                        current = prev1;
                    }
                }
                prev2 = prev1;
                prev1 = current;
            }
            System.out.println(current);
        }
    }
}
