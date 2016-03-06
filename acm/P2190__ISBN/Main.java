package P2190__ISBN;

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
        String str = cin.next();
        int sum = 0;
        int factor = 0;
        for (int i = 0; i < 10; i++) {
            char ch = str.charAt(i);
            if (ch == '?') {
                factor = 10 - i;
            } else if (ch == 'X') {
                sum += 10;
            } else {
                sum += (ch - '0') * (10 - i);
            }
        }
        int result = -1;
        int top;
        if (factor == 1) {
            top = 10;
        } else {
            top = 9;
        }
        for (int i = 0; i <= top; i++) {
            if ((sum + i * factor) % 11 == 0) {
                result = i;
                break;
            }
        }
        if (result != 10) {
            System.out.println(result);
        } else {
            System.out.println("X");
        }
    }
}
