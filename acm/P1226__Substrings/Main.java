package P1226__Substrings;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-9-16
 * Time: 7:01:28
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            String strings[] = new String[n];
            int min = 0;
            for (int i = 0; i < n; i++) {
                strings[i] = in.next();
                if (strings[i].length() < strings[min].length()) {
                    min = i;
                }
            }
            String temp = strings[0];
            strings[0] = strings[min];
            strings[min] = temp;
            boolean find = false;
            for (int i = strings[0].length(); i >= 0; i--) {
                for (int j = 0; j + i <= strings[0].length(); j++) {
                    String X = strings[0].substring(j, j + i);
                    String Xrev = new StringBuffer(X).reverse().toString();
                    boolean power = true;
                    for (int k = 1; k < n; k++) {
                        if (strings[k].indexOf(X) == -1 && strings[k].indexOf(Xrev) == -1) {
                            power = false;
                            break;
                        }
                    }
                    if (power == true) {
                        System.out.println(i);
                        find = true;
                        break;
                    }
                }
                if (find == true) {
                    break;
                }
            }
        }
    }
}
