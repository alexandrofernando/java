package P1317__Do_The_Untwist;

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
        while (true) {
            int key = cin.nextInt();
            if (key == 0) {
                break;
            }
            String twisted = cin.next();
            int n = twisted.length();
            StringBuffer untwisted = new StringBuffer();
            untwisted.setLength(n);
            for (int i = 0; i < n; i++) {
                int ciphercode = encode(twisted.charAt(i));
                int plaincode = (ciphercode + i) % 28;
                int plainIndex = key * i % n;
                char plainChar = decode(plaincode);
                untwisted.setCharAt(plainIndex, plainChar);
            }
            System.out.println(untwisted);
        }
    }

    static int encode(char ch) {
        if (ch == '_') {
            return 0;
        } else if (ch == '.') {
            return 27;
        } else {
            return ch - 'a' + 1;
        }
    }

    static char decode(int code) {
        if (code == 0) {
            return '_';
        } else if (code == 27) {
            return '.';
        } else {
            return (char) (code - 1 + 'a');
        }
    }
}
