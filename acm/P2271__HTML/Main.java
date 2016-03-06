package P2271__HTML;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-8-16
 * Time: 7:12:15
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int pos = 0;
        while (in.hasNext() == true) {
            String word = in.next();
            if (word.equals("<br>") == true) {
                System.out.println();
                pos = 0;
            } else if (word.equals("<hr>") == true) {
                if (pos != 0) {
                    System.out.println();
                }
                for (int i = 0; i < 80; i++) {
                    System.out.print("-");
                }
                System.out.println();
                pos = 0;
            } else {
                if (pos == 0) {
                    System.out.print(word);
                    pos = word.length();
                } else if (pos + word.length() + 1 <= 80) {
                    System.out.print(" " + word);
                    pos += word.length() + 1;
                } else {
                    System.out.println();
                    System.out.print(word);
                    pos = word.length();
                }
            }
        }
        System.out.println();
    }
}
