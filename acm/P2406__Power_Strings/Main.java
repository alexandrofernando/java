package P2406__Power_Strings;

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
    static String s;
    static int length;
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (true) {
            s = cin.next();
            if (s.equals(".") == true) {
                break;
            }
            length = s.length();
            int result = 0;
            for (int i = 1; i * i <= length; i++) {
                if (length % i == 0) {
                    if (check(length / i) == true) {
                        result = length / i;
                        break;
                    } else if (check(i) == true) {
                        result = i;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static boolean check(int n) {
        int part = length / n;
        for (int i = 0; i < part; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(j * part + i) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
