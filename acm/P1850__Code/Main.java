package P1850__Code;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2009-1-12
 * Time: 23:16:31
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        boolean legal = true;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) >= word.charAt(i + 1)) {
                legal = false;
                break;
            }
        }
        if (legal) {
            int code = 1;
            for (int i = 1; i < word.length(); i++) {
                code += C(26, i);
            }
            int previous = 'a' - 1;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                for (int j = previous + 1; j < ch; j++) {
                    code += C('z' - j, word.length() - i - 1);
                }
                previous = ch;
            }
            System.out.println(code);
        } else {
            System.out.println(0);
        }
    }

    static int C(int n, int m) {
        long result = 1;
        for (int i = n; i > n - m; i--) {
            result *= i;
        }
        for (int i = 1; i <= m; i++) {
            result /= i;
        }
        if (result < 0) {
            int a = 1;
        }
        return (int) result;
    }
}
