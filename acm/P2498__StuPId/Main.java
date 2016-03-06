package P2498__StuPId;

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
        int factors[] = {9, 3, 7};
        for (int t = 1; t <= test; t++) {
            StringBuffer str = new StringBuffer(cin.next());
            int length = str.length();
            int sum = 0;
            int pos = 0;
            int theFactor = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (str.charAt(i) == '?') {
                    pos = i;
                    theFactor = factors[(length - 1 - i) % 3];
                } else {
                    sum += (str.charAt(i) - '0') * factors[(length - 1 - i) % 3];
                }
            }
            for (int i = 0; i < 10; i++) {
                if ((sum + i * theFactor) % 10 == 0) {
                    str.setCharAt(pos, (char) ('0' + i));
                    break;
                }
            }
            System.out.println("Scenario #" + t + ":");
            System.out.println(str);
            System.out.println();
        }
    }
}
