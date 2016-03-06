package P3340__Barbara_Bennett_s_Wild_Numbers;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-2
 * Time: 0:01:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String W = in.next();
            if (W.equals("#") == true) {
                break;
            }
            String X = in.next();
            int match = 0;
            int n = W.length();
            long result = 1;
            for (int i = 0; i < n; i++) {
                char ch1 = W.charAt(i);
                char ch2 = X.charAt(i);
                if (ch1 == '?') {
                    if (match == 0) {
                        result = (result - 1) * 10 + ('9' - ch2 + 1);
                    } else {
                        result *= 10;
                    }
                } else if (match == 0) {
                    if (ch1 < ch2) {
                        result--;
                        match = -1;
                    } else if (ch1 > ch2) {
                        match = 1;
                    }
                }
            }
            if (match == 0) {
                result--;
            }
            System.out.println(result);
        }
    }
}
