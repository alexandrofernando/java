package P3302__Subsequence;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-4
 * Time: 19:25:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            String s1 = in.next();
            String s2 = in.next();
            if (isSub(s1, s2) == true || isSub(s1, new StringBuffer(s2).reverse().toString()) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isSub(String s1, String s2) {
        int pos = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            while (pos < s1.length() && s1.charAt(pos) != ch) {
                pos++;
            }
            if (pos == s1.length()) {
                return false;
            }
            pos++;
        }
        return true;
    }
}
