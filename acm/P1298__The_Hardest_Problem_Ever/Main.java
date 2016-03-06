package P1298__The_Hardest_Problem_Ever;

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
        do {
            String line = cin.nextLine();
            if (line.equals("ENDOFINPUT") == true) {
                break;
            }
            StringBuffer str = new StringBuffer(cin.nextLine());
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    char temp = (char) ( (ch - 'A' + 21) % 26 + 'A');
                    str.setCharAt(i, temp);
                }
            }
            System.out.println(str);
            cin.nextLine();
        }
        while (true);
    }
}
