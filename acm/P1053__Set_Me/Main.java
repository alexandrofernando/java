package P1053__Set_Me;

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
    static String cards[] = new String[12];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        boolean firstTest = true;
        while (cin.hasNext() == true) {
            if (firstTest == true) {
                firstTest = false;
            }
            else {
                System.out.println();
            }
            System.out.print("CARDS: ");
            for (int i = 0; i < cards.length; i++) {
                cards[i] = cin.next();
                System.out.print(" " + cards[i]);
            }
            System.out.println();
            int serial = 1;
            for (int i = 0; i < cards.length; i++) {
                for (int j = i + 1; j < cards.length; j++) {
                    for (int k = j + 1; k < cards.length; k++) {
                        if (isSet(i, j, k) == true) {
                            if (serial == 1) {
                                System.out.print("SETS:   ");
                            }
                            else {
                                System.out.print("        ");
                            }
                            System.out.print(serial + ".");
                            if (serial < 10) {
                                System.out.print("  ");
                            }
                            else if (serial < 100) {
                                System.out.print(" ");
                            }
                            System.out.println(cards[i] + " " + cards[j] + " " +
                                               cards[k]);
                            serial++;
                        }
                    }
                }
            }
            if (serial == 1) {
                System.out.println("SETS:   *** None Found ***");
            }
        }
    }

    static boolean isSet(int a, int b, int c) {
        for (int i = 0; i < cards[0].length(); i++) {
            if ( (cards[a].charAt(i) == cards[b].charAt(i) &&
                  cards[a].charAt(i) != cards[c].charAt(i)) ||
                (cards[b].charAt(i) == cards[c].charAt(i) &&
                 cards[b].charAt(i) != cards[a].charAt(i)) ||
                (cards[c].charAt(i) == cards[a].charAt(i) &&
                 cards[c].charAt(i) != cards[b].charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
