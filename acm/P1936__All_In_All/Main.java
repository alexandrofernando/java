package P1936__All_In_All;

import java.util.Scanner;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext() == true) {
            String S = cin.next();
            String T = cin.next();
            int pos = 0;
            boolean power = true;
            for (int i = 0; i < S.length(); i++) {
                while (pos < T.length() && T.charAt(pos) != S.charAt(i)) {
                    pos++;
                }
                if (pos == T.length()) {
                    power = false;
                    break;
                }
                pos++;
            }
            if (power == true) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}
