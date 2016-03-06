package P2685__Numeral_System;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int a = integer(cin.next());
            int b = integer(cin.next());
            System.out.println(mcxi(a + b));
        }
    }

    static int integer(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int digit = 1;
            if (ch >= '2' && ch <= '9') {
                digit = ch - '0';
                ch = str.charAt(i + 1);
                i++;
            }
            if (ch == 'm') {
                result += digit * 1000;
            } else if (ch == 'c') {
                result += digit * 100;
            } else if (ch == 'x') {
                result += digit * 10;
            } else if (ch == 'i') {
                result += digit;
            }
        }
        return result;
    }

    static String mcxi(int number) {
        String result = "";
        if (number >= 1000) {
            if (number < 2000) {
                result += "m";
            } else {
                result += (number / 1000) + "m";
            }
            number %= 1000;
        }
        if (number >= 100) {
            if (number < 200) {
                result += "c";
            } else {
                result += (number / 100) + "c";
            }
            number %= 100;
        }
        if (number >= 10) {
            if (number < 20) {
                result += "x";
            } else {
                result += (number / 10) + "x";
            }
            number %= 10;
        }
        if (number == 1) {
            result += "i";
        } else if (number > 1) {
            result += number + "i";
        }
        return result;
    }
}
