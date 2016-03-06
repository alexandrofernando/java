package P3032__Card_Trick;

import java.util.Scanner;
import java.util.ArrayList;

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
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = cin.nextInt();
            ArrayList<Integer> cards = new ArrayList<Integer> ();
            for (int i = n; i >= 1; i--) {
                cards.add(0, i);
                for (int j = 0; j < i; j++) {
                    int temp = cards.get(cards.size() - 1);
                    for (int k = cards.size() - 1; k >= 1; k--) {
                        cards.set(k, cards.get(k - 1));
                    }
                    cards.set(0, temp);
                }
            }
            for (int i = 0; i < cards.size(); i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(cards.get(i));
            }
            System.out.println();
        }
    }
}
