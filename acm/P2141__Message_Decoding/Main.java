package P2141__Message_Decoding;

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
        String key = cin.next();
        cin.nextLine();
        String message = cin.nextLine();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                System.out.print(key.charAt(ch - 'a'));
            }
            else if (ch >= 'A' && ch <= 'Z') {
                System.out.print( (char) (key.charAt(ch - 'A') - 'a' + 'A'));
            }
            else {
                System.out.print(ch);
            }
        }
    }
}
