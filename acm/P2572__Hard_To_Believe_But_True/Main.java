package P2572__Hard_To_Believe_But_True;

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
            int pos1 = str.indexOf('+');
            int pos2 = str.indexOf('=');
            String a = str.substring(0, pos1);
            String b = str.substring(pos1 + 1, pos2);
            String c = str.substring(pos2 + 1);
            int numberA = translate(a);
            int numberB = translate(b);
            int numberC = translate(c);
            if (numberA + numberB == numberC) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
            if (str.equals("0+0=0") == true) {
                break;
            }
        }
    }

    static int translate(String str) {
        int length = str.length();
        int number = 0;
        for (int i = length - 1; i >= 0; i--) {
            number = number * 10 + str.charAt(i) - '0';
        }
        return number;
    }
}
