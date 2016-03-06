package P2608__Soundex;

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
        int codes[] = {
            0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5, 5, 0, 1, 2, 6, 2, 3, 0, 1, 0,
            2, 0, 2};
        while (cin.hasNext() == true) {
            String word = cin.next();
            int previous = 0;
            for (int i = 0; i < word.length(); i++) {
                int current = codes[word.charAt(i) - 'A'];
                if (current != 0 && current != previous) {
                    System.out.print(current);
                }
                previous = current;
            }
            System.out.println();
        }
    }
}
