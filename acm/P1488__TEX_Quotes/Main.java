package P1488__TEX_Quotes;

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
        cin.useDelimiter("");
        int flag = 0;
        while (cin.hasNext() == true) {
            char ch = cin.next().charAt(0);
            if (ch == '"') {
                if (flag == 0) {
                    System.out.print("``");
                } else {
                    System.out.print("''");
                }
                flag = (flag + 1) % 2;
            } else {
                System.out.print(ch);
            }
        }
    }
}
