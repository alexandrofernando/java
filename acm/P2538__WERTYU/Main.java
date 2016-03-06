package P2538__WERTYU;

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
        char symbols[] = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                         '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
                         'P', '[', ']', '\\', 'A', 'S', 'D', 'F', 'G', 'H', 'J',
                         'K', 'L', ';', '\'', 'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                         ',', '.', '/'};
        while (cin.hasNext() == true) {
            char ch = cin.next().charAt(0);
            if (ch == ' ' || ch == '\n') {
                System.out.print(ch);
            } else {
                for (int i = 0; i < symbols.length; i++) {
                    if (symbols[i] == ch) {
                        System.out.print(symbols[i - 1]);
                    }
                }
            }
        }
    }
}
