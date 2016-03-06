package P2192__Zipper;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-31
 * Time: 20:20:42
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static String str1;
    static String str2;
    static String str3;
    static int forms[][];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            str1 = in.next();
            str2 = in.next();
            str3 = in.next();
            forms = new int[str1.length() + 1][str2.length() + 1];
            if (search(0, 0) == true) {
                System.out.println("Data set " + t + ": yes");
            } else {
                System.out.println("Data set " + t + ": no");
            }
        }
    }

    static boolean search(int index1, int index2) {
        int index3 = index1 + index2;
        if (index3 == str3.length()) {
            return true;
        }
        if (forms[index1][index2] == 1) {
            return true;
        } else if (forms[index1][index2] == -1) {
            return false;
        }
        char ch = str3.charAt(index3);
        if (index1 < str1.length() && str1.charAt(index1) == ch && search(index1 + 1, index2) == true) {
            forms[index1][index2] = 1;
            return true;
        }
        if (index2 < str2.length() && str2.charAt(index2) == ch && search(index1, index2 + 1) == true) {
            forms[index1][index2] = 1;
            return true;
        }
        forms[index1][index2] = -1;
        return false;
    }
}
