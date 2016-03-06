package P1126__Simply_Syntax;

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
            String str = cin.next();
            int count = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                char ch = str.charAt(i);
                if (ch >= 'p' && ch <= 'z') {
                    count++;
                }
                else if (ch == 'C' || ch == 'D' || ch == 'E' || ch == 'I') {
                    count--;
                }
                else if (ch != 'N') {
                    count = 0;
                    break;
                }
                if (count <= 0) {
                    break;
                }
            }
            if (count == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
