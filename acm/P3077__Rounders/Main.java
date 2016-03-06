package P3077__Rounders;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            String str = cin.next();
            if (str.length() == 1) {
                System.out.println(str);
            }
            else {
                String result = "";
                boolean carry = false;
                for (int i = str.length() - 1; i >= 1; i--) {
                    char ch = str.charAt(i);
                    if ( (ch >= '5' && ch <= '9') || (ch == '4' && carry == true)) {
                        carry = true;
                    }
                    else {
                        carry = false;
                    }
                    result = '0' + result;
                }
                char ch0 = str.charAt(0);
                if (carry == false) {
                    result = ch0 + result;
                }
                else if (ch0 == '9') {
                    result = "10" + result;
                }
                else {
                    result = (char) (ch0 + 1) + result;
                }
                System.out.println(result);
            }
        }
    }
}
